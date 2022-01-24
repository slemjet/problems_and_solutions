package us.slemjet.leetcode.medium.tasks_201_250;

/**
 * 221. Maximal Square
 */
public class MaximalSquare {

    /**
     * Runtime: 32.80%
     * Memory Usage: 18.20%
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1]; // length + 1 for simpler calculation

        int cnt = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (matrix[i - 1][j - 1] - '0' == 1) {
                    // If any of the sides is != 1 than we cannot increment
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    cnt = Math.max(cnt, dp[i][j]);
                }
            }
        }

        return cnt * cnt;
    }

    /**
     * Runtime: 53.81%
     * Memory Usage: 30.74%
     */
    public int maximalSquare2(char[][] matrix) {

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1]; // length + 1 for simpler calculation

        int cnt = 0; // Base for square result = cnt * cnt

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i + 1][j + 1] = matrix[i][j] - '0';
                dp[i + 1][j + 1] = dp[i + 1][j + 1] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];

                // Check backwards incrementing count is square exists
                while (i - cnt >= 0 && j - cnt >= 0) {
                    int square = dp[i + 1][j + 1] + dp[i - cnt][j - cnt] // Add dp[i - 1][j - 1] since it is excluded in both part with '-'
                            - dp[i - cnt][j + 1] - dp[i + 1][j - cnt];
                    if (square == (cnt + 1) * (cnt + 1)) cnt++; // Exists square that cnt * cnt
                    else break;
                }
            }
        }

        return cnt * cnt;
    }
}
