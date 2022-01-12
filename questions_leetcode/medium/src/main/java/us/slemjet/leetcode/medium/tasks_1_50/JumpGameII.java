package us.slemjet.leetcode.medium.tasks_1_50;

/**
 * 45. Jump Game II
 */
public class JumpGameII {

    /**
     * Using greedy algorithm
     * Runtime: 99.97%
     * Memory Usage: 57.08%
     */
    public int jump(int[] nums) {

        int jumps = 0;
        int currEndIdx = 0;
        int maxJump = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // Check if maxJump is larger than previous value
            maxJump = Math.max(maxJump, i + nums[i]);

            //   check if reached end of current jump
            if (i == currEndIdx) {
                // if so - make jump
                jumps++;
                // current farthest is where next jump needs to be performed
                currEndIdx = maxJump;
            }
        }
        return jumps;
    }

    /**
     * Bottom Up
     * <p>
     * Runtime: 48.32%
     * Memory Usage: 15.86%
     */
    public int jumpBottomUp(int[] nums) {
        int[] jumps = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int reach = Math.min(i + nums[i], nums.length - 1);
            int currJumps = jumps[i];

            for (int j = reach; j > i; j--) {
                if (jumps[j] == 0) jumps[j] = currJumps + 1; // Can make jump to this position from current
                else break;
            }
        }
        return jumps[jumps.length - 1];
    }

    /**
     * Bottom Up 2 Variant
     * <p>
     * Runtime: 5.02%
     * Memory Usage: 5.17%
     */
    public int jumpBottomUp2(int[] nums) {
        return minJumps(nums, new Integer[nums.length], 0);
    }

    private int minJumps(int[] nums, Integer[] memo, int i) {
        if (i >= nums.length - 1) return 0;
        if (memo[i] != null) return memo[i];

        // Check all the next values
        memo[i] = nums.length; // Set as max values initially
        for (int j = 1; j <= nums[i]; j++) {
            memo[i] = Math.min(memo[i], 1 + minJumps(nums, memo, i + j));
        }
        return memo[i];
    }

    /**
     * Top to Bottom approach
     *
     * Runtime: 16.86%
     * Memory Usage: 11.91%
     */
    public int jumpTopToBottom(int[] nums) {
        int[] stepsToEnd = new int[nums.length];

        for (int i = nums.length - 2; i >= 0; i--) {
            stepsToEnd[i] = nums.length; // Set to max by default
            // For every position to the left check which can reach current with minimum of steps
            for (int j = 1; j <= nums[i] && j < nums.length - i; j++)
                stepsToEnd[i] = Math.min(stepsToEnd[i], 1 + stepsToEnd[i + j]);
        }
        return stepsToEnd[0];
    }

    /**
     * Use regions per each step max reach and calculate next region max reach.
     * Runtime: 57.03%
     * Memory Usage: 12.54%
     */
    public int jump2(int[] nums) {
        // If nums.length < 2, means that we do not
        // need to move at all.
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // First set up current region, which is
        // from 0 to nums[0].
        int l = 0;
        int r = nums[0];
        // Since the length of nums is greater than
        // 1, we need at least 1 step.
        int step = 1;

        // We go through all elements in the region.
        while (l <= r) {

            // If the right of current region is greater
            // than nums.length - 1, that means we are done.
            if (r >= nums.length - 1) {
                return step;
            }

            // We should know how far can we reach in current
            // region.
            int max = Integer.MIN_VALUE;
            for (; l <= r; l++) {
                max = Math.max(max, l + nums[l]);
            }

            // If we can reach far more in this round, we update
            // the boundary of current region, and also add a step.
            if (max > r) {
                l = r;
                r = max;
                step++;
            }
        }

        // We can not finish the job.
        return -1;
    }
}
