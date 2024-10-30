package us.slemjet.leetcode.medium.tasks_2351_2400;

/**
 * 2393. Count Strictly Increasing Subarrays
 */
public class CountStrictlyIncreasingSubarrays {

    /**
     * Time: O(n)   ->  57.14%
     * Space O(i)   ->  51.16%
     */
    public long countSubarrays(int[] nums) {

        long result = 0L;

        int lastIdx = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] <= nums[i - 1]) {
                lastIdx = i;
            }
            result += i - lastIdx + 1;
        }

        return result;
    }
}
