package us.slemjet.leetcode.easy.from_50_to_100;

/**
 * 53. Maximum Subarray
 */
public class MaximumSubarray {

    /**
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
     * Bottom Up approach
     * Runtime: 74.15%
     * Memory Usage: 24.01%
     */
    public int maxSubArray2(int[] nums) {

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] =  Math.max(nums[i - 1] + nums[i], nums[i]);
            result = Math.max(nums[i], result);
        }

        return result;
    }
}
