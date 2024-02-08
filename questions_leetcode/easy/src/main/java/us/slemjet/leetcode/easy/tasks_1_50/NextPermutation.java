package us.slemjet.leetcode.easy.tasks_1_50;


public class NextPermutation {

    /**
     * O(n) time complexity
     * O(1) space complexity
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        int reverseFrom = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            // we search for the firs ascending pair -> so we can swap it
            if (nums[i] < nums[i + 1]) {
                // we swap this element with the smallest bigger element already occurred
                int swapIdx = i + 1, j = i + 1;
                int minBigger = nums[i + 1];
                while (j < nums.length) {
                    if (nums[j] > nums[i] && minBigger >= nums[j]) {
                        swapIdx = j;
                        minBigger = nums[j];
                    }
                    j++;
                }
                swap(nums, i, swapIdx);
                reverseFrom = i + 1;
                break;
            }
        }

        // reverse rest elements
        int i = reverseFrom, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, Integer j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
