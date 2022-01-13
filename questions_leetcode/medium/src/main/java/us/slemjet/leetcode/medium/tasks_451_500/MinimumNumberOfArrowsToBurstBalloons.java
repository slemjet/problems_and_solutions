package us.slemjet.leetcode.medium.tasks_451_500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * Runtime: 51.56%
     * Memory Usage: 95.98%
     */
    public int findMinArrowShots(int[][] points) {
        int result = 1;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int nextEndIdx = Integer.MAX_VALUE;

        for (int[] point : points) {
            if (nextEndIdx < point[0]) {
                result++;
                nextEndIdx = point[1];
            } else {
                nextEndIdx = Math.min(nextEndIdx, point[1]);
            }
        }

        return result;
    }

    /**
     * Use Priority Queue
     * <p>
     * Runtime: 5.07%
     * Memory Usage: 10.33%
     */
    public int findMinArrowShots2(int[][] points) {
        int result = 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int[] point : points) {
            int[] peek = queue.peek();
            if (!queue.isEmpty() && peek[1] < point[0]) {
                // Found gap - calculate
                result++;
                queue.clear();
            }
            queue.offer(point);
        }
        if (!queue.isEmpty()) result++; // Clear remaining points

        return result;
    }
}
