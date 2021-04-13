package us.slemjet.leetcode.easy.from_100_to_150;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * Runtime: 100.00%
     * Memory Usage: 39.61%
     */
    public int maxProfit(int[] prices) {
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) // If height increase -> sum
                sum += prices[i] - prices[i - 1];
        }

        return sum;
    }

    /**
     * Runtime: 65.84%
     * Memory Usage: 52.46%
     */
    public int maxProfitBrute(int[] prices) {

        int result = 0;
        if (prices == null)
            return result;

        int currMax = prices[0];
        int currMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > currMax) {
                currMin = Math.min(currMin, prices[i]);
                currMax = prices[i];
            } else {
                result += Math.max(0, currMax - currMin);
                currMax = prices[i];
                currMin = prices[i];
            }
        }

        return result + Math.max(0, currMax - currMin);
    }

    /**
     * Runtime: 65.84%
     * Memory Usage: 52.46%
     */
    public int maxProfitSums(int[] prices) {

        if (prices == null) return 0;

        int[] sums = new int[prices.length];
        int min = prices[0];
        int lastSumIdx = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                sums[i] = sums[lastSumIdx] + prices[i] - min;
            } else {
                sums[i] = sums[i - 1];
                min = prices[i];
                lastSumIdx = i;
            }
        }

        return sums[sums.length - 1];
    }
}
