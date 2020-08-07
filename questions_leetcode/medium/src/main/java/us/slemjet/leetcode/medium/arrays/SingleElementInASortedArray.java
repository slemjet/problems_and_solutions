package us.slemjet.leetcode.medium.arrays;

public class SingleElementInASortedArray {

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 40 MB, less than 12.01%
     */
    public int singleNonDuplicate(int[] nums) {

        int min = 0;
        int max = nums.length - 1;
        int mid = 0;

        while (min < max) {

            mid = min + (max - min) / 2;

            if (mid % 2 == 1) { // first element of the pair is at even index
                mid--; // set index to first element of the pair
            }

            // check if elements are equal
            if (nums[mid] != nums[mid + 1]) {
                // left part is incorrect - it contains single element
                max = mid; // proceed with search in left sub array
            } else {
                // left is correct - skip 2 chars (mid and mid + 1)
                min = mid + 2; // and proceed with right subarray
            }
        }

        return nums[min];
    }
}
