package us.slemjet.leetcode.medium.tasks_501_550;

/**
 * 516. Longest Palindromic Subsequence
 */
public class LongestPalindromicSubsequence {

    /**
     * DP Bottom Up
     * <p>
     * Runtime: 11.35%
     * Memory Usage: 32.68%
     */
    public int longestPalindromeSubseqBottomUp(String s) {

        int[][] dp = new int[s.length()][s.length()]; // Contains size of the substring

        for (int end = 0; end < s.length(); end++) {
            dp[end][end] = 1;
            for (int start = end - 1; start >= 0; start--) {

                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2;
                    if (end - 1 >= start + 1) { // Add also the inner subsequence
                        dp[start][end] += dp[start + 1][end - 1];
                    }
                } else { // We choose max of 2 other variants - bba = max (bb, ba)
                    dp[start][end] = Math.max(dp[start][end - 1], dp[start + 1][end]);
                }
            }
        }

        return dp[0][dp[0].length - 1];
    }

    /**
     * DP Top To Bottom
     * <p>
     * Runtime: 72.77%
     * Memory Usage: 8.43%
     */
    public int longestPalindromeSubseqTopToBottom(String s) {
        return longestPalindromeSubseqTopToBottom(s, 0, s.length() - 1, new int[s.length()][s.length()]);
    }

    public int longestPalindromeSubseqTopToBottom(String s, int start, int end, int[][] memo) {
        if (start == end) return 1;
        if (start > end) return 0;
        if (memo[start][end] > 0) return memo[start][end];

        memo[start][end] = s.charAt(start) == s.charAt(end) ? 2 + longestPalindromeSubseqTopToBottom(s, start + 1, end - 1, memo) :
                Math.max(longestPalindromeSubseqTopToBottom(s, start + 1, end, memo), longestPalindromeSubseqTopToBottom(s, start, end - 1, memo));

        return memo[start][end];
    }
}
