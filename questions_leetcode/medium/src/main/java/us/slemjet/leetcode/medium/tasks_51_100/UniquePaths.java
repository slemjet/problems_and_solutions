package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 62. Unique Paths
 */
public class UniquePaths {

    /**
     * Runtime: 100.00%
     * Memory Usage: 90.32%
     */
    public int uniquePaths(int m, int n) {

        // Contains sum of combinations
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0)
                    // leftmost column and topmost row have 1 intersection of combinations
                    dp[i][j] = 1;
                else
                    // result - sum of all previous combinations
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
