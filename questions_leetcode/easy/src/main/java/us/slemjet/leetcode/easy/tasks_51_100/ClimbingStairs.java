package us.slemjet.leetcode.easy.tasks_51_100;

/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {

    /**
     * Top to Bottom
     *
     * Runtime: 100.00%
     * Memory Usage: 35.25%
     */
    public int climbStairsTopToBottom(int n) {
        return climbStairsMemo(n, new int[n + 1]);
    }

    private int climbStairsMemo(int n, int[] memo) {
        if (n <= 2) return n;

        // Combinations can be 1 for 1 and 2 for 2 (2 and 1+1), the rest is a sum of 2 previous combinations
        if (memo[n] == 0) {
            memo[n] = climbStairsMemo(n - 2, memo) + climbStairsMemo(n - 1, memo);
        }
        return memo[n];
    }

    /**
     * Bottom Up
     *
     * Runtime: 100.00%
     * Memory Usage: 27.30%
     */
    public int climbStairsBottomUp(int n) {
        if(n <= 2) return n;

        int[] combinations = new int[n + 1];
        combinations[1] = 1;
        combinations[2] = 2;

        for (int i = 3; i <= n; i++) {
            combinations[i] = combinations[i - 2] + combinations[i - 1];
        }

        return combinations[n];
    }
}
