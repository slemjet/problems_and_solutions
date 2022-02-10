package us.slemjet.leetcode.medium.tasks_501_550;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 532. K-diff Pairs in an Array
 */
public class KDiffPairsInAnArray {

    /**
     * Sort + Binary Search
     *
     * Runtime: 91.52%
     * Memory Usage: 23.65%
     */
    public int findPairsBinary(int[] nums, int k) {

        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Duplicate

            // Get complement value for current number
            int complementValue = nums[i] + k;
            // Scan remaining array contains complement value
            if (Arrays.binarySearch(nums, i + 1, nums.length, complementValue) > -1) result++;
        }
        return result;
    }

    /**
     * Sort + 2 pointers
     *
     * Runtime: 74.33%
     * Memory Usage: 49.10%
     */
    public int findPairs2Pointers(int[] nums, int k) {

        int result = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = 1;

        while (right < nums.length) {

            while (left > 0 && left < nums.length && nums[left] == nums[left - 1]) // Remove duplicates
                left++;
            while (left >= right || right < nums.length && nums[right] < nums[left] + k) // Find next potential complement
                right++;

            if (right < nums.length && nums[left] + k == nums[right]) { // Found combination
                left++;
                right++;
                result++;
                continue;
            }

            left++;
        }

        return result;
    }

    /**
     * Map + Count
     *
     * Runtime: 44.48%
     * Memory Usage: 5.75%
     */
    public int findPairs(int[] nums, int k) {
        int result = 0;

        Map<Integer, Integer> values = new HashMap<>();

        for (int num : nums) {
            values.putIfAbsent(num, 0);
            values.put(num, values.get(num) + 1);
        }

        for (int value : values.keySet()) {
            if (k == 0 && values.get(value) > 1) result++;
            if (k > 0 && values.containsKey(value + k) && values.get(value + k) > 0) result++;
        }
        return result;
    }
}
