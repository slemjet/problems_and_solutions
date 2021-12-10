package us.slemjet.leetcode.medium.tasks_201_250;

/**
 * 240. Search a 2D Matrix II
 */
public class SearchA2DMatrixII {

    /**
     * Runtime: 100.00%
     * Memory Usage: 78.02%
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

        // Go from bottom left corner. (can also be top right)
        // If val > target decrement column else increment row
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix[0].length && col >= 0) {
            int val = matrix[col][row];
            if (val == target)
                return true;
            else if (val > target)
                col--; // exclude row
            else
                row++; // exclude column
        }

        return false;
    }
}
