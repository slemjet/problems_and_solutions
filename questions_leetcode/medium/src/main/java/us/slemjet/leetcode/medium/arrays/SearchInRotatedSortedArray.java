package us.slemjet.leetcode.medium.arrays;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums.length == 0)
            return -1;

        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int start, int end, int target) {
        int mid = (end + start) / 2;
        if (nums[mid] == target)
            return mid;
        if (start > end)
            return -1;

        if (nums[start] > nums[mid]) { // second half is sorted [...pivot...] mid [...sorted...]
            if (target < nums[mid] || target >= nums[start])
                return find(nums, start, mid - 1, target); // search in left part
            else
                return find(nums, mid + 1, end, target); // search in right part
        } else  // first half is sorted   [...sorted...] mid [...pivot...]
            if (target < nums[mid] && target >= nums[start])
                return find(nums, start, mid - 1, target); // search in left part
            else
                return find(nums, mid + 1, end, target); // search in right part
    }

    public int searchShiftFirst(int[] nums, int target) {

        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        // find min element index -> to get the rotation shift
        int shift = getMinElemIndex(nums, 0, nums.length - 1);

        int result = searchShiftFirst(nums, 0, nums.length - 1, shift, target);

        return result != -1 ? (result + shift) % nums.length : -1;
    }

    private int searchShiftFirst(int[] nums, int start, int end, int shift, int target) {
        if (start <= end) {
            int mid = (end + start) / 2;
            int length = nums.length;
            int midIdx = (mid + shift) % length;
            if (nums[midIdx] > target)
                return searchShiftFirst(nums, start, mid - 1, shift, target);
            else if (nums[midIdx] < target)
                return searchShiftFirst(nums, mid + 1, end, shift, target);
            else return mid;
        } else
            return -1;
    }

    private int getMinElemIndex(int[] nums, int start, int end) {
        if (start == end)
            return start;

        if (end - start == 1)
            return nums[start] > nums[end] ? end : start;

        int mid = (end + start) / 2;

        if (nums[start] > nums[mid]) {
            // second half is in ascending order -> minimum is in the first half
            return getMinElemIndex(nums, start, mid);
        } else if (nums[mid] > nums[end]) {
            // first half is in ascending order -> minimum is in the second half
            return getMinElemIndex(nums, mid + 1, end);
        } else
            return start;
    }
}
