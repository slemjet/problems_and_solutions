package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * Runtime: 100.00%
     * Memory Usage: 16.97%
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int left = 2, right = left;

        while (right < nums.length) {
            if (nums[left - 2] != nums[right]) { // If current right position is correct
                // We replace the left (initially they are same)
                nums[left] = nums[right];
                left++; // Left is correct - increment
            }
            right++; // Increment right (if left was incorrect it will give us next right candidate)
        }
        return left;
    }

    /**
     * If number was not included twice already - add it
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 6.26%
     */
    public int removeDuplicatesMinimalistic(int[] nums) {
        int idx = 0;
        for (int num : nums)
            if (idx < 2 || num > nums[idx - 2])
                nums[idx++] = num;
        return idx;
    }
}
