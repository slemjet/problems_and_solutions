package us.slemjet.leetcode.hard.tasks_100_150;

import java.util.Arrays;

/**
 * 123. Best Time to Buy and Sell Stock III
 */
public class BestTimeToBuyEndStockIII {

    /**
     * Generic DP solution
     * Time: O(n*k) -> 44.58%
     * Space: O(n*k) -> 46.04%
     */
    public int maxProfit(int[] prices) {

        int transactions = 2;
        int[][] dp = new int[prices.length][transactions + 1];
        int[] mins = new int[transactions + 1];

        // Initial conditions - min for each transaction is price on first day
        Arrays.fill(mins, prices[0]);

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= transactions; j++) {
                // Get min price per transaction - min price of buy - map previous transaction profit
                mins[j] = Math.min(mins[j], prices[i] - dp[i - 1][j - 1]);

                // Get max profit - max price of sale - min price of buy
                dp[i][j] = Math.max(dp[i - 1][j], prices[i] - mins[j]);
            }
        }

        return dp[prices.length - 1][transactions];
    }

    /**
     * Optimized for 2 transactions
     * Time: O(n) -> 100.00%
     * Space: O(1) -> 38.56%
     */
    public int maxProfit2(int[] prices) {

        int buy1 = Integer.MIN_VALUE;
        int sell1 = Integer.MIN_VALUE;

        int buy2 = Integer.MIN_VALUE;
        int sell2 = Integer.MIN_VALUE;

        for (int price : prices) {

            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);

            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
