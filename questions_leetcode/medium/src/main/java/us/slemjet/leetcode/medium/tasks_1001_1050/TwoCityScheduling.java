package us.slemjet.leetcode.medium.tasks_1001_1050;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. Two City Scheduling
 */
public class TwoCityScheduling {

    /**
     * Runtime: 21.03%
     * Memory Usage: 20.80%
     */
    public int twoCitySchedCost(int[][] costs) {

        int result = 0;

        // Sort by difference between A and B
        Arrays.sort(costs, Comparator.comparingInt(value -> value[0] - value[1]));

        // Most negative delta -> go to A, most positive -> go to B

        int leftIdx = 0;
        int rightIdx = costs.length - 1;

        while (leftIdx < rightIdx){
            result += costs[leftIdx++][0] + costs[rightIdx--][1];
        }

        return result;
    }
}
