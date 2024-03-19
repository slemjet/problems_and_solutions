package us.slemjet.leetcode.medium.tasks_251_300;

import java.util.*;

/**
 * 253. Meeting Rooms II
 */
public class MeetingRoomsII {

    /**
     * Time: O(nlogn)   -> 19.22%
     * Space:O(n)       -> 92.29%
     */
    public int minMeetingRooms(int[][] intervals) {

        int result = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> currentMeetings = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] interval : intervals) {
            while (!currentMeetings.isEmpty() && currentMeetings.peek()[1] <= interval[0]) {
                currentMeetings.poll();
            }
            currentMeetings.offer(interval);
            result = Math.max(result, currentMeetings.size());
        }

        return result;
    }
}
