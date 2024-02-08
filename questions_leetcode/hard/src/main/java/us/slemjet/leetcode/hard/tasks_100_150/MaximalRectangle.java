package us.slemjet.leetcode.hard.tasks_100_150;

import java.util.Arrays;

/**
 * 85. Maximal Rectangle
 */
public class MaximalRectangle {


    /**
     * DP Keep track of height, left and right bounds
     * Iterate row by row and calculate current possible areas using data from previous computations and current row
     *
     * Runtime: 99.90%
     * Memory Usage: 59.05%
     */
    public int maximalRectangleDp(char[][] matrix) {

        int result = 0;

        int[] height = new int[matrix[0].length];
        int[] leftIdx = new int[matrix[0].length];
        int[] rightIdx = new int[matrix[0].length];
        Arrays.fill(rightIdx, matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {

            // Calculate current heights row
            for (int j = 0; j < matrix[i].length; j++) {
                // Height if current bar can either increase or drop to 0
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            // Calculate left indices, left bound of the rectangle with height[j]
            int currLeft = 0; // Current left index
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') leftIdx[j] = Math.max(currLeft, leftIdx[j]);
                else {
                    leftIdx[j] = 0;
                    currLeft = j + 1;
                }
            }

            // Calculate right indices, right bound of the rectangle with height[j]
            int currRight = matrix[i].length;
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') rightIdx[j] = Math.min(currRight, rightIdx[j]);
                else {
                    rightIdx[j] = matrix[i].length;
                    currRight = j;
                }
            }

            // Calculate area using left, right and height
            for (int j = 0; j < matrix[i].length; j++) {
                int area = (rightIdx[j] - leftIdx[j]) * height[j];
                result = Math.max(result, area);
            }
        }

        return result;
    }

    /**
     * Calculate areas of current row
     * Go up and calculate area of sum of rows
     * <p>
     * Runtime: 46.91%
     * Memory Usage:  5.23%
     * <p>
     * Time: O(n^3)
     * Space O(n^2)
     */
    public int maximalRectangleRowArea(char[][] matrix) {

        int result = 0;
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] rowArea = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') continue; // Nothing to calculate

                rowArea[i][j] = 1 + (j > 0 ? rowArea[i][j - 1] : 0); // Contains sum of '1's in a row

                int x = matrix[0].length;
                for (int y = 1; i - y + 1 >= 0; y++) {
                    if (rowArea[i - y + 1][j] == 0) break; // Cannot proceed up with a row

                    x = Math.min(x, rowArea[i - y + 1][j]); // Take min of current and previous
                    result = Math.max(result, x * y);
                }
            }
        }

        return result;
    }

    /**
     * Use DP to cache results of all combinations for current number
     * <p>
     * Time Limit exceeded
     */
    public int maximalRectangleDp2(char[][] matrix) {

        int result = 0;
        boolean[][] ones = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') continue;

                // Process all combinations with this starting point [i][j]
                for (int k = i; k < matrix.length; k++) {
                    for (int l = j; l < matrix[0].length; l++) {
                        ones[k][l] = matrix[k][l] == '1'; // Need to be '1'
                        if (k > i) ones[k][l] &= ones[k - 1][l]; // Need to have 1 to the left
                        if (l > j) ones[k][l] &= ones[k][l - 1]; // Need to have 1 p
                        if (ones[k][l]) result = Math.max(result, (k - i + 1) * (l - j + 1));
                        else break; // No need to continue
                    }
                }
            }
        }

        return result;
    }

    /**
     * Brute force approach - count all possible rectangles (skip not possible ones)
     * <p>
     * Runtime: 5.06%
     * Memory Usage: 5.95%
     * <p>
     * Time: O(n^4)
     * Space: O(n)
     */
    public int maximalRectangleBrute(char[][] matrix) {

        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') continue;

                // Process all combinations with this starting point [i][j]
                int cols = matrix[0].length;
                for (int k = i; k < matrix.length; k++) {
                    for (int l = j; l < cols; l++) {
                        if (matrix[k][l] == '0') {
                            cols = l; // No need to check past this point
                            continue;
                        }

                        // Count size to this end point [k][l]
                        result = Math.max(result, (k - i + 1) * (l - j + 1));
                    }
                }
            }
        }

        return result;
    }
}
