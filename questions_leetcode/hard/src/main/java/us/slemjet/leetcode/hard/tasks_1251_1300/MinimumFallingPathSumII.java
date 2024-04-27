package us.slemjet.leetcode.hard.tasks_1251_1300;

/**
 * 1289. Minimum Falling Path Sum II
 */
public class MinimumFallingPathSumII {

    /**
     * Time: O(n*m) ->  90.82%
     * Space:O(1)   ->  77.21%
     */
    public int minFallingPathSum(int[][] grid) {

        // Store indices of min element and second min element
        int minIdx = -1;
        int min2Idx = -1;

        for (int i = 0; i < grid.length; i++) {

            if (i > 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    // Min value to add is either min value if index != current index or min2
                    grid[i][j] += (minIdx != j) ? grid[i - 1][minIdx] : grid[i - 1][min2Idx];
                }
            }

            minIdx = -1;
            min2Idx = -1;

            // Calculate min and min2 for current row
            for (int j = 0; j < grid[i].length; j++) {
                if (minIdx == -1 || grid[i][j] <= grid[i][minIdx]) {
                    min2Idx = minIdx;
                    minIdx = j;
                } else if (min2Idx == -1 || grid[i][j] <= grid[i][min2Idx]) {
                    min2Idx = j;
                }
            }
        }

        return grid[grid.length - 1][minIdx];
    }
}
