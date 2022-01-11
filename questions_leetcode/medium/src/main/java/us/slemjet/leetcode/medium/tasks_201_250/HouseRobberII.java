package us.slemjet.leetcode.medium.tasks_201_250;

/**
 * 213. House Robber II
 */
public class HouseRobberII {

    /**
     * Iterative approach
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 25.94%
     */
    public int rob(int[] nums) {
        // General idea is to start either from first house or from second house and get the max result
        if (nums.length == 1) return nums[0];

        // Start from 1 house -> finish on n-1
        int firstA = 0;
        int firstB = nums[0];
        // start from 2 house - finish on n
        int secondA = 0;
        int secondB = nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            int currentFirst = Math.max(nums[i] + firstA, firstB);
            firstA = firstB;
            firstB = currentFirst;

            int currentSecond = Math.max(nums[i + 1] + secondA, secondB);
            secondA = secondB;
            secondB = currentSecond;
        }
        return Math.max(firstB, secondB);
    }

    /**
     * Bottom Up
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 31.88%
     */
    public int robBottomUp(int[] nums) {

        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp1 = new int[nums.length - 1]; // For counts starting from 1 house (excluding last)
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        int[] dp2 = new int[nums.length - 1]; // For counts starting from 2 house (including last)
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < nums.length - 1; i++) {
            // Can take either previous or current + [i - 2] We calculate together for both cases
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], nums[i + 1] + dp2[i - 2]);
        }

        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }

    /**
     * Top To Bottom
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 25.94%
     */
    public int robTopToBottom(int[] nums) {
        if (nums.length == 1) return nums[0];

        Integer[] memo1 = new Integer[nums.length];
        Integer[] memo2 = new Integer[nums.length];
        return Math.max(
                robTopToBottom(nums, memo1, 0, nums.length - 2),
                robTopToBottom(nums, memo2, 1, nums.length - 1));
    }

    private int robTopToBottom(int[] nums, Integer[] memo, int start, int current) {
        if (current < 0 || current < start) return 0;
        if (memo[current] == null) {
            memo[current] = Math.max(
                    robTopToBottom(nums, memo, start, current - 1),
                    nums[current] + robTopToBottom(nums, memo, start, current - 2));
        }
        return memo[current];
    }
}
