package us.slemjet.leetcode.medium.tasks_1_50;

import java.util.Arrays;

/**
 * Time: 100%
 * Memory: 97.16%
 *
 * Time complexity: 2 * O(logn)
 * Space complexity: (1)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums.length == 0)
            return result;

        // search for leftmost occurrence
        int start = 0, end = nums.length - 1, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target)
                end = mid;
            else
                start = mid + 1;
        }

        if (nums[start] == target)
            result[0] = start;
        else return result;

        // scan for last occurrence -> get leftmost bigger element. than target will have index start - 1
        end = nums.length - 1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }

        result[1] = nums[start] == target ? start : start - 1;

        return result;
    }
}
