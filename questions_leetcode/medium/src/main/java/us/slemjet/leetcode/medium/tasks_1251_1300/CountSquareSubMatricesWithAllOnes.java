package us.slemjet.leetcode.medium.tasks_1251_1300;

/**
 * 1277. Count Square Submatrices with All Ones
 */
public class CountSquareSubMatricesWithAllOnes {

    /**
     * DP Bottom Up Approach
     * <p>
     * Runtime: 27.65%
     * Memory Usage: 16.44%
     */
    public int countSquaresBottomUp(int[][] matrix) {
        int result = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) continue;
                dp[i][j] = matrix[i][j];
                if (i != 0 && j != 0) dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                result += dp[i][j];
            }
        }

        return result;
    }

    /**
     * Keep prev columns heights and check for every row
     * <p>
     * Runtime: 95.42%
     * Memory Usage: 78.88%
     */
    public int countSquares(int[][] matrix) {

        int result = 0;
        int[] prev = null;

        for (int[] curr : matrix) {
            for (int i = 0; i < curr.length; i++) {
                if (curr[i] == 0) continue; // Skip current == 1
                result++;
                if (prev == null) continue; // Skip elements > 1
                int minPrev = prev[i];
                for (int j = 1; i + j < prev.length; j++) {
                    minPrev = Math.min(minPrev, prev[i + j]);
                    if (curr[i + j] != 0 && minPrev >= j) result++;
                    else break; // No need to continue
                }
            }

            if (prev == null) prev = curr;
            else {
                for (int j = 0; j < curr.length; j++) {
                    if (curr[j] == 0) prev[j] = 0;
                    else prev[j] += curr[j];
                }
            }
        }

        return result;
    }
}
