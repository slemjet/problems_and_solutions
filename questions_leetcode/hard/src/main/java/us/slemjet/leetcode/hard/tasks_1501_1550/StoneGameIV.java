package us.slemjet.leetcode.hard.tasks_1501_1550;

/**
 * 1510. Stone Game IV
 */
public class StoneGameIV {

    /**
     * DP Top to Bottom
     * <p>
     * Runtime: 15.91%
     * Memory Usage: 21.59%
     */
    public boolean winnerSquareGameTopToBottom(int n) {
        return calculateWinner(n, new Boolean[n + 1]);
    }

    private boolean calculateWinner(int n, Boolean[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = false; // Mark visited
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                // Found combination - player won
                memo[n] = true;
                break;
            } else {
                // Other player turn
                if (!calculateWinner(n - i * i, memo)) {
                    // We need other player to not be able to win with this combination
                    memo[n] = true;
                }
            }
        }
        return memo[n];
    }

    /**
     * Bottom Up Approach
     *
     * Runtime: 66.48%
     * Memory Usage: 57.39%
     */
    public boolean winnerSquareGameBottomUp(int n) {

        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) { // If can win with this move
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
