package us.slemjet.leetcode.hard.tasks_1451_1500;

/**
 * 1463. Cherry Pickup II
 */
public class CherryPickupII {

    /**
     * Top To Bottom DP (Memoization)
     * <p>
     * Time: O(n*m^2)   ->  41.06%
     * Space:O(n*m^2)   ->  36.86%
     */
    public int cherryPickupTopToBottom(int[][] grid) {

        Integer[][][] memo = new Integer[grid.length][grid[0].length][grid[0].length];
        return cherryPickupTopToBottom(grid, 0, 0, grid[0].length - 1, memo);
    }

    private int cherryPickupTopToBottom(int[][] grid, int row, int col1, int col2, Integer[][][] memo) {

        if (row == grid.length || col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }

        if (memo[row][col1][col2] == null) {

            int sum = grid[row][col1];
            if (col1 != col2) {
                // Can pick cell only once
                sum += grid[row][col2];
            }

            int maxRemainingSum = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nextSum = cherryPickupTopToBottom(grid, row + 1, col1 + i, col2 + j, memo);
                    maxRemainingSum = Math.max(maxRemainingSum, nextSum);
                }
            }

            memo[row][col1][col2] = sum + maxRemainingSum;
        }

        return memo[row][col1][col2];
    }

    /**
     * Bottom Up DP (Tabulation)
     * <p>
     * Time: O(n*m^2)   ->  33.55%
     * Space:O(n*m^2)   ->  63.80%
     */
    public int cherryPickupBottomUp(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        // Start from last row (so we only calculate current cell value)
        for (int r = rows - 1; r >= 0; r--) {
            for (int c1 = 0; c1 < grid[r].length; c1++) {
                for (int c2 = 0; c2 < grid[r].length; c2++) {

                    // Add current cell
                    dp[r][c1][c2] = grid[r][c1];
                    if (c1 != c2) { // Avoid double collect same cell
                        dp[r][c1][c2] += grid[r][c2];
                    }

                    int maxNextSum = 0;

                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int nextR = r + 1;
                            int nextC1 = c1 + i;
                            int nextC2 = c2 + j;

                            if (nextR == rows || nextC1 < 0 || nextC1 >= cols || nextC2 < 0 || nextC2 >= cols) {
                                // Avoid out of bounds
                                continue;
                            }
                            // Get max of candidates
                            maxNextSum = Math.max(maxNextSum, dp[nextR][nextC1][nextC2]);
                        }
                    }

                    dp[r][c1][c2] += maxNextSum;
                }
            }
        }

        return dp[0][0][cols - 1]; // Result accumulated at initial state
    }
}
