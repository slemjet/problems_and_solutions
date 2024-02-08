package us.slemjet.leetcode.easy.tasks_1101_1150;

/**
 * 1143. Longest Common Subsequence
 */
public class LongestCommonSubsequence {

    /**
     * DP Bottom Up
     * Create matrix dp with max common subsequence
     *
     * Runtime: 37.92%
     * Memory Usage: 7.83%
     */
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // Start from 0 to simplify calculation

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
