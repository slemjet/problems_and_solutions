package us.slemjet.leetcode.medium.tasks_1001_1050;

/**
 * 1043. Partition Array for Maximum Sum
 */
public class PartitionArrayForMaximumSum {

    /**
     * Runtime: 90.26%
     * Memory Usage: 84.13%
     *
     * Space: O(n)
     * Time: O(n)
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] memo = new Integer[arr.length];
        return maxSum(arr, 0, k, memo);
    }

    private int maxSum(int[] arr, int idx, int k, Integer[] memo) {

        if (idx >= arr.length) return 0;
        if (memo[idx] != null) return memo[idx];

        int maxValue = 0;
        int maxSum = 0;

        // Get max value of current sum + max of remaining interval
        for (int i = 0; i < k && i + idx < arr.length; i++) {
            int currValue = arr[idx + i];
            maxValue = Math.max(maxValue, currValue);
            int currSum = maxValue * (i + 1) + maxSum(arr, idx + i + 1, k, memo);
            maxSum = Math.max(maxSum, currSum);
        }

        return memo[idx] = maxSum;
    }
}
