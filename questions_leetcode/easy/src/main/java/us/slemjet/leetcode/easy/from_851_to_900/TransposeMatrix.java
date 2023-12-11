package us.slemjet.leetcode.easy.from_851_to_900;

/**
 * 867. Transpose Matrix
 */
public class TransposeMatrix {

    /**
     * Time: O(n*m) -> 33.15%
     * Space: O(n*m) -> 47.94%
     */
    public int[][] transpose(int[][] matrix) {

        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        
        return transposed;
    }
}
