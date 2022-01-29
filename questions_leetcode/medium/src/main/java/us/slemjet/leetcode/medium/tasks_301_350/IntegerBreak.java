package us.slemjet.leetcode.medium.tasks_301_350;

/**
 * 343. Integer Break
 */
public class IntegerBreak {

    /**
     * DP Top To Bottom
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 7.25%
     */
    public int integerBreakTopToBottom(int n) {
        return integerBreakTopToBottom(n, new int[n + 1]);
    }

    private int integerBreakTopToBottom(int n, int[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];

        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            // i - is the each number we take (1, 2, 3, 4) < n
            int numProduct = i * (n - i); // If we just multiply 2 numbers
            int numSubProduct = i * integerBreakTopToBottom(n - i, memo); // If we multiply with all the numbers subproducts
            maxProduct = Math.max(maxProduct, Math.max(numProduct, numSubProduct));
        }
        memo[n] = maxProduct;
        return memo[n];
    }

    /**
     * DP Bottom Up
     *
     * Runtime: 22.79%
     * Memory Usage: 7.25%
     */
    public int integerBreakBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], (i - j) * j));
            }
        }

        return dp[n];
    }
}
