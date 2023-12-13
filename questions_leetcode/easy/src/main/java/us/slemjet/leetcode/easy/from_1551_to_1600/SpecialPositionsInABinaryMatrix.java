package us.slemjet.leetcode.easy.from_1551_to_1600;

/**
 * 1582. Special Positions in a Binary Matrix
 */
public class SpecialPositionsInABinaryMatrix {

    /**
     * Time: O(n*m) -> 23.23%
     * Space:O(n*m) -> 47.47%
     */
    public int numSpecial(int[][] mat) {

        int result = 0;

        int[][] sums = new int[mat.length + 1][mat[0].length + 1];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sums[mat.length][j] += mat[i][j];
                sums[i][mat[i].length] += mat[i][j];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (sums[mat.length][j] == 1 && sums[i][mat[i].length] == 1) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
