package us.slemjet.leetcode.easy.tasks_1901_1950;

/**
 * 1913. Maximum Product Difference Between Two Pairs
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    /**
     * Time: O(n) -> 80.07%
     * Space: O(1) -> 6.62
     */
    public int maxProductDifference(int[] nums) {

        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int val : nums) {
            if (min > val) {
                min2 = min;
                min = val;
            } else {
                min2 = Math.min(min2, val);
            }

            if (max < val) {
                max2 = max;
                max = val;
            } else {
                max2 = Math.max(max2, val);
            }
        }

        int result = max * max2 - min * min2;

        return result;
    }
}
