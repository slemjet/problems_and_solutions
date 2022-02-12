package us.slemjet.leetcode.medium.tasks_151_200;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Runtime:  31.97%
     * Memory Usage: 19.82%
     */
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        // Look for infliction point - where normal sort order changed - point where nums[i - 1] > nums[i]
        while (nums[left] > nums[right]) {
            mid = left + (right - left) / 2;

            if (nums[mid] >= nums[left]) {
                // Normal sequence - infliction point is to the right
                left = mid + 1;
            } else {
                // Order changed - infliction point to the left
                right = mid;
            }
        }

        return nums[left];
    }
}
