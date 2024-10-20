package us.slemjet.leetcode.medium.tasks_1351_1400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1353. Maximum Number of Events That Can Be Attended
 */
public class MaximumNumberOfEventsThatCanBeAttended {

    /**
     * Time: O(nlogn)   ->  33.66%
     * Space:O(n)       ->  44.55%
     */
    public int maxEvents(int[][] events) {

        int result = 0;
        int[] currentEvent;

        // Sort events by start day, if equal - by end day
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int lastAddedDay = 0;
        int eventIdx = 0;
        int daysCount = events.length;

        while (eventIdx < daysCount || !heap.isEmpty()) {
            // Add all events starting on or before current day to the heap
            while (eventIdx < daysCount && events[eventIdx][0] <= lastAddedDay) {
                heap.offer(events[eventIdx++]);
            }

            // Remove events which end before lastAddedDay as unreachable
            while (!heap.isEmpty() && heap.peek()[1] < lastAddedDay) {
                heap.poll();
            }

            // Attend the event that ends the earliest
            if (!heap.isEmpty()) {
                currentEvent = heap.poll();
                lastAddedDay = Math.max(lastAddedDay, currentEvent[0]) + 1;
                result++;
            } else {
                // If no events in the heap, move to the start of the next event
                if (eventIdx < daysCount) {
                    lastAddedDay = events[eventIdx][0];
                }
            }
        }

        return result;
    }
}
