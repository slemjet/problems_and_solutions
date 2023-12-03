package us.slemjet.leetcode.easy.from_2151_to_2200;

import java.util.Arrays;

/**
 * 2154. Keep Multiplying Found Values by Two
 */
public class KeepMultiplyingFoundValuesByTwo {

    /**
     * Time: O(nlogn) -> 59.68%
     * Space: O(1) -> 26.79%
     */

    public int findFinalValue(int[] nums, int original) {

        Arrays.sort(nums);

        int idx = 0;

        while (original <= nums[nums.length - 1]) {
            idx = Arrays.binarySearch(nums, idx, nums.length, original);
            if (idx < 0) return original;
            else original = original << 1;
        }

        return original;
    }
}
