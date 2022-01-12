package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 55. Jump Game
 */
public class JumpGame {

    /**
     * Greedy
     * <p>
     * Runtime: 99.39%
     * Memory Usage: 63.16%
     */
    public boolean canJump(int[] nums) {

        int max = 0; // Max index that can be reached

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

    /**
     * Top to Bottom
     *
     * Runtime: 21.99%
     * Memory Usage: 7.85%
     */
    public boolean canJumpBottomUp(int[] nums) {
        // DP (memo) containing results if can reach end from current position
        boolean[] canReach = new boolean[nums.length];
        canReach[canReach.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            // Go over all elements from the beginning, check if can reach current position
            for (int j = 0; j <= nums[i] && j < nums.length - i; j++) {
                if (canReach[i + j]) {
                    // Can reach from current position
                    canReach[i] = true;
                    break;
                }
            }
        }

        return canReach[0];
    }
}
