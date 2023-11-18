package us.slemjet.leetcode.medium.tasks_1901_1950;

import java.util.Arrays;

/**
 * 1930. Unique Length-3 Palindromic Subsequences
 */
public class UniqueLength3PalindromicSubsequences {

    /**
     * Time: O(n)  -> 23.62%
     * Space: O(1) -> 22.52%
     */
    public int countPalindromicSubsequence(String s) {

        int[] firstCharIdx = new int[26];
        int[] lastCharIdx = new int[26];

        Arrays.fill(firstCharIdx, Integer.MAX_VALUE);
        Arrays.fill(lastCharIdx, -1);

        // Populate arrays of first and last occurrence of a char
        for (int i = 0; i < s.length(); i++) {
            int charAt = s.charAt(i) - 'a';
            lastCharIdx[charAt] = i;
            firstCharIdx[charAt] = Math.min(firstCharIdx[charAt], i);
        }

        int count = 0;

        // Count how many unique chars between boundaries so they can form size 3 palindrome
        for (int i = 0; i < firstCharIdx.length; i++) {
            if (firstCharIdx[i] < lastCharIdx[i] && firstCharIdx[i] != Integer.MAX_VALUE && lastCharIdx[i] != -1){
                String innerChars = s.substring(firstCharIdx[i] + 1, lastCharIdx[i]);
                int currentCount = (int) innerChars.chars().distinct().count();
                count += currentCount;
            }
        }

        return count;
    }
}
