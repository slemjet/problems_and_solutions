package us.slemjet.leetcode.medium.tasks_2951_3000.tasks;

import java.util.Arrays;

/**
 * 2966. Divide Array Into Arrays With Max Difference
 */
public class DivideArrayIntoArraysWithMaxDifference {

    /**
     * Time: O(nlogn)   ->  93.20%
     * Space:O(n)       ->  11.55%
     */
    public int[][] divideArray(int[] nums, int k) {

        int[][] arrays = new int[nums.length / 3][3];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 3) {
            int first = arrays[i / 3][0] = nums[i];
            arrays[i / 3][1] = nums[i + 1];
            int last = arrays[i / 3][2] = nums[i + 2];

            if (last - first > k) {
                return new int[][]{};
            }
        }

        return arrays;
    }
}
