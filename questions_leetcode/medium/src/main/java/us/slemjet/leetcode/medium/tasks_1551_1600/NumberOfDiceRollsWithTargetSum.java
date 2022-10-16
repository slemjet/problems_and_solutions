package us.slemjet.leetcode.medium.tasks_1551_1600;

/**
 * 1155. Number of Dice Rolls With Target Sum
 */
public class NumberOfDiceRollsWithTargetSum {

    /**
     * DP Top to bottom
     * Use memoization
     * <p>
     * Runtime: 28.06%
     * Memory Usage: 35.27%
     */
    public int numRollsToTargetTopToBottom(int n, int k, int target) {

        Integer[][] memo = new Integer[n + 1][target + 1];
        return dp(n, k, target, memo);
    }

    private int dp(int n, int k, int target, Integer[][] memo) {

        int modulo = (int) (Math.pow(10, 9) + 7);
        if (n == 0 && target == 0)
            return 1;
        if (n == 0 || target < 0)
            return 0;
        if (memo[n][target] == null) {
            int count = 0;
            for (int i = 1; i <= k; i++) {
                count = (count + dp(n - 1, k, target - i, memo)) % modulo;
            }
            memo[n][target] = count;
        }

        return memo[n][target];
    }

    /**
     * Runtime: 46.55%
     * Memory Usage: 89.90%
     */
    public int numRollsToTargetBottomUp(int n, int k, int target) {
        int modulo = (int) (Math.pow(10, 9) + 7);

        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) { // For each dice
            for (int j = 1; j <= target; j++) { // Until reach target
                for (int l = 1; l <= k; l++) { // For each dice value
                    if (j >= l) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % modulo;
                    }
                }
            }
        }

        return dp[n][target];
    }
}
