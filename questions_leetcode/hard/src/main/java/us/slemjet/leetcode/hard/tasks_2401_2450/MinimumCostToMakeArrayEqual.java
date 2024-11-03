package us.slemjet.leetcode.hard.tasks_2401_2450;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2448. Minimum Cost to Make Array Equal
 */
public class MinimumCostToMakeArrayEqual {

    /**
     * Time:    O(n log n)  ->  9.09%
     * Space:   O(n)        ->  43.23%
     */
    public long minCost(int[] nums, int[] cost) {

        long result;

        int[][] numCost = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            numCost[i][0] = nums[i];
            numCost[i][1] = cost[i];
        }

        Arrays.sort(numCost, Comparator.comparingInt(a -> a[0]));

        long[] prefixSum = new long[nums.length];
        long totalSum = 0;
        prefixSum[0] = numCost[0][1];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + numCost[i][1];
            totalSum += (long) numCost[i][1] * (numCost[i][0] - numCost[0][0]);
        }

        result = totalSum;

        for (int i = 1; i < numCost.length; i++) {
            long delta = numCost[i][0] - numCost[i - 1][0];

            long left = delta * prefixSum[i - 1];
            long right = delta * (prefixSum[numCost.length - 1] - prefixSum[i - 1]);
            totalSum += left - right;

            result = Math.min(result, totalSum);
        }

        return result;
    }
}
