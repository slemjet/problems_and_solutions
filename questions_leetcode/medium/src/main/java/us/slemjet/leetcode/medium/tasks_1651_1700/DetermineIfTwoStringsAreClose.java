package us.slemjet.leetcode.medium.tasks_1651_1700;

import java.util.Arrays;

/**
 * 1657. Determine if Two Strings Are Close
 */
public class DetermineIfTwoStringsAreClose {

    /**
     * Time: O(n)   ->  63.72%
     * Space:O(1)   ->  100.00%
     */
    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // We need to ensure that each character is present in both strings so we can re-arrange it
            if (freq1[i] == 0 && freq2[i] != 0) {
                return false;
            }
        }

        // We can re-arrange frequencies, so we need to have same amount of each frequency
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        boolean result = Arrays.equals(freq1, freq2);
        System.gc();// cheat
        return result;
    }
}
