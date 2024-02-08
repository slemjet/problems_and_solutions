package us.slemjet.leetcode.hard.tasks_151_200;

/**
 * 174. Dungeon Game
 */
public class DungeonGame {

    /**
     * Time: O(n*m) -> 81.75%
     * Space: O(n*m) -> 48.37%
     */
    public int calculateMinimumHP(int[][] dungeon) {

        // Initialize borders
        int rows = dungeon.length;
        int columns = dungeon[0].length;

        // Create dp matrix, where each cell - min amount of health, needed to get to it
        int[][] dp = new int[dungeon.length][dungeon[0].length];

        // Initialize last cell - need to get with 1 health
        dp[rows - 1][columns - 1] = Math.max(1, 1 - dungeon[rows - 1][columns - 1]);

        // Populate last row
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][columns - 1] = Math.max(1, dp[i + 1][columns - 1] - dungeon[i][columns - 1]);
        }

        // Populate last column
        for (int j = columns - 2; j >= 0; j--) {
            dp[rows - 1][j] = Math.max(1, dp[rows - 1][j + 1] - dungeon[rows - 1][j]);
        }

        // Get max current cell value - min (right, bottom)
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                int healthNeeded = Math.min(dp[i][j + 1], dp[i + 1][j]);
                dp[i][j] = Math.max(1, healthNeeded - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}
