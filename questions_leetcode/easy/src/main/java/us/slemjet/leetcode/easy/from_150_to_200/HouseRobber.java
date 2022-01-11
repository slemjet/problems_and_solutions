package us.slemjet.leetcode.easy.from_150_to_200;

/**
 * 198. House Robber
 */
public class HouseRobber {

    /**
     * Iterative approach
     *
     * Runtime: 100.00%
     * Memory Usage: 15.35%
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int a = 0; // Base scenario is a = 0 b = nums[0]
        int b = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(nums[i] + a, b);
            a = b;
            b = current;
        }
        return b;
    }

    /**
     * Bottom Up
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 19.31%
     */
    public int robBottomUp(int[] nums) {

        if (nums.length == 1) return nums[0];
        // We can do it inline using nums as dp num[0] and nums[1] are base scenarios
        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]); // Can take either previous or current + [i - 2]
        }

        return nums[nums.length - 1];
    }

    /**
     * Top To Bottom
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 15.35%
     */
    public int robTopToBottom(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return Math.max(robTopToBottom(nums, memo, nums.length - 2), nums[nums.length - 1] + robTopToBottom(nums, memo, nums.length - 3));
    }

    private int robTopToBottom(int[] nums, Integer[] memo, int i) {
        if (i < 0) return 0;
        if (memo[i] == null) {
            memo[i] = Math.max(robTopToBottom(nums, memo, i - 1), nums[i] + robTopToBottom(nums, memo, i - 2));
        }
        return memo[i];
    }
}
