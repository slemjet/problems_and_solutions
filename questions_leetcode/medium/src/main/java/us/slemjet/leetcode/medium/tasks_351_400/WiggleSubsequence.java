package us.slemjet.leetcode.medium.tasks_351_400;

/**
 * 376. Wiggle Subsequence
 */
public class WiggleSubsequence {

    /**
     * DP Bottom Up
     * There can be either up or down movement (== doesent change anything)
     * Use 2 arrays up and down to keep track max sequence length up to i
     *
     * Runtime: 100.00%
     * Memory Usage: 41.47%
     */
    public int wiggleMaxLength(int[] nums) {

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            } else if (nums[i] > nums[i - 1]) {
                // Moved up - sp combine with previous move down sequence
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else {
                // Moved down - combine with previous down sequence
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[down.length - 1], up[up.length - 1]);
    }
}
