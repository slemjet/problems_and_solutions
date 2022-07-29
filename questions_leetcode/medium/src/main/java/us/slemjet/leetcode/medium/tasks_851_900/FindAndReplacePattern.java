package us.slemjet.leetcode.medium.tasks_851_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 890. Find and Replace Pattern
 */
public class FindAndReplacePattern {

    /**
     * Runtime: 98.01%
     * Memory Usage: 78.07%
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        int[] patternCount = new int[26];
        for (char pChar : pattern.toCharArray()) {
            int pIndex = pChar - 'a';
            patternCount[pIndex]++;
        }

        for (String word : words) {
            boolean isValid = true;
            boolean[] usedPatternChars = new boolean[26];
            Character[] mappedValues = new Character[26];
            int[] currentPatternCount = Arrays.copyOf(patternCount, patternCount.length);
            for (int i = 0; i < word.length(); i++) {
                char pChar = pattern.charAt(i);
                char wChar = word.charAt(i);
                int wIndex = wChar - 'a';
                if (mappedValues[wIndex] == null) {
                    // Need new mapping
                    if (usedPatternChars[pChar - 'a']) {
                        // Was already mapped - cannot remap -> Error
                        isValid = false;
                        break;
                    } else {
                        mappedValues[wIndex] = pChar; // Map new value
                        usedPatternChars[pChar - 'a'] = true;
                    }
                }

                currentPatternCount[mappedValues[wIndex] - 'a']--;
                if (currentPatternCount[mappedValues[wIndex] - 'a'] < 0) {
                    // Too many usages of char -> Error
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result.add(word);
            }
        }

        return result;
    }
}
