package us.slemjet.leetcode.medium.tasks_601_650;

/**
 * 647. Palindromic Substrings
 */
public class PalindromicSubstrings {

    /**
     * Time: O(n^2) ->  45.89%
     * Space:O(n^2) ->  19.44%
     */
    public int countSubstrings(String s) {

        int count = 0;

        int size = s.length();
        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[size][size]; // Stores info if palindrome is between indices

        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
            for (int j = 0; j <= i; j++) {
                if (chars[i] == chars[j]) {
                    // Palindrome candidate
                    if (i - j <= 1 || (i - j > 1 && dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
