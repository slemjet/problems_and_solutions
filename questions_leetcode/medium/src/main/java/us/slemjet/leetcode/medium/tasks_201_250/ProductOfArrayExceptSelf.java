package us.slemjet.leetcode.medium.tasks_201_250;

/**
 * 238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {

    /**
     * Runtime: 100.00%
     * Memory Usage: 86.10%
     */
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        // Populate result array with all the prefixes
        for (int i = 0; i < nums.length; i++) {
            int prev = i > 0 ? result[i - 1] : 1;
            result[i] = prev * nums[i];
        }

        // Suffix aggregator
        int suffix = 1;

        // Iterate over the result (prefix) array and populate using suffix
        for (int i = result.length - 1; i >= 0 ; i--) {
            int prefix = i > 0 ? result[i - 1] : 1;
            result[i] = prefix * suffix;
            suffix *= nums[i]; // Suffix is multiplication of elements backwards
        }

        return result;
    }
}
