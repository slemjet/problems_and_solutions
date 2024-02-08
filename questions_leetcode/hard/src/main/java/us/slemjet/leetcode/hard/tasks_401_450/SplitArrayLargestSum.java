package us.slemjet.leetcode.hard.tasks_401_450;

/**
 * 410. Split Array Largest Sum
 */
public class SplitArrayLargestSum {

    /**
     * Runtime: 91.22%
     * Memory Usage: 68.98%
     */
    public int splitArrayBinary(int[] nums, int k) {

        // Edge cases
        if (nums == null || nums.length == 0 || k == 0) return 0;

        int max = 0; // Lower boundary of binary search - max element
        int sum = 0; // Higher boundary of binary search - sum of elements

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        if (k == nums.length) return max;
        if (k == 1) return sum;

        int result = 0;
        int low = max;
        int high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Candidate for min sum

            if (canSplitSubArrays(nums, mid, k)) {
                // Can split - try with lower sum
                result = mid;
                high = mid - 1;
            } else {
                // Cannot split - increase sum
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canSplitSubArrays(int[] nums, int sum, int k) {
        int currSum = 0;
        int subArraysCount = 1;

        for (int num : nums) {
            currSum += num;
            if (currSum > sum) {
                // Start new subarray
                currSum = num;
                subArraysCount++;
            }
        }

        // If can create enough subarrays
        return subArraysCount <= k;
    }

    /**
     * Runtime: 5.00%
     * Memory Usage: 89.23%%
     */
    public int splitArrayDfs(int[] nums, int k) {

        Integer[][] memo = new Integer[nums.length][k];
        return dfs(nums, 0, k - 1, memo);
    }

    private int dfs(int[] nums, int position, int k, Integer[][] memo) {

        if (memo[position][k] != null) return memo[position][k];

        if (k == 0) {
            // No more intervals -> just calculate sum
            int sum = 0;
            for (int i = position; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum;
        }

        int minSum = Integer.MAX_VALUE;
        int maxLocalSum = 0;
        int sum = 0;

        for (int i = position; i < nums.length - k; i++) {

            sum += nums[i];
            int remainingMinSum = dfs(nums, i + 1, k - 1, memo);
            // Get minimum of all max per remaining subsets
            maxLocalSum = Math.max(sum, remainingMinSum);
            minSum = Math.min(minSum, maxLocalSum);
        }

        return memo[position][k] = minSum;
    }

}
