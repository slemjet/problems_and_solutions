package us.slemjet.leetcode.easy.arrays;

public class SearchInsertPosition {

    /**
     * Runtime: 100%
     * Space: 100%
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // check if result is out of the borders
            if (nums[start] > target)
                return start;
            if (nums[end] < target)
                return end + 1;
            // else regular binary search
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start + 1;
    }
}
