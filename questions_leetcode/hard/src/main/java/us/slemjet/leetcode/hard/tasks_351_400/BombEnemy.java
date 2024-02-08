package us.slemjet.leetcode.hard.tasks_351_400;

/**
 * 361. Bomb Enemy
 */
public class BombEnemy {

    /**
     * Time: O(n*m*k)  ->  40.00%
     * Space:O(n*m)    ->  30.00%
     */
    public int maxKilledEnemies(char[][] grid) {

        int[][] counts = new int[grid.length][grid[0].length];

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'E') {
                    max = Math.max(max, fillLines(i, j, counts, grid));
                }
            }
        }

        return max;
    }

    private int fillLines(int i, int j, int[][] counts, char[][] grid) {

        int max = 0;
        counts[i][j]++;
        int y = i;
        while (--y >= 0 && grid[y][j] != 'W') {
            counts[y][j]++;
            if (grid[y][j] != 'E') {
                max = Math.max(max, counts[y][j]);
            }
        }
        y = i;
        while (++y < grid.length && grid[y][j] != 'W') {
            counts[y][j]++;
            if (grid[y][j] != 'E') {
                max = Math.max(max, counts[y][j]);
            }
        }
        int x = j;
        while (--x >= 0 && grid[i][x] != 'W') {
            counts[i][x]++;
            if (grid[i][x] != 'E') {
                max = Math.max(max, counts[i][x]);
            }
        }
        x = j;
        while (++x < grid[i].length && grid[i][x] != 'W') {
            counts[i][x]++;
            if (grid[i][x] != 'E') {
                max = Math.max(max, counts[i][x]);
            }
        }
        return max;
    }

    /**
     *  Time: O(n*m)    ->  97.86%
     *  Space:O(n)      ->  55.71%
     */
    public int maxKilledEnemiesDP(char[][] grid) {

        int maxCount = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        int rowCount = 0;
        int[] colCount = new int[columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (j == 0 || grid[i][j - 1] == 'W') {
                    // Reset counter at first cell in the row or after the wall and recalculate count until next obstacle
                    rowCount = 0;

                    // Count hits in a row
                    for (int k = j; k < columns; k++) {
                        // Calculate count for a row
                        if (grid[i][k] == 'W') break; // Stop counting if hit a wall
                        if (grid[i][k] == 'E') rowCount++; // Increment count for row
                    }
                }

                if (i == 0 || grid[i - 1][j] == 'W') {
                    // Reset counter at first cell in the column or after a wall and recalculate count till next obstacle
                    colCount[j] = 0;


                    // Count hits in a column
                    for (int k = i; k < rows; k++) {
                        // Calculate count for a column
                        if (grid[k][j] == 'W') break; // Stop counting if hit a wall
                        if (grid[k][j] == 'E') colCount[j]++; // Increment count for column
                    }
                }

                // Check if we can use cell
                if (grid[i][j] == '0') {
                    int totalCount = rowCount + colCount[j];
                    // Update maxCount
                    maxCount = Math.max(maxCount, totalCount);
                }
            }
        }

        return maxCount;
    }
}
