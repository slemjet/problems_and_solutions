package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 81. Search in Rotated Sorted Array II
 */
public class SearchInRotatedSortedArrayII {

    /**
     * Runtime: 86.21%
     * Memory Usage: 24.98%
     */
    public boolean search(int[] nums, int target) {

        if (nums.length == 0) return false;

        return find(nums, 0, nums.length - 1, target);
    }

    private boolean find(int[] nums, int start, int end, int target) {
        int mid = (end + start) / 2;
        if (nums[mid] == target)
            return true;
        if (start > end)
            return false;
        if (nums[start] == nums[mid]) {
            // !IMPORTANT Cannot decide which side to go -> Shift start iteratively until we know
            return find(nums, start + 1, end, target);
        } else if (nums[start] > nums[mid]) {
            // second half is sorted [...pivot...] mid [...sorted...]
            if (target < nums[mid] || target >= nums[start])
                return find(nums, start, mid - 1, target); // search in left part
            else
                return find(nums, mid + 1, end, target); // search in right part
        } else
            // first half is sorted   [...sorted...] mid [...pivot...]
            if (target < nums[mid] && target >= nums[start])
                return find(nums, start, mid - 1, target); // search in left part
            else
                return find(nums, mid + 1, end, target); // search in right part
    }
}
