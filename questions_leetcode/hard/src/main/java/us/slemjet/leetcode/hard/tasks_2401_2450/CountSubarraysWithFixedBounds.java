package us.slemjet.leetcode.hard.tasks_2401_2450;

/**
 * 2444. Count Subarrays With Fixed Bounds
 */
public class CountSubarraysWithFixedBounds {

    /**
     * Time: O(n)   ->  51.62%
     * Space:O(n)   ->  74.73%
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {

        long result = 0;

        int left = -1;
        int minIdx = -1;
        int maxIdx = -1;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            if (num > maxK || num < minK) {
                // Number out of range - move left idx and reset min and max
                left = right;
            } else {
                if (num == minK) {
                    minIdx = right; // Set new max idx
                }
                if (num == maxK) {
                    maxIdx = right; // Set new min idx
                }
                if (minIdx >= left && minIdx <= right && maxIdx >= left && maxIdx <= right) {
                    // Both min and max are inside interval - count subarrays
                    // current subarrays count = leftmost min/max idx - start of subarray
                    result += Math.min(minIdx, maxIdx) - left;
                }
            }
        }

        return result;
    }
}
