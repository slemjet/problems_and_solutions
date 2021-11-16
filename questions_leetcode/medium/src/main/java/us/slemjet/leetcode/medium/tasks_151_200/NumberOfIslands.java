package us.slemjet.leetcode.medium.tasks_151_200;

/**
 * 200. Number of Islands
 */
public class NumberOfIslands {

    /**
     * Runtime: 100.00%
     * Memory Usage: 61.73%
     */
    public int numIslands(char[][] grid) {

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    traverseIslands(grid, i, j);
                }
            }
        }

        return result;
    }

    private void traverseIslands(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            traverseIslands(grid, i - 1, j);
            traverseIslands(grid, i + 1, j);
            traverseIslands(grid, i, j - 1);
            traverseIslands(grid, i, j + 1);
        }
    }
}
