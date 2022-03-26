package us.slemjet.leetcode.easy.from_701_to_750;

/**
 * 704. Binary Search
 */
public class BinarySearch {

    /**
     * Runtime: 100.00%
     * Memory Usage: 32.63%
     */
    public int search(int[] nums, int target) {

        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if (nums[midIdx] == target) return midIdx;
            else if (nums[midIdx] > target) rightIdx = midIdx - 1;
            else leftIdx = midIdx + 1;
        }

        return -1;
    }
}
