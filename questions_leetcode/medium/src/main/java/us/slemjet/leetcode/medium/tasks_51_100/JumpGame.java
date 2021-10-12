package us.slemjet.leetcode.medium.tasks_51_100;

public class JumpGame {

    /**
     * Runtime: 99.39%
     * Memory Usage: 63.16%
     */
    public boolean canJump(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                // Cannot move forward from this position
                return false;
            }
            // Check if max is larger than previous value
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }
}
