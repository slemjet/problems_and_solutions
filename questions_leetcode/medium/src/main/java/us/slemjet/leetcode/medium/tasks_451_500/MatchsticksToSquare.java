package us.slemjet.leetcode.medium.tasks_451_500;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 473. Matchsticks to Square
 */
public class MatchsticksToSquare {

    /**
     * Time: O(4^n) ->  34.32%
     * Space: O(n)  ->  10.58%
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = IntStream.of(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
            // Cannot form square
        }

        int targetLength = sum / 4;
        int[] sides = new int[4];

        // Sort for optimization to fail fast
        matchsticks = IntStream.of(matchsticks).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        return makesquare2(sides, 0, matchsticks, targetLength);
    }

    private boolean makesquare2(int[] sides, int idx, int[] matchsticks, int side) {

        if (sides[0] > side || sides[1] > side || sides[2] > side || sides[3] > side) {
            return false;
        }

        if (idx == matchsticks.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + matchsticks[idx] <= side) {
                // Attempt combination and backtrack if failed
                sides[i] += matchsticks[idx];
                if (makesquare2(sides, idx + 1, matchsticks, side)) {
                    return true;
                }
                sides[i] -= matchsticks[idx];
            }
        }

        return false;
    }
}
