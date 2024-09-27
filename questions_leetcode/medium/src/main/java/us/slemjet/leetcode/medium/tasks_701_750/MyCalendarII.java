package us.slemjet.leetcode.medium.tasks_701_750;

import java.util.TreeMap;

/**
 * 731. My Calendar II
 *
 * Time: O(logn)    ->  58.20%
 * Space:O(n)       ->  92.88%
 */
public class MyCalendarII {

    TreeMap<Integer, Integer> intervals = new TreeMap<>();

    public boolean book(int start, int end) {

        intervals.put(start, intervals.getOrDefault(start, 0) + 1); // Add event at start of interval
        intervals.put(end, intervals.getOrDefault(end, 0) - 1); // Remove event at end of interval

        int currEvent = 0;
        for (int events : intervals.values()) {
            currEvent += events;

            if (currEvent >= 3) {
                // Cannot add event - revert
                intervals.put(start, intervals.get(start) - 1);
                if (intervals.get(start) == 0) intervals.remove(start);
                intervals.put(end, intervals.get(end) + 1);
                if (intervals.get(end) == 0) intervals.remove(end);
                return false;
            }
        }
        return true;
    }
}
