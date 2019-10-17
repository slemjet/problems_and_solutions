package us.slemjet.leetcode.easy.dynamic;

public class HouseRobber {

    public int rob(int[] nums) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length ; i++) {
            memo[i] = Math.max(nums[i] + memo[i - 2], memo[i - 1]);
        }

        return memo[memo.length - 1];
    }
}
