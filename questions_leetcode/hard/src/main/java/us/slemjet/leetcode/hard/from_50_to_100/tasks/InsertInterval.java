package us.slemjet.leetcode.hard.from_50_to_100.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {

    /**
     * Time: O(n) -> 48.50%
     * Space: O(1) -> 18.64%
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> mergedIntervals = new ArrayList<>();

        int idx = 0;
        // 1. Add all before newInterval
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            mergedIntervals.add(intervals[idx]);
            idx++;
        }

        // 2. Merge overlapping intervals
        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            // Update newInterval inline
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        // Add merge interval
        mergedIntervals.add(newInterval);

        // 3. Add all intervals after newInterval
        while (idx < intervals.length) {
            mergedIntervals.add(intervals[idx]);
            idx++;
        }

        return mergedIntervals.toArray(int[][]::new);
    }

    /**
     * Time: O(n) -> 48.50%
     * Space: O(1) -> 18.64%
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {

        List<int[]> mergedIntervals = new ArrayList<>();

        int idx = 0;
        boolean isMerged = false;

        while (idx < intervals.length) {
            int[] currInterval = intervals[idx];

            if (currInterval[0] > newInterval[1] && (idx == 0 || intervals[idx - 1][1] < newInterval[0])) {
                mergedIntervals.add(newInterval);
                isMerged = true;
            }
            if (currInterval[1] < newInterval[0] || currInterval[0] > newInterval[1]) {
                // just add
                mergedIntervals.add(currInterval);
            } else {
                // merge
                int start = Math.min(currInterval[0], newInterval[0]);
                int end = Math.max(currInterval[1], newInterval[1]);

                while (idx + 1 < intervals.length && intervals[idx + 1][0] <= newInterval[1]) {
                    idx++;
                    end = Math.max(intervals[idx][1], newInterval[1]);
                }
                mergedIntervals.add(new int[]{start, end});
                isMerged = true;
            }
            idx++;
        }

        if (!isMerged) {
            mergedIntervals.add(newInterval);
        }

        return mergedIntervals.toArray(int[][]::new);
    }
}
