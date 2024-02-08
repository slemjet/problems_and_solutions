package us.slemjet.leetcode.easy.tasks_1401_1450;

/**
 * 1413. Minimum Value to Get Positive Step by Step Sum
 */
public class MinimumValueToGetPositiveStepByStepSum {

    /**
     * Runtime: 100.00%
     * Memory Usage: 10.60%
     */
    public int minStartValue(int[] nums) {

        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            minSum = Math.min(minSum, nums[i]);
        }

        return - Math.min(0, minSum) + 1;
    }
}
