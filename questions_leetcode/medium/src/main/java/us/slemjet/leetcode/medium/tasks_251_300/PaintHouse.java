package us.slemjet.leetcode.medium.tasks_251_300;

/**
 * 256. Paint House
 */
public class PaintHouse {

    /**
     * Time: O(n*m) ->  11.54%
     * Space: O(1)  ->  39.64%
     */
    public int minCostBottomUp(int[][] costs) {

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
     * Time:  O(n)    ->  84.80%
     * Space: O(n)    ->  70.99%
     */
    public int minCostMemo(int[][] costs) {

        int[][] memo = new int[costs.length][costs[0].length];

        return Math.min(calculateCost(0, 0, costs, memo),
                Math.min(calculateCost(0, 1, costs, memo),
                        calculateCost(0, 2, costs, memo)));

    }

    private int calculateCost(int house, int color, int[][] costs, int[][] memo) {

        int totalCost = costs[house][color];

        if (house == costs.length - 1) {
            return totalCost;
        }

        if (memo[house][color] > 0) {
            return memo[house][color];
        }

        switch (color) {
            case 0:
                totalCost += Math.min(calculateCost(house + 1, 1, costs, memo),
                        calculateCost(house + 1, 2, costs, memo));
                break;
            case 1:
                totalCost += Math.min(calculateCost(house + 1, 0, costs, memo),
                        calculateCost(house + 1, 2, costs, memo));
                break;
            case 2:
                totalCost += Math.min(calculateCost(house + 1, 0, costs, memo),
                        calculateCost(house + 1, 1, costs, memo));
                break;
        }

        memo[house][color] = totalCost;

        return totalCost;
    }
}
