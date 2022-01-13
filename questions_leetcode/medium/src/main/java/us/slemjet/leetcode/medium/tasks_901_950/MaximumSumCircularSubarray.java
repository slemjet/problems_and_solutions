package us.slemjet.leetcode.medium.tasks_901_950;

/**
 * 918. Maximum Sum Circular Subarray
 */
public class MaximumSumCircularSubarray {

    /**
     * Runtime: 4 ms, faster than 79.71%
     * Memory Usage: 45.3 MB, less than 87.04%
     */
    public int maxSubarraySumCircular(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int curMax = 0;

        int minSum = Integer.MAX_VALUE;
        int curMin = 0;

        int sum = 0;

        for (int val : nums) {
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

    /**
     * Kadane Algorithm variation
     *
     * Runtime: 99.84%
     * Memory Usage: 96.20%
     */
    public int maxSubarraySumCircular2(int[] nums) {

        int sum = 0;
        for (int num: nums){
            sum += num;
        }

        if(nums.length == 1) return sum;

        // nums(0) + nums(1) + ... + nums(i) + nums(j) + nums(j + 1) + ... nums(N) = sum nums() + kadane(B)
        int oneIntervalSum = kadane(nums, 0, nums.length - 1, 1);
        // For two interval sum we get bigger of 2: 1 ... n and 0 ... n-1
        // sum nums(k) = sum n - kadane nums(n)
        int twoInterval0 = sum + kadane(nums, 0, nums.length - 2, -1);
        int twoInterval1 = sum + kadane(nums, 1, nums.length - 1, -1);

        return Math.max(oneIntervalSum, Math.max(twoInterval0, twoInterval1));
    }

    private int kadane(int[] A, int start, int end, int sign) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) {
            int num = sign * A[i];
            currSum = num + Math.max(currSum, 0);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
