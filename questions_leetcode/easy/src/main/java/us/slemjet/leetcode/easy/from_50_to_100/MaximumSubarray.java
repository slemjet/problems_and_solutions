package us.slemjet.leetcode.easy.from_50_to_100;

/**
 * 53. Maximum Subarray
 */
public class MaximumSubarray {

    /**
     * Kadane algorithm
     *
     * Runtime: 74.15%
     * Memory Usage: 5.00%
     */
    public int maxSubArray(int[] nums) {

        int result = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums) {
            currSum = Math.max(currSum + num, num);
            result = Math.max(currSum, result);
        }

        return result;
    }

    /**
     * Divide and conquer
     *
     * Runtime: 5.40%
     * Memory Usage: 41.32%
     */
    public int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSumDivideAndConquer(nums, 0, nums.length - 1);
    }

    private int maxSumDivideAndConquer(int[] nums, int left, int right) {
        if(left == right) return nums[left];

        int mid = left + (right - left ) / 2;
        int currSum = 0;
        int leftMaxSum = Integer.MIN_VALUE;

        // Calculate left subset
        for (int i = mid; i >= left; i--) {
            currSum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, currSum);
        }

        currSum = 0;
        int rightMaxSum = Integer.MIN_VALUE;
        // Calculate right subset
        for (int i = mid + 1; i <= right; i++) {
            currSum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, currSum);
        }

        int maxRightOrLeft = Math.max(maxSumDivideAndConquer(nums, left, mid), maxSumDivideAndConquer(nums, mid + 1, right));
        int maxRightAndLeft = leftMaxSum + rightMaxSum;

        return Math.max(maxRightAndLeft, maxRightOrLeft);
    }

    /**
     * Bottom Up approach
     * Runtime: 74.15%
     * Memory Usage: 24.01%
     */
    public int maxSubArrayBottomUp(int[] nums) {

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            result = Math.max(nums[i], result);
        }

        return result;
    }

    /**
     * Top to Bottom
     *
     * Runtime: 5.40%
     * Memory Usage: 6.08%
     */
    public int maxSubArrayTopToBottom(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        maxSubArray(nums, memo, nums.length - 1);
        return max;
    }

    int max = Integer.MIN_VALUE;
    private int maxSubArray(int[] nums, Integer[] memo, int i) {
        if (i < 0) return 0;
        if (memo[i] != null) return memo[i];

        memo[i] = Math.max(nums[i], nums[i] + maxSubArray(nums, memo, i - 1));
        max = Math.max(max, memo[i]);
        return memo[i];
    }
}
