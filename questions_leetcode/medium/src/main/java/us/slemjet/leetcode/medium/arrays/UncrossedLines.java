package us.slemjet.leetcode.medium.arrays;

public class UncrossedLines {

    /**
     * Runtime: 96.49%
     * Memory Usage: 90.93%
     */
    public int maxUncrossedLinesDpCycle(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }

    /**
     * Runtime: 6.4%
     * Memory Usage: 7.2%
     */
    public int maxUncrossedLinesDpRec(int[] A, int[] B) {
        Integer[][] dp = new Integer[A.length][B.length];
        return calculateCrossed(A, B, 0, 0, dp);
    }

    private int calculateCrossed(int[] A, int[] B, int i, int j, Integer[][] dp) {

        if (i == A.length || j == B.length /*|| i - j > 1 || j - i > 1*/) {
            return 0; // End of array
        }

        Integer result = dp[i][j];
        if (result != null) {
            return result; // Has cached value - return it
        }

        if (A[i] == B[j]) {
            // Advance both and calculate remaining
            result = 1 + calculateCrossed(A, B, i + 1, j + 1, dp);
        } else {
            // Get max from 2 variants
            result = Math.max(calculateCrossed(A, B, i + 1, j, dp), calculateCrossed(A, B, i, j + 1, dp));
        }
        dp[i][j] = result;
        return result;
    }

    public int maxUncrossedLinesSimple(int[] A, int[] B) {
        return calculateCrossed(A, B, 0, 0);
    }

    private int calculateCrossed(int[] A, int[] B, int i, int j) {

        if (i == A.length || j == B.length) {
            return 0; // End of array
        }

        if (A[i] == B[j]) {
            return 1 + calculateCrossed(A, B, i + 1, j + 1);
        } else {
            return Math.max(calculateCrossed(A, B, i + 1, j), calculateCrossed(A, B, i, j + 1));
        }
    }
}
