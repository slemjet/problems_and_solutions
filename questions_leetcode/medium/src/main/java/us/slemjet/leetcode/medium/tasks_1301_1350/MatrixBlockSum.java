package us.slemjet.leetcode.medium.tasks_1301_1350;

/**
 * 1314. Matrix Block Sum
 */
public class MatrixBlockSum {

    /**
     * DP Bottom Up
     *
     * +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
     * |               |   |         |    |   |   |           |   |         |    |   |   |          |
     * |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
     * |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
     * |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
     * |   |      |    |   |         |    |   |   |           |   |              |   |              |
     * |   +------+    |   +---------+    |   +---+           |   |              |   |              |
     * |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
     * +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
     *
     * Runtime: 57.05%
     * Memory Usage: 35.08%
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {

        // Add extra 0 row and column to simplify calculation
        int[][] sums = new int[mat.length + 1][mat[0].length + 1];

        // Calculate sums auxiliary array
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sums[i + 1][j + 1] = mat[i][j] + sums[i][j + 1] + sums[i + 1][j] - sums[i][j];
            }
        }

        int n = sums.length - 1;
        int m = sums[0].length - 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int x1 = Math.max(0, i - k - 1);
                int y1 = Math.max(0, j - k - 1);
                int x2 = Math.min(n, i + k);
                int y2 = Math.min(m, j + k);

                mat[i - 1][j - 1] = sums[x2][y2] + sums[x1][y1] - sums[x2][y1] - sums[x1][y2];
            }
        }

        return mat;
    }
}
