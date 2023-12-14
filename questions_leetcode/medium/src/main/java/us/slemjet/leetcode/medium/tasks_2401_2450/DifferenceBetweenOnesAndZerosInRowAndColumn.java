package us.slemjet.leetcode.medium.tasks_2401_2450;

/**
 * 2482. Difference Between Ones and Zeros in Row and Column
 */
public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    /**
     * Time: O(n*m) -> 98.71%
     * Space: O(n*m) -> 53.40%
     */
    public int[][] onesMinusZeros(int[][] grid) {

        int[] ySums = new int[grid.length];
        int[] xSums = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ySums[i] += grid[i][j];
                xSums[j] += grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ySums[i] + xSums[j] - (grid.length - ySums[i] + grid[i].length - xSums[j]);
            }
        }

        return grid;
    }
}
