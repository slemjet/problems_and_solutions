package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 74. Search a 2D Matrix
 */
public class SearchA2DMatrix {

    /**
     * Use Binary Search
     * Runtime: 100.00%%
     * Memory Usage: 30.04%
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0, end = matrix.length * matrix[0].length - 1;
        int colSize = matrix[0].length;

        while (start <= end) {
            // Just the standard binary search
            int mid = start + (end - start) / 2;
            if (matrix[mid / colSize][mid % colSize] == target)
                return true; // Solution found
            else if (matrix[mid / colSize][mid % colSize] < target)
                start = mid + 1; // Result must be in the right part
            else end = mid - 1; // Result must be in the left part
        }
        return false;
    }
}
