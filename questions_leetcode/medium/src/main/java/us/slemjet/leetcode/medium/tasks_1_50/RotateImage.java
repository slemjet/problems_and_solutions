package us.slemjet.leetcode.medium.tasks_1_50;

public class RotateImage {

    /**
     * Runtime: 100.00%
     * Memory Usage: 100.00%
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        for (int level = 0; level < matrix.length / 2; level++) { // level -> how far from outside layer we are
            int maxLength = matrix.length - 1 - level;
            // for each row we circularly swap each element with its next position
            for (int rowIdx = level; rowIdx < maxLength; rowIdx++) { // row -> position in current row
                swap(matrix, level, rowIdx, rowIdx, maxLength);
                swap(matrix, level, rowIdx, maxLength, maxLength + level - rowIdx);
                swap(matrix, level, rowIdx, maxLength + level - rowIdx, level);
            }
        }
    }

    public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
        matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
        matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 100.00%
     *
     * @param matrix
     */
    public void rotateMirrorAndSwap(int[][] matrix) {

        // Swap bottom with top
        int begin = 0, end = matrix.length - 1;
        while (begin < end) {
            int[] temp = matrix[begin];
            matrix[begin] = matrix[end];
            matrix[end] = temp;
            begin++;
            end--;
        }

        // swap diagonally (mirror diagonally)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
    }
}
