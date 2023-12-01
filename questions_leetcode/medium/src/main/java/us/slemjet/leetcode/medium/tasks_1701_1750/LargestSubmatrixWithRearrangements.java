package us.slemjet.leetcode.medium.tasks_1701_1750;

import java.util.Arrays;

/**
 * 1727. Largest Submatrix With Rearrangements
 */
public class LargestSubmatrixWithRearrangements {

    /**
     * Time: O(n*m*logm) -> 92.50%
     * Space: O(1) -> 22.27%
     */
    public int largestSubmatrix(int[][] matrix) {

        // 1. Create prefix sums for columns, resetting on 0
        for (int i = 1; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = row.length - 1; j >= 0; j--) {
                if (row[j] != 0) {
                    row[j] += matrix[i - 1][j];
                }
            }
        }

        int result = 0;

        for (int[] row : matrix) {
            // 2. Sort each row in descending order
            Arrays.sort(row);
            for (int j = row.length - 1; j >= 0; j--) {
                // 3. Since array is sorted and each element is a sum
                // - we can use numbers to calculate square of elements above sum = size * currVerticalSum
                int currSum = row[j] * (row.length - j);
                result = Math.max(result, currSum);
            }
        }

        return result;
    }
}
