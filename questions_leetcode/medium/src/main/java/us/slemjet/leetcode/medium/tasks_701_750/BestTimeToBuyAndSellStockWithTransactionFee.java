package us.slemjet.leetcode.medium.tasks_701_750;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * Use 2 arrays - buy and sell
     *
     * Runtime: 31.33%
     * Memory Usage: 17.07%
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int maxProfit(int[] prices, int fee) {

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }

        return Math.max(buy[buy.length - 1], sell[sell.length - 1]);
    }

    /**
     * Use 2 arrays - buy and sell -> use variable vor constant space optimization
     *
     * Runtime: 39.66%
     * Memory Usage: 38.42%
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int maxProfitConstantSpace(int[] prices, int fee) {

        int buy0 = 0, buy1 = -prices[0];
        int sell0 = 0, sell1 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy0 = Math.max(buy1, sell1 - prices[i]);
            sell0 = Math.max(sell1, buy1 + prices[i] - fee);
            buy1 = buy0;
            sell1 = sell0;
        }

        return Math.max(buy0, sell0);
    }
}
