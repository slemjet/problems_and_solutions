package us.slemjet.leetcode.medium.tasks_301_350;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * Use 2 arrays - max profit if buy today and max profit is sell today
     * <p>
     * Runtime: 74.50%
     * Memory Usage: 16.73%
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public int maxProfit(int[] prices) {

        if (prices.length < 2) return 0; // No trade can be done

        int[] buy = new int[prices.length]; // Max profit if buy now
        int[] sell = new int[prices.length]; // Max profit if sell now

        buy[0] = -prices[0]; // Bought stock on the first day
        buy[1] = -Math.min(prices[0], prices[1]); // Can either buy on day 0 or day 1
        sell[1] = Math.max(0, buy[0] + prices[1]); // Can sell what was bought on day 1
        for (int i = 2; i < prices.length; i++) {
            // For both cases either keep previous decision or make new one based on opposite to the day before
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]); // Can wait or buy if sold before
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]); // Can keep or sell if bought before
        }
        return sell[sell.length - 1]; // No reason to buy on last day - so return sell
    }

    /**
     * Use 2 arrays - max profit if buy today and max profit is sell today
     * Optimized for space using variables
     * <p>
     * buy0 - buy[i], buy1 - buy[i - 1],
     * sell0 - sell[i], sell1 - sell[i - 1], sell2 - sell[i - 2]
     * <p>
     * Runtime: 74.50%
     * Memory Usage: 14.17%
     * <p>
     * Time: O(n)
     * Space: O(1) - only 5 variables are used
     */
    public int maxProfitOptimizedSpace(int[] prices) {

        if (prices.length < 2) return 0; // No trade can be done

        int buy0 = -prices[0], buy1 = buy0; // Bought stock on the first day
        int sell0 = 0, sell1 = 0, sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            // For both cases either keep previous decision or make new one based on opposite to the day before
            buy0 = Math.max(buy1, sell2 - prices[i]); // Can wait or buy if sold before
            sell0 = Math.max(sell1, buy1 + prices[i]); // Can keep or sell if bought before
            buy1 = buy0;
            sell2 = sell1;
            sell1 = sell0;
        }
        return sell0; // No reason to buy on last day - so return sell
    }
}
