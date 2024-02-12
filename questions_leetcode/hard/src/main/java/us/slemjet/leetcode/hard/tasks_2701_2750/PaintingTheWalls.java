package us.slemjet.leetcode.hard.tasks_2701_2750;

/**
 * 2742. Painting the Walls
 */
public class PaintingTheWalls {

    /**
     * Top To Bottom = Memoization
     * <p>
     * Time: O(n^2) ->  22.02%
     * Space:O(n^2) ->  67.28%
     */
    public int paintWallsTopToBottom(int[] cost, int[] time) {

        int[][] memo = new int[cost.length][cost.length + 1];

        return paintWallsTopToBottom(cost, time, 0, cost.length, memo);
    }

    private int paintWallsTopToBottom(int[] cost, int[] time, int idx, int remainingWalls, int[][] memo) {

        if (remainingWalls <= 0) {
            return 0; // Reached goal
        }
        if (idx == cost.length) {
            return Integer.MAX_VALUE - 1000000; // Reached end of array without reaching goals - return max result
        }

        if (memo[idx][remainingWalls] == 0) {
            // We can either decide to paint this wall
            int sumIfPaintThisWall = cost[idx] + paintWallsTopToBottom(cost, time, idx + 1, remainingWalls - time[idx] - 1, memo);
            // Or skip it
            int sumIfSkipThisWall = paintWallsTopToBottom(cost, time, idx + 1, remainingWalls, memo);

            memo[idx][remainingWalls] = Math.min(sumIfPaintThisWall, sumIfSkipThisWall);
        }

        return memo[idx][remainingWalls];
    }

    /**
     * Bottom Up = Tabulation
     * <p>
     * Time: O(n^2) ->  77.98%
     * Space:O(n^2) ->  30.25%
     */
    public int paintWallsBottomUp(int[] cost, int[] time) {

        int wallsCount = cost.length;
        int[][] dp = new int[wallsCount + 1][wallsCount + 1];

        for (int i = 1; i <= wallsCount; i++) {
            // If there is still time after reaching end - fail (except 0)
            dp[wallsCount][i] = Integer.MAX_VALUE - 10000000;
        }

        for (int i = wallsCount - 1; i >= 0; i--) {
            for (int j = 1; j <= wallsCount; j++) {
                int sumIfPaintThisWall = cost[i] + dp[i + 1][Math.max(0, j - time[i] - 1)];
                int sumIfSkipThisWall = dp[i + 1][j];
                // Either paint this wall or skip it
                dp[i][j] = Math.min(sumIfPaintThisWall, sumIfSkipThisWall);
            }
        }

        return dp[0][wallsCount];
    }
}
