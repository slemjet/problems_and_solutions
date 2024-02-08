package us.slemjet.leetcode.hard.tasks_301_350;

/**
 * 312. Burst Balloons
 */
public class BurstBalloons {

    /**
     * Time: O(n^3) ->  5.15%
     * Space:O(n^2) -> 5.22%
     */
    public int maxCoins(int[] nums) {

        int length = nums.length;

        // Create array, containing 1 at its boundaries
        int[] withOnes = new int[length + 2];
        System.arraycopy(nums, 0, withOnes, 1, length);
        withOnes[0] = 1;
        withOnes[withOnes.length - 1] = 1;

        Integer[][] memo = new Integer[withOnes.length][withOnes.length];
        return maxCoins(withOnes, 1, withOnes.length - 2, memo);
    }

    private int maxCoins(int[] nums, int left, int right, Integer[][] memo) {

        if (left > right) {
            return 0;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int max = 0;

        // For each position - get sum of left subset + right subset + outer boundaries product
        for (int i = left; i <= right; i++) {
            int leftCount = maxCoins(nums, left, i - 1, memo);
            int rightCount = maxCoins(nums, i + 1, right, memo);
            int currentCount = nums[left - 1] * nums[i] * nums[right + 1];
            max = Math.max(max, leftCount + rightCount + currentCount);
        }

        return memo[left][right] = max;
    }
}
