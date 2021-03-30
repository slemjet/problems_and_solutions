package us.slemjet.leetcode.medium.from_50_to_100;

import java.util.*;
import java.util.stream.Stream;

public class MergeIntervals {

    /**
     * Runtime: 65.35%
     * Memory Usage: 32.54%
     */
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        if (intervals == null || intervals.length == 0)
            return result.toArray(new int[0][]);

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] nextInterval : intervals) {
            if (nextInterval[0] <= currentInterval[1]) {
                // new interval within current - take max right index of two
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // new interval outside current - add to result and switch to next
                currentInterval = nextInterval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[0][]);
    }

    /**
     * Runtime: 8.15%
     * Memory Usage: 5.05%
     */
    public int[][] merge2(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return result.toArray(new int[0][]);

        List<Integer> startIndices = new ArrayList<>();
        List<Integer> endIndices = new ArrayList<>();

        Stream.of(intervals).forEach(interval -> {
            startIndices.add(interval[0]);
            endIndices.add(interval[1]);
        });

        Collections.sort(startIndices);
        Collections.sort(endIndices);

        Iterator<Integer> startIterator = startIndices.iterator();
        Iterator<Integer> endIterator = endIndices.iterator();

        int currStart = startIterator.next();
        int currEnd = endIterator.next();

        while (startIterator.hasNext()) {

            Integer nextStart = startIterator.next();
            Integer nextEnd = endIterator.next();

            if (nextStart > currEnd) {
                // End of current interval
                result.add(new int[]{currStart, currEnd});
                currStart = nextStart;
            }
            currEnd = nextEnd;

        }

        result.add(new int[]{currStart, currEnd});

        return result.toArray(new int[0][]);
    }
}
