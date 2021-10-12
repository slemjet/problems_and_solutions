package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.Arrays;

public class SetMatrixZeroes {

    /**
     * Runtime: 97.43%
     * Memory Usage: 72.28%
     * Using top horizontal and left vertical line (i = 0 and j = 0 )
     * to store 0 existing in the cell
     */
    public void setZeroes(int[][] matrix) {

        // Set if top horizontal line initially has 0 -> set whole line to 0
        boolean iZero = false;
        // Set if left vertical line initially has 0 -> set whole line to 0
        boolean jZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        jZero = true;
                    }
                    if (j == 0) {
                        iZero = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (iZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (jZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
