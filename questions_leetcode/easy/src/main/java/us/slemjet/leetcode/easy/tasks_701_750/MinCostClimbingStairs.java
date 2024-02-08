package us.slemjet.leetcode.easy.tasks_701_750;

/**
 * 746. Min Cost Climbing Stairs
 */
public class MinCostClimbingStairs {

    /**
     * Runtime: 25.48%
     * Memory Usage: 29.49%
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return cost[cost.length - 1];
        int one = cost[0];
        int two = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int next = cost[i] + Math.min(one, two);
            one = two;
            two = next;
        }

        return Math.min(one, two);
    }

    /**
     * Bottom Up
     * <p>
     * Runtime: 25.48%
     * Memory Usage: 18.93%
     */
    public int minCostClimbingStairsBottomUp(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 2], cost[i - 1]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    /**
     * Top to Bottom
     * <p>
     * Runtime: 15.95%
     * Memory Usage: 7.57%
     */
    public int minCostClimbingStairsTopToBottom(int[] cost) {
        int[] memo = new int[cost.length];
        return Math.min(minCostMemo(memo, cost, cost.length - 1), minCostMemo(memo, cost, cost.length - 2));
    }

    private int minCostMemo(int[] memo, int[] cost, int n) {
        if (n < 0) return 0;
        if (n < 2) return cost[n];
        if (memo[n] != 0) return memo[n];

        memo[n] = cost[n] + Math.min(minCostMemo(memo, cost, n - 1), minCostMemo(memo, cost, n - 2));
        return memo[n];
    }
}
