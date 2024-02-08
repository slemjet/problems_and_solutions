package us.slemjet.leetcode.easy.tasks_101_150;

/**
 * 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {

    /**
     *
     * Runtime: 36.60%
     * Memory Usage: 29.18%
     */
    public int maxProfit(int[] prices) {

            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;

            for (int price : prices) {
                minPrice = Math.min(minPrice, price);
                maxProfit = Math.max(maxProfit, price - minPrice);
            }

            return maxProfit;
    }

    /**
     * Kadane's Algorithm
     *
     * Runtime: 5.16%
     * Memory Usage: 32.18%
     */
    public int maxProfitKadane(int[] prices) {

        int currProfit = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            currProfit += prices[i] - prices[i - 1]; // Add next price delta
            currProfit = Math.max(0, currProfit); // Floor to zero
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }

    /**
     * Bottom Up Aprroach
     *
     * Runtime: 5.16%
     * Memory Usage: 5.11%
     */
    public int maxProfitBottomUp(int[] prices) {
        int result = 0;
        int[] dp = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - prices[i - 1] + dp[i - 1], 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
