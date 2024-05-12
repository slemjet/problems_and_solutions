package us.slemjet.leetcode.easy.tasks_2351_2400;

/**
 * 2373. Largest Local Values in a Matrix
 */
public class LargestLocalValuesInAMatrix {

    /**
     * Time: O(n*m) ->  62.99%
     * Space:O(n*m) ->  48.19%
     */
    public int[][] largestLocal(int[][] grid) {

        int[][] response = new int[grid.length - 2][grid.length - 2];

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {

                response[i - 1][j - 1] = getMaxVal(grid, i, j);
            }
        }
        return response;
    }

    private int getMaxVal(int[][] grid, int i, int j) {

        int max = Integer.MIN_VALUE;

        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                max = Math.max(max, grid[i + k][j + l]);
            }
        }

        return max;
    }
}
