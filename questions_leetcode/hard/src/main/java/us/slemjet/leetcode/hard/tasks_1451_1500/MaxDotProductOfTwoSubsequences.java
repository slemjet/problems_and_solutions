package us.slemjet.leetcode.hard.tasks_1451_1500;

/**
 * 1458. Max Dot Product of Two Subsequences
 */
public class MaxDotProductOfTwoSubsequences {

    /**
     * Bottom Up (Tabulation)
     * </p>
     * Time: O(n*m) ->  96.95%
     * Space:O(n*m) ->  63.96%
     */
    public int maxDotProductBottomUp(int[] nums1, int[] nums2) {

        // We need to take at least one product - even if it is negative
        // Check for negative only case
        int num1Min = Integer.MAX_VALUE;
        int num1Max = Integer.MIN_VALUE;
        int num2Min = Integer.MAX_VALUE;
        int num2Max = Integer.MIN_VALUE;

        for (int num1 : nums1) {
            num1Min = Math.min(num1Min, num1);
            num1Max = Math.max(num1Max, num1);
        }

        for (int num2 : nums2) {
            num2Min = Math.min(num2Min, num2);
            num2Max = Math.max(num2Max, num2);
        }

        if (num1Max < 0 && num2Min > 0) {
            // All num1 negative & all num2 positive -> Return  minimum negative product
            return num1Max * num2Min;
        }

        if (num2Max < 0 && num1Min > 0) {
            // All num2 negative & all num1 positive -> Return  minimum negative product
            return num2Max * num1Min;
        }

        // Proceed with the main scenario - there is at least one positive product
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        // Base case - when i = nums1.length -> dp[i][] = 0 no more combinations, same if j = nums2.length
        // We start iterating from base case
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {

                dp[i][j] = Math.max(
                        // For each combination of i,j we can:
                        nums1[i] * nums2[j] + dp[i + 1][j + 1], // Take current product and max sum for remaining indices
                        Math.max(
                                // Dont take this product and
                                dp[i + 1][j], // Skip to next i
                                dp[i][j + 1]  // Skip to next j
                        )
                );
            }
        }

        return dp[0][0]; // Maximum sums accumulated at the start
    }

    /**
     * Top To Bottom (Memoization)
     * </p>
     * Time: O(n*m) ->  5.08%
     * Space:O(n*m) ->  80.20%
     */
    public int maxDotProductTopToBottom(int[] nums1, int[] nums2) {

        // We need to take at least one product - even if it is negative
        // Check for negative only case
        int num1Min = Integer.MAX_VALUE;
        int num1Max = Integer.MIN_VALUE;
        int num2Min = Integer.MAX_VALUE;
        int num2Max = Integer.MIN_VALUE;

        for (int num1 : nums1) {
            num1Min = Math.min(num1Min, num1);
            num1Max = Math.max(num1Max, num1);
        }

        for (int num2 : nums2) {
            num2Min = Math.min(num2Min, num2);
            num2Max = Math.max(num2Max, num2);
        }

        if (num1Max < 0 && num2Min > 0) {
            // All num1 negative & all num2 positive -> Return  minimum negative product
            return num1Max * num2Min;
        }

        if (num2Max < 0 && num1Min > 0) {
            // All num2 negative & all num1 positive -> Return  minimum negative product
            return num2Max * num1Min;
        }

        // Proceed with the main scenario - there is at least one positive product
        return maxDotProductTopToBottom(0, 0, nums1, nums2, new int[nums1.length][nums2.length]);
    }

    private int maxDotProductTopToBottom(int idx1, int idx2, int[] nums1, int[] nums2, int[][] memo) {

        if (idx1 == nums1.length || idx2 == nums2.length) {
            return 0;
        }

        if (memo[idx1][idx2] == 0) {

            memo[idx1][idx2] = Math.max(
                    // Take the product
                    nums1[idx1] * nums2[idx2] + maxDotProductTopToBottom(idx1 + 1, idx2 + 1, nums1, nums2, memo),
                    // Skip either index
                    Math.max(
                            maxDotProductTopToBottom(idx1 + 1, idx2, nums1, nums2, memo),
                            maxDotProductTopToBottom(idx1, idx2 + 1, nums1, nums2, memo))
            );
        }

        return memo[idx1][idx2];
    }

}
