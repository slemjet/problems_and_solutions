package us.slemjet.leetcode.medium.tasks_1901_1950;

import java.util.Arrays;

/**
 * 1921. Eliminate Maximum Number of Monsters
 */
public class EliminateMaximumNumberOfMonsters {

    /**
     * Calculate arrival time amd sort
     *
     * Time: O(nlogn) -> Beats 82.29%
     * Space: O(n) -> Beats 85.44%
     */
    public int eliminateMaximum(int[] dist, int[] speed) {

        // Calculate the moves required for each monster
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] + speed[i] - 1) / speed[i];
        }

        // Sort monsters based on the number of moves required
        Arrays.sort(arrivalTimes);

        // Initialize the count of eliminated monsters
        int eliminatedCount = 0;

        // Iterate through the sorted moves
        for (int i = 0; i < n; i++) {
            // If the current monster arrives before or at the same time you eliminate the previous one,
            // eliminate this monster as well
            if (i >= arrivalTimes[i]) {
                break;
            } else {
                eliminatedCount++;
            }
        }

        return eliminatedCount;
    }
}
