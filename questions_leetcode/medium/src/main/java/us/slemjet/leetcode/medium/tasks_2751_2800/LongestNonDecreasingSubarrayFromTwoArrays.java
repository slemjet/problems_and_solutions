package us.slemjet.leetcode.medium.tasks_2751_2800;

/**
 * 2771. Longest Non-decreasing Subarray From Two Arrays
 */
public class LongestNonDecreasingSubarrayFromTwoArrays {

    /**
     * Time: O(n)   ->  44.06%
     * Space:O(n)   ->  72.56%
     */
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {

        int result = 0;

        int[][] dp = new int[nums1.length][2];

        for (int i = 0; i < nums1.length; i++) {

            dp[i][0] = 1;
            dp[i][1] = 1;

            if (i > 0) {
                if (nums1[i - 1] <= nums1[i]) {
                    dp[i][0] = 1 + dp[i - 1][0];
                }
                if (nums2[i - 1] <= nums1[i]) {
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[i - 1][1]);
                }

                if (nums2[i - 1] <= nums2[i]) {
                    dp[i][1] = 1 + dp[i - 1][1];
                }
                if (nums1[i - 1] <= nums2[i]) {
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[i - 1][0]);
                }
            }

            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        return result;
    }
}
