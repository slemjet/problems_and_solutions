package us.slemjet.leetcode.medium.tasks_1701_1750;

import java.util.Arrays;

/**
 * 1706. Where Will the Ball Fall
 */
public class WhereWillTheBallFall {

    /**
     * Simulation
     *
     * Runtime: 73.23%
     * Memory Usage: 88.14%
     *
     * Space: O(n)
     * Time: O(m*n)
     */
    public int[] findBall(int[][] grid) {

        // Populate first row [0, 1, 2, ... n]
        int[] row = new int[grid[0].length];
        for (int i = 0; i < row.length; i++) {
            row[i] = i;
        }

        // Process level by level
        for (int[] level : grid) {
            int[] nextRow = new int[level.length];
            Arrays.fill(nextRow, -1);
            for (int i = 0; i < row.length; i++) {
                int nextIdx = i + level[i];
                if (nextIdx >= 0 && nextIdx < row.length) {
                    // If is within matrix
                    if (level[i] + level[nextIdx] != 0) {
                        // If not forming \/ formation - so ball is stuck
                        nextRow[nextIdx] = row[i];
                    }
                }
            }
            row = nextRow;
        }

        // Reprocess to output format
        int[] result = new int[row.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < row.length; i++) {
            if (row[i] != -1) result[row[i]] = i;
        }

        return result;
    }
}
