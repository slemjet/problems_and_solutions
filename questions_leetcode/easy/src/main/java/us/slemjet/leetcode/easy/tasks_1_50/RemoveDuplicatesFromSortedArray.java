package us.slemjet.leetcode.easy.tasks_1_50;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int uniqueIndex = 0; // index of the last unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        nums = Arrays.copyOf(nums, uniqueIndex + 1);
        return nums.length;
    }
}
