package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 63. Unique Paths II
 */
public class UniquePathsII {

    /**
     * DP Bottom Up
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 9.99%
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // Contains sum of combinations
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // result - sum of all previous combinations
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    /**
     * DP Bottom Up - Modify input
     *
     * Runtime: 44.89%
     * Memory Usage: 9.99%
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    }
                    obstacleGrid[i][j] = 1; // Set initial value
                } else if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                // result - sum of all previous combinations
                if (i > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                }
                if (j > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
