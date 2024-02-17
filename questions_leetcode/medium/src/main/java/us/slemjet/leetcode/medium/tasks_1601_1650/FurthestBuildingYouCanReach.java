package us.slemjet.leetcode.medium.tasks_1601_1650;

import java.util.PriorityQueue;

/**
 * 1642. Furthest Building You Can Reach
 */
public class FurthestBuildingYouCanReach {


    /**
     * Use ladders only first
     * Once all ladders used - use PriorityQueue to track the smallest gap and cover it with minimum ob bricks
     * </p>
     * Time: O(nlogn)   ->  43.55
     * Space:O(n)       ->  92.27%
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        int result = 0;
        PriorityQueue<Integer> gapsSoFar = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {

            if (heights[i] > heights[i - 1]) {
                gapsSoFar.add(heights[i] - heights[i - 1]); // Add current gap

                if (ladders > 0) {
                    // Still has ladders - use ladder first to pass gap
                    ladders--;
                } else {
                    // Try to cover the smallest gap from encountered so far with a ladder
                    Integer smallestGapSoFar = gapsSoFar.poll();
                    if (smallestGapSoFar > bricks) {
                        break; // Cannot proceed
                    }
                    bricks -= smallestGapSoFar; // Use bricks
                }
            }
            result = i; // Reached this building
        }

        return result;
    }
}
