package us.slemjet.leetcode.medium.tasks_351_400;

/**
 * 377. Combination Sum IV
 */
public class CombinationSumIV {

    /**
     * DP Bottom Up
     * <p>
     * Runtime: 47.82%
     * Memory Usage: 5.08%
     */
    public int combinationSum4BottomUp(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num]; // Combination is a sum of all subtrees (obtained if each value is removed)
                }
            }
        }

        return dp[target];
    }

    /**
     * Top to Bottom
     *
     * Runtime: 100.00%
     * Memory Usage: 5.08%
     *
     */
    public int combinationSum4TopToBottom(int[] nums, int target) {
        return combinationSum4TopToBottom(nums, target, new Integer[target + 1]);
    }

    private int combinationSum4TopToBottom(int[] nums, int target, Integer[] memo) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if(memo[target] != null) return memo[target];

        memo[target] = 0;
        for (int num: nums){
            memo[target] += combinationSum4TopToBottom(nums, target - num, memo);
        }

        return memo[target];
    }
}
