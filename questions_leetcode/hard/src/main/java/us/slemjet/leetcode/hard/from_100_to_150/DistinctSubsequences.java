package us.slemjet.leetcode.hard.from_100_to_150;

/**
 * 115. Distinct Subsequences
 */
public class DistinctSubsequences {

    /**
     * Time: O(n*m) -> 60.58%
     * Space: O(n*m) -> 12.16%
     */
    public int numDistinct(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        int[][] dp = new int[sLen + 1][tLen + 1];

        for (int i = 0; i <= sLen; i++) {
            // Can always make subsequence for empty t
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                dp[i][j] = dp[i - 1][j]; // Dont include character - get prev count
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1]; // Add variation if char is included
                }
            }
        }

        return dp[sLen][tLen];
    }
}
