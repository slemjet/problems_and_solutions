package us.slemjet.leetcode.hard.from_251_to_300;

/**
 * 265. Paint House II
 */
public class PaintHouseII {

    /**
     * Time: O(n*m) ->  42.70%
     * Space: O(1)  ->  26.40%
     */
    public int minCostII(int[][] costs) {

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                int minPrev = Integer.MAX_VALUE;

                // Iterate over previous line to get results
                for (int k = 0; k < costs[i].length; k++) {
                    if (k != j) {
                        int prev = costs[i - 1][k];
                        minPrev = Math.min(minPrev, prev);
                    }
                }
                costs[i][j] += minPrev;
            }
        }

        for (int totalCost : costs[costs.length - 1]) {
            result = Math.min(result, totalCost);
        }

        return result;
    }

    /**
     * Time: O(n*m) ->  23.03%
     * Space: O(1)  ->  15.45%
     */
    public int minCostIIMemo(int[][] costs) {

        int[][] memo = new int[costs.length][costs[0].length];

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < costs[0].length; i++) {
            minCost = Math.min(minCost, calculateCost(0, i, costs, memo));
        }

        return minCost;

    }

    private int calculateCost(int house, int color, int[][] costs, int[][] memo) {

        int totalCost = costs[house][color];

        if (house == costs.length - 1) {
            return costs[house][color];
        }

        if (memo[house][color] > 0) {
            return memo[house][color];
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < costs[house].length; i++) {
            if (i != color) {
                minCost = Math.min(minCost, calculateCost(house + 1, i, costs, memo));
            }
        }

        totalCost += minCost;

        memo[house][color] = totalCost;

        return totalCost;
    }
}
