package us.slemjet.leetcode.medium.tasks_451_500;

import java.util.stream.IntStream;

/**
 * 464. Can I Win
 */
public class CanIWin {

    /**
     * Time: O(n^2)     ->  77.75%
     * Space:O(n)       ->  69.32%
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        boolean canReachSum = IntStream.range(1, maxChoosableInteger + 1).sum() >= desiredTotal;

        return canReachSum && canIWin(maxChoosableInteger, desiredTotal, 0, new Boolean[1 << (maxChoosableInteger + 1)]);
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal, int mask, Boolean[] memo) {

        if (memo[mask] != null) {
            return memo[mask];
        }

        memo[mask] = false;
        for (int i = 1; i <= maxChoosableInteger; i++) {

            boolean numberAvailable = (mask & (1 << i)) == 0;
            if (numberAvailable) {

                if (desiredTotal - i <= 0) {
                    memo[mask] = true; // Won
                } else {

                    int newMask = mask | (1 << i); // Set flag for current number
                    boolean canOpponentWin = canIWin(maxChoosableInteger, desiredTotal - i, newMask, memo);
                    if (!canOpponentWin) {
                        memo[mask] = true; // Opponent loses with this combination
                    }
                }
            }
            if (memo[mask]) {
                break; // Already won - no need to continue
            }
        }
        return memo[mask];
    }
}
