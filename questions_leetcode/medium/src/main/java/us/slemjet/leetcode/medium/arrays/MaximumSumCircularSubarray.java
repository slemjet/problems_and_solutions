package us.slemjet.leetcode.medium.arrays;

public class MaximumSumCircularSubarray {

    /**
     * Runtime: 4 ms, faster than 79.71%
     * Memory Usage: 45.3 MB, less than 87.04%
     */
    public int maxSubarraySumCircular(int[] A) {

        int maxSum = Integer.MIN_VALUE;
        int curMax = 0;

        int minSum = Integer.MAX_VALUE;
        int curMin = 0;

        int sum = 0;

        for (int val : A) {
            // If all previous sum + current is less than current - we start counting sums anew
            curMax = Math.max(curMax + val, val);
            maxSum = Math.max(maxSum, curMax);
            // We need min sum as in case if max sum is divided between 2 sides
            // in this case maxSum = totalSum - minSum
            curMin = Math.min(curMin + val, val);
            minSum = Math.min(minSum, curMin);

            sum += val;
        }

        int max = Math.max(maxSum, sum - minSum);
        // if all values are negative we need to
        // take maxSum, which will be negative, not sum - minSum, which is 0
        return maxSum > 0 ? max : maxSum;
    }
}
