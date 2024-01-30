package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 */
public class NonOverlappingIntervals {

    /**
     * Greedy approach - we always try to pick the interval with min end time
     * if it has start time >= than end time of previous interval
     *
     * Time: O(n)   ->  30.95%
     * Space:O(1)   ->  93.63%
     */
    public int eraseOverlapIntervalsGreedy(int[][] intervals) {

        // Sort by end time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int removedCount = 0;
        int minNextEndTime = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];

            if (startTime >= minNextEndTime) {
                // We pick this interval as it has acceptable start time and min end time (sorted)
                minNextEndTime = endTime;
            } else {
                // We remove this interval - increment removed count
                removedCount++;
            }
        }

        return removedCount;
    }

    /**
     * Top to Bottom - Recursion + Memoization
     * Time:  ->    5.93%
     * Space: ->    16.41%
     */
    public int eraseOverlapIntervalsMemo(int[][] intervals) {

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        return eraseOverlapIntervalsMemo(0, intervals, new Integer[intervals.length]);
    }

    private int eraseOverlapIntervalsMemo(int idx, int[][] intervals, Integer[] memo) {

        if (idx == intervals.length) {
            return 0;
        }
        if (memo[idx] == null) {
            int currentIntervalEnd = intervals[idx][1];
            int pivot = calculatePivot(currentIntervalEnd, idx + 1, intervals);
            int withCurrentInterval = eraseOverlapIntervalsMemo(pivot, intervals, memo) + (pivot - idx - 1);
            int withoutCurrentInterval = eraseOverlapIntervalsMemo(idx + 1, intervals, memo) + 1;
            memo[idx] = Math.min(withoutCurrentInterval, withCurrentInterval);
        }

        return memo[idx];
    }

    /**
     * Bottom Up - Tabulation approach
     * Time:    ->  6.15%
     * Space:   ->  31.71%
     */
    public int eraseOverlapIntervalsTabulation(int[][] intervals) {

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[intervals.length + 1];

        for (int i = intervals.length - 1; i >= 0; i--) {
            int currentIntervalEnd = intervals[i][1];
            int pivot = calculatePivot(currentIntervalEnd, i + 1, intervals);
            int withCurrentInterval = dp[pivot] + (pivot - i - 1);
            int withoutCurrentInterval = dp[i + 1] + 1;
            dp[i] = Math.min(withoutCurrentInterval, withCurrentInterval);
        }

        return dp[0];
    }

    private int calculatePivot(int target, int left, int[][] intervals) {

        int start = left;
        int end = intervals.length - 1;
        int result = intervals.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (intervals[mid][0] < target) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }
}
