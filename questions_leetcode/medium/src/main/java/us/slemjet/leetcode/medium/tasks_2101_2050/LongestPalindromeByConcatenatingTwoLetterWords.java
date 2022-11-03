package us.slemjet.leetcode.medium.tasks_2101_2050;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {

    /**
     * Runtime: 60.50%
     * Memory Usage: 61.80%
     *
     * Space: O(n)
     * Time: O(n)
     */
    public int longestPalindrome(String[] words) {

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.putIfAbsent(word, 0);
            wordCount.computeIfPresent(word, (s, integer) -> integer + 1);
        }

        int length = 0;
        boolean middle = false;

        for (String word : wordCount.keySet()) {
            Integer count = wordCount.get(word);
            String reversedWord = word.charAt(1) + "" + word.charAt(0);
            if (word.equals(reversedWord)) {
                // palindrome
                length += 2 * 2 * (count / 2);
                if (!middle && count % 2 == 1) {
                    middle = true;
                }
            } else if (wordCount.containsKey(reversedWord) && wordCount.get(reversedWord) > 0) {
                Integer reversedCount = wordCount.get(reversedWord);
                int pairs = Math.min(count, reversedCount);
                length += 2 * 2 * pairs;

                wordCount.put(reversedWord, 0);
            }
        }

        length += middle ? 2 : 0;

        return length;
    }
}
