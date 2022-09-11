package us.slemjet.leetcode.hard.from_151_to_200;

import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * TLE
     */
    public int maxProfitNaive(int k, int[] prices) {

        return helper(k, prices, 0, false);
    }

    private int helper(int k, int[] prices, int day, boolean hasStock) {
        if (day >= prices.length || k < 0) return 0;
        else if (hasStock)
            // Can sell or skip
            return Math.max(prices[day] + helper(k, prices, day + 1, false), helper(k, prices, day + 1, true));
        else
            // Can buy or skip
            return Math.max(helper(k - 1, prices, day + 1, true) - prices[day], helper(k, prices, day + 1, false));
    }

    /**
     * DP Bottom Up
     *
     * Runtime: 90.60%
     * Memory Usage: 55.26%
     */
    public int maxProfitDpBottomUp(int k, int[] prices) {
        if (prices.length / 2 < k) {
            // We have unlimited transactions - buy any price gap
            return quickSum(prices);
        }

        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k + 1];

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price); // If we buy here
                sell[i] = Math.max(sell[i], buy[i] + price); // If we sell here
            }
        }

        // Max profit will be at last sale
        return sell[k];
    }

    /**
     * DP Top Down approach
     * <p>
     * Runtime: 5.00%
     * Memory Usage: 5.16%
     */
    public int maxProfitDpTopDown(int k, int[] prices) {

        if (prices.length / 2 < k) {
            // We have unlimited transactions - buy any price gap
            return quickSum(prices);
        }

        int[][][] dp = new int[1000][101][2]; // [1000] - max days; [101] - max transactions; [2] - 1 - buy, 0 - sell
        return dfs(prices, k, 0, false, dp);
    }

    private int dfs(int[] prices, int k, int day, boolean hasStock, int[][][] dp) {
        if (day >= prices.length || k == 0 && !hasStock) return 0;

        int op = hasStock ? 0 : 1;
        if (dp[day][k][op] == 0) {
            // Calculate dp
            if (hasStock)
                dp[day][k][op] = Math.max(dfs(prices, k, day + 1, true, dp), dfs(prices, k, day + 1, false, dp) + prices[day]);
            else
                dp[day][k][op] = Math.max(dfs(prices, k, day + 1, false, dp), dfs(prices, k - 1, day + 1, true, dp) - prices[day]);
        }
        return dp[day][k][op];
    }

    private int quickSum(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }
}
