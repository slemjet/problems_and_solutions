package us.slemjet.leetcode.easy.arrays;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int index = -1;
        int movedIndex = -1; // index of the last moved element
        while (index < nums.length - 1) {
            index++;
            if (nums[index] != val) {
                movedIndex++;
                nums[movedIndex] = nums[index]; // move correct elements
            }
        }

        nums = Arrays.copyOf(nums, movedIndex + 1);
        return nums.length;
    }
}
