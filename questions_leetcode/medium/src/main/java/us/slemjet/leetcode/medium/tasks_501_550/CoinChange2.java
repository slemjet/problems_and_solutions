package us.slemjet.leetcode.medium.tasks_501_550;

/**
 * 518. Coin Change 2
 */
public class CoinChange2 {

    /**
     * DP Bottom Up
     * Populate all combinations, added by each coin up to the sum
     *
     * Runtime: 39.18%
     * Memory Usage: 48.91%
     */
    public int change(int amount, int[] coins) {

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
}

