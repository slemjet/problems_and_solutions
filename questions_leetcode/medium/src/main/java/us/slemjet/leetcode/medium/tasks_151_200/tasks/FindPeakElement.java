package us.slemjet.leetcode.medium.tasks_151_200.tasks;

/**
 * 162. Find Peak Element
 */
public class FindPeakElement {

    /**
     * Runtime: 100.00%
     * Memory Usage: 5.28%
     */
    public int findPeakElement(int[] nums) {

        // Invariants: nums[left - 1] < nums[left] && nums[right] > nums[right + 1]
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) { // ascending slope to the right
                left = mid + 1;
            } else { // ascending slope to the left
                right = mid;
            }
        }

        return left;
    }
}
