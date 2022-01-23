package us.slemjet.leetcode.medium.tasks_301_350;

/**
 * 304. Range Sum Query 2D - Immutable
 */
public class RangeSumQuery2DImmutable {

    /**
     * Use DP Bottom Up
     *
     * Runtime: 81.53%
     * Memory Usage: 57.67%
     */
    static class NumMatrix {
        
        private final int[][] sums;

        public NumMatrix(int[][] matrix) {
            sums = calculateSums(matrix);
        }

        private int[][] calculateSums(int[][] matrix) {

            // Add extra 0 row and column to simplify calculation
            int[][] sums = new int[matrix.length + 1][matrix[0].length + 1];

            // Calculate sums auxiliary array
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sums[i + 1][j + 1] = matrix[i][j] + sums[i][j + 1] + sums[i + 1][j] - sums[i][j];
                }
            }
            
            return sums;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row2 + 1][col1] - sums[row1][col2 + 1];
        }
    }

}
