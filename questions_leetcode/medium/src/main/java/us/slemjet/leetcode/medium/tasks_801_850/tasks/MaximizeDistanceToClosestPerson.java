package us.slemjet.leetcode.medium.tasks_801_850.tasks;

/**
 * 849. Maximize Distance to Closest Person
 */
public class MaximizeDistanceToClosestPerson {

    /**
     *
     * Runtime: 41.81%
     * Memory Usage: 24.83%
     */
    public int maxDistToClosest(int[] seats) {

        int result = 0;
        int oneIdx = -1;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (oneIdx == -1) {
                    result = i; // First seat (no neighbours to the left)
                } else {
                    result = Math.max(result, (i - oneIdx) / 2);
                }
                oneIdx = i;
            }
        }

        result = Math.max(result, seats.length - 1 - oneIdx); // Last seat (no more neighbours to the right)
        return result;
    }
}
