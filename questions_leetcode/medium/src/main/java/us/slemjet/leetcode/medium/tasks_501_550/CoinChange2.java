package us.slemjet.leetcode.medium.tasks_501_550;

/**
 *
 */
public class CoinChange2 {

    /**
     * DP Bottom Up
     * Populate all combinations, added by each coin up to the sum
     * Using one dimensional array
     * <p>
     * Runtime: 39.18%
     * Memory Usage: 48.91%
     */
    public int changeBottomUp(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) { // Populate all combination this coin participates in
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin]; // Can use coin for this sum - so it adds its previous combinations
                }
            }
        }
        return dp[dp.length - 1];
    }

    public int changeBottomUp2(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j]; // Initial value
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]]; // Can add combination
                }
            }
        }

        return dp[coins.length][amount];
    }

    /**
     * Top To Bottom
     *
     * Runtime: 29.32%
     * Memory Usage: 27.42%
     */
    public int changeTopToBottom(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;

        Integer[][] memo = new Integer[coins.length][amount + 1];
        return changeTopToBottom(amount, coins, 0, memo);
    }

    private int changeTopToBottom(int amount, int[] coins, int idx, Integer[][] memo) {
        if (amount == 0) return 1;
        if (amount < 0 || idx >= coins.length) return 0; // Incorrect combination

        if(memo[idx][amount] != null) return memo[idx][amount];

        // We have 2 options - select coin or exclude it at current index - this will give us possible combinations
        int inclCoin = changeTopToBottom(amount - coins[idx], coins, idx, memo);
        int exclCoin = changeTopToBottom(amount, coins, idx + 1, memo);

        memo[idx][amount] = inclCoin + exclCoin;

        return memo[idx][amount];
    }
}

