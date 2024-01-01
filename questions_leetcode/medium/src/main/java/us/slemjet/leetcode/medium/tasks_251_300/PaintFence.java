package us.slemjet.leetcode.medium.tasks_251_300;

/**
 * 276. Paint Fence
 */
public class PaintFence {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n*m) ->  27.81%
     */
    public int numWaysBottomUpDP(int n, int k) {

        if (n == 1) return k;
        if (n == 2) return k * k;

        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;

        for (int i = 2; i < n; i++) {

            // Add variants to paint in different color
            dp[i] += dp[i - 1] * (k - 1); // num colors - current

            // Add variants to paint same color
            // i - 1 must be a different color than i - 2 to be able to paint i same color
            // so there are no 3 same colors in a row
            dp[i] += dp[i - 2] * (k - 1);
        }

        return dp[dp.length - 1];
    }

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n*m) ->  9.63%
     */
    public int numWaysTopDownDP(int n, int k) {

        int[] memo = new int[n + 1];
        return calculateNumWays(n, k, memo);
    }

    private int calculateNumWays(int n, int k, int[] memo) {

        if (n <= 0) return 0;
        if (memo[n] != 0) return memo[n];

        if (n == 1) return memo[n] = k;
        if (n == 2) return memo[n] = k * k;
        return memo[n] =
                (k - 1) * calculateNumWays(n - 1, k, memo) + // Different color
                        (k - 1) * calculateNumWays(n - 2, k, memo); // Same color - than n - 1 must be different color than n - 2
    }
}
