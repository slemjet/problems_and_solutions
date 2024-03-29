package us.slemjet.leetcode.medium.tasks_2951_3000;

import java.util.stream.IntStream;

/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times
 */
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    /**
     * Time: O(n)   ->  22.45%
     * Space:O(n)   ->  5.61%
     */
    public long countSubarrays(int[] nums, int k) {

        long result = 0;

        int maxNum = IntStream.of(nums).max().getAsInt();
        int maxCount = 0;

        int left = 0;

        for (int num : nums) {
            if (num == maxNum) {
                maxCount++;
            }

            while (maxCount == k) {
                if (nums[left] == maxNum) {
                    maxCount--;
                }
                left++;
            }

            // Array must start at mist at index left to have at least k max numbers.
            // All to the left inclusive will have at least 3 max numbers
            result += left;
        }

        return result;
    }
}
