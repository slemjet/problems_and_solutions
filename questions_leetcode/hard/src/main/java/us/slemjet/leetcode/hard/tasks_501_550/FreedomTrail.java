package us.slemjet.leetcode.hard.tasks_501_550;

/**
 * 514. Freedom Trail
 */
public class FreedomTrail {

    /**
     * Time: O(n*m) ->  26.21%
     * Space:O(n*m) ->  38.35%
     */
    public int findRotateSteps(String ring, String key) {

        Integer[][][] memo = new Integer[ring.length()][key.length()][2];

        // Need to check both directions
        return Math.min(
                findRotateSteps(ring.toCharArray(), 0, key.toCharArray(), 0, 1, memo),
                findRotateSteps(ring.toCharArray(), 0, key.toCharArray(), 0, 0, memo)
        );
    }

    private int findRotateSteps(char[] ring, int rIdx, char[] key, int kIdx, int direction, Integer[][][] memo) {

        if (kIdx >= key.length) {
            return 0;
        }

        if (memo[rIdx][kIdx][direction] == null) {

            int minSteps = Integer.MAX_VALUE;

            int count = 0;

            while (count < ring.length) {

                if (ring[rIdx] == key[kIdx]) {
                    // Can use this combination
                    int rotateStepsSameDir = findRotateSteps(ring, rIdx, key, kIdx + 1, direction, memo);
                    int rotateStepsOppoDir = findRotateSteps(ring, rIdx, key, kIdx + 1, direction == 1 ? 0 : 1, memo);
                    int currSteps = 1 + count + Math.min(rotateStepsSameDir, rotateStepsOppoDir);
                    minSteps = Math.min(minSteps, currSteps);
                }

                // Keep rolling
                rIdx = rIdx + (direction == 1 ? 1 : -1);
                if (rIdx >= ring.length) {
                    rIdx = 0;
                }
                if (rIdx < 0) {
                    rIdx = ring.length - 1;
                }
                count++;
            }

            memo[rIdx][kIdx][direction] = minSteps;
        }
        return memo[rIdx][kIdx][direction];
    }
}
