package us.slemjet.leetcode.hard.tasks_651_700;

/**
 * 629. K Inverse Pairs Array
 */
public class KInversePairsArray {


    /**
     * Use Recursion + Memoization
     * Time: O(n*k*min(n,k) ->  9.25%
     * Space: O(n*k)        ->  14.29%
     */
    public int kInversePairsMemo(int n, int k) {

        int modulo = (int) (Math.pow(10, 9) + 7);
        Integer[][] memo = new Integer[n + 1][k + 1];

        return kInversePairsMemo(n, k, memo, modulo);
    }

    private int kInversePairsMemo(int n, int k, Integer[][] memo, int modulo) {

        if (n == 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[n][k] == null) {
            int count = 0;
            for (int i = 0; i <= Math.min(k, n - 1); i++) {
                count = (count + kInversePairsMemo(n - 1, k - i, memo, modulo)) % modulo;
            }
            memo[n][k] = count;
        }

        return memo[n][k];
    }

    /**
     * Use Tabulation
     * Time: O(n*k*min(n,k) ->  24.37%
     * Space: O(n*k)        ->  34.45%
     */
    public int kInversePairsTabulation(int n, int k) {

        int modulo = (int) (Math.pow(10, 9) + 7);
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                if (j == 0) {
                    dp[i][j] = 1; // Always only 1 combination
                } else {
                    for (int l = 0; l <= Math.min(j, i - 1); l++) {
                        // Sum al previous combination under diagonal where k < n
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % modulo;
                    }
                }
            }
        }
        return dp[n][k];
    }
}
