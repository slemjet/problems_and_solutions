package us.slemjet.leetcode.hard.tasks_401_450;

import java.util.Arrays;

/**
 * 403. Frog Jump
 */
public class FrogJump {

    /**
     * Top to bottom DP
     * Time:   ->  89.96%
     * Space:  ->  10.40%
     */
    public boolean canCross(int[] stones) {

        return canCross(stones, 0, 0, new Boolean[stones.length][stones.length]);
    }

    private boolean canCross(int[] stones, int idx, int k, Boolean[][] memo) {

        if (idx == stones.length - 1) {
            // Reached end
            return true;
        }

        if (memo[idx][k] != null) {
            return memo[idx][k];
        }

        // There are 3 options to change next jump length
        for (int i = -1; i < 2; i++) {

            int nextJump = k + i;
            if (nextJump <= 0) {
                continue;
            }
            int nextStone = stones[idx] + nextJump;

            // Check if there is a stone that can be reached with this jump
            int nextIdx = Arrays.binarySearch(stones, idx + 1, stones.length, nextStone);
            if (nextIdx >= 0 && canCross(stones, nextIdx, nextJump, memo)) {
                // Shortcut to result
                return true;
            }
        }

        return memo[idx][k] = false;
    }
}
