package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 64. Minimum Path Sum
 */
public class MinimumPathSum {

    /**
     * Top to bottom
     *
     * Runtime: 100.00%
     * Memory Usage: 36.33%
     */
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return getMinPath(grid, grid.length - 1, grid[0].length - 1, memo);
    }

    private int getMinPath(int[][] grid, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        if (i > 0 && j > 0) {
            memo[i][j] = grid[i][j] + Math.min(getMinPath(grid, i - 1, j, memo), getMinPath(grid, i, j - 1, memo));
        } else if (i > 0) {
            memo[i][j] = grid[i][j] + getMinPath(grid, i - 1, j, memo);
        } else if (j > 0) {
            memo[i][j] = grid[i][j] + getMinPath(grid, i, j - 1, memo);
        } else {
            memo[i][j] = grid[i][j];
        }
        return memo[i][j];
    }

    /**
     * Bottom up
     * <p>
     * Runtime: 83.62%
     * Memory Usage: 78.78%
     */
    public int minPathSum2(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i > 0) {
                    if (j > 0) {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    } else {
                        grid[i][j] += grid[i - 1][j];
                    }
                } else if (j > 0) {
                    grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
