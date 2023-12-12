package us.slemjet.leetcode.easy.from_1451_to_1500;

import java.util.Arrays;

/**
 * 1464. Maximum Product of Two Elements in an Array
 */
public class MaximumProductOfTwoElementsInAnArray {

    /**
     * Time: O(n) -> 78.72%
     * Space: O(1) -> 86.85%
     */
    public int maxProduct(int[] nums) {

        int max = Math.max(nums[0], nums[1]);
        int max2 = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num >= max) {
                max2 = max;
                max = num;
            } else {
                max2 = Math.max(max2, num);
            }
        }

        return (max - 1) * (max2 - 1);
    }

    public int maxProductSort(int[] nums) {

        Arrays.sort(nums);

        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
