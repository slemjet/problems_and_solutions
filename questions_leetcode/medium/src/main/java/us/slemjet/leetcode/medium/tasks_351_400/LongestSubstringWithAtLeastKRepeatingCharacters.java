package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * Runtime: 51.75%
     * Memory Usage: 86.22%
     */
    public int longestSubstring(String s, int k) {
        int maxLength = 0;
        int[] frequency = new int[26];
        // Check for all possible number of unique characters
        for (int i = 1; i <= 26; i++) {
            Arrays.fill(frequency, 0);
            // Use 2 pointers moving right if we need more unique chars and left if we need less
            int begin = 0, end = 0, uniqueChar = 0;
            while (end < s.length()) {
                boolean valid = true;

                int endCharIdx = s.charAt(end) - 'a';
                if (frequency[endCharIdx] == 0) uniqueChar++; // Adding new unique char
                frequency[endCharIdx]++;
                end++;

                // We need exactly i unique characters
                while (uniqueChar > i) {
                    int beginCharIdx = s.charAt(begin) - 'a';
                    if (frequency[beginCharIdx] == 1) uniqueChar--; // Removing unique char
                    begin++;
                    frequency[beginCharIdx]--;
                }

                // if the string has any character with less than k occurrences, the string is invalid
                for (int j = 0; j < 26; j++)
                    if (frequency[j] > 0 && frequency[j] < k) {
                        valid = false;
                        break;
                    }

                if (valid) {
                    // Result is valid - check if is longest
                    maxLength = Math.max(maxLength, end - begin);
                }
            }
        }
        return maxLength;
    }

    /**
     * Runtime: 28.17%
     * Memory Usage: 17.88%
     */
    public int longestSubstring2(String s, int k) {

        // Count how many occurrences of each char
        Map<Character, Long> frequencyMap = s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Get chars that cannot be included
        Set<Character> incorrectChars = frequencyMap.entrySet().stream().filter(entry -> entry.getValue() < k).map(Map.Entry::getKey).collect(Collectors.toSet());
        // Convert incorrect chars to delimiter regex
        String delimiters = incorrectChars.stream().map(Object::toString).collect(Collectors.joining("|"));

        if (delimiters.isEmpty()) {
            // Full string can be an answer
            return s.length();
        } else {
            // Get potential candidates - strings that do not contain incorrect chars
            String[] candidateStrings = s.split(delimiters);
            // Recursively call this method for each candidate, returning max candidate length
            return Arrays.stream(candidateStrings).map(candidate -> longestSubstring2(candidate, k)).max(Integer::compareTo).orElse(0);
        }
    }
}
