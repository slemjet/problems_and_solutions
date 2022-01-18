package us.slemjet.leetcode.easy.from_551_to_600;

/**
 * 566. Reshape the Matrix
 */
public class ReshapeTheMatrix {

    /**
     * Runtime: 24.85%
     * Memory Usage: 44.70%
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        // m * n -> r * c
        if (mat.length * mat[0].length != r * c) return mat;
        int[][] result = new int[r][c];

        int m = 0; // Row
        int n = 0; // Column

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = mat[m][n];
                n++;
                if (n == mat[m].length) { // End of row - increment column
                    n = 0;
                    m++;
                }
            }
        }

        return result;
    }

    /**
     * One loop variant
     * row = i / m, column (position in row) = i % m, m = row size
     *
     * Runtime: 24.85%
     * Memory Usage: 36.97%
     */
    public int[][] matrixReshape2(int[][] mat, int r, int c) {

        if (mat.length * mat[0].length != r * c) return mat;

        // n * m -> r * c
        int m = mat[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = mat[i / m][i % m];
        }

        return result;
    }
}
