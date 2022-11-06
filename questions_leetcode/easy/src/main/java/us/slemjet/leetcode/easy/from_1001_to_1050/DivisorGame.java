package us.slemjet.leetcode.easy.from_1001_to_1050;

/**
 * 1025. Divisor Game
 */
public class DivisorGame {

    /**
     * Runtime: 23.31%
     * Memory Usage: 62.55%
     */
    public boolean divisorGame(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return helper(n, true, memo);
    }

    private boolean helper(int n, boolean turn, Boolean[] memo) {

        // No turns - loose
        if (n < 2) return !turn;

        // Get from cache
        if (memo[n] != null) return memo[n];

        boolean result = false;
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0 && helper(n - i, !turn, memo)) // If there is a winning combination
                return memo[n] = true;
        }
        return memo[n] = false;
    }
}
