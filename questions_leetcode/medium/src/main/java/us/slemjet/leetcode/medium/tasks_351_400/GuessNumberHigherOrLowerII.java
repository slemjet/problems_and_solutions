package us.slemjet.leetcode.medium.tasks_351_400;

/**
 * 375. Guess Number Higher or Lower II
 */
public class GuessNumberHigherOrLowerII {

    /**
     * Time: O()    ->  16.39%
     * Space:O(n*m) ->  35.39%
     */
    public int getMoneyAmountTopDown(int n) {

        int[][] memo = new int[n + 1][n + 1];
        return getMinMoneyAmount(1, n, memo);
    }

    private int getMinMoneyAmount(int left, int right, int[][] memo) {

        if (left >= right) {
            return 0;
        }

        if (right - left == 1) {
            return left;
        }

        if (right - left == 2) {
            return left + 1;
        }

        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        int minSum = Integer.MAX_VALUE;

        for (int pivot = left; pivot <= right; pivot++) {
            int curSum = pivot + Math.max(
                    getMinMoneyAmount(left, pivot - 1, memo),
                    getMinMoneyAmount(pivot + 1, right, memo));

            minSum = Math.min(minSum, curSum);
        }

        return memo[left][right] = minSum;
    }

    /**
     * Time: O()    ->  92.87%
     * Space:O(n*m) ->  14.01%
     */
    public int getMoneyAmountBottomUp(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int minsum = Integer.MAX_VALUE;
                for (int pivot = i; pivot < i + len - 1; pivot++) {
                    minsum = Math.min(pivot + Math.max(dp[i][pivot - 1], dp[pivot + 1][i + len - 1]), minsum);
                }
                dp[i][i + len - 1] = minsum;
            }
        }
        return dp[1][n];
    }

}
