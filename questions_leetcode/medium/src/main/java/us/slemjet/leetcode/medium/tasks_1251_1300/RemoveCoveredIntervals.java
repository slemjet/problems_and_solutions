package us.slemjet.leetcode.medium.tasks_1251_1300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1288. Remove Covered Intervals
 */
public class RemoveCoveredIntervals {

    /**
     * Runtime: 16.77%
     * Memory Usage: 6.00%
     */
    public int removeCoveredIntervalsSort1(int[][] intervals) {

        int result = 0;

        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

        int left = -1, right = 1;

        for (int[] interval : intervals) {
            if (interval[0] > left && interval[1] > right) {
                result++; // New non-overlapping interval
                left = interval[0];
            }
            // Shift right
            right = Math.max(right, interval[1]);
        }

        return result;
    }

    /**
     * Runtime: 10.31%
     * Memory Usage: 14.62%
     */
    public int removeCoveredIntervalsSort2(int[][] intervals) {
        int result = 0;

        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0]).thenComparing(Comparator.comparingInt((int[] interval) -> interval[1]).reversed()));
        int right = -1;
        for (int[] interval : intervals) {
            if (interval[1] > right) {
                result++;
                right = interval[1];
            }
        }

        return result;
    }


    /**
     * Sort + use PrioirityQueue
     * Runtime: 6.00%
     * Memory Usage: 17.23%
     */
    public int removeCoveredIntervalsPriorityQueue(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(value -> value[1]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] value) -> value[0]).reversed());

        for (int[] interval : intervals) {

            while (!queue.isEmpty() && queue.peek()[0] >= interval[0])
                queue.poll(); // Remove previous intervals within current

            if (queue.isEmpty() || queue.peek()[0] >= interval[0] || queue.peek()[1] < interval[1]) // Skip if next is included in previous
                queue.offer(interval);
        }
        return queue.size();
    }
}
