package us.slemjet.leetcode.medium.tasks_701_750;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 729. My Calendar I
 */
public class MyCalendarI {

    List<int[]> intervals = new ArrayList<>();

    /**
     * Runtime: 26.90%
     * Memory Usage: 35.87%
     */
    public boolean book(int start, int end) {

        for (int[] interval : intervals) {
            if (Math.max(interval[0], start) < Math.min(interval[1], end)) return false; // -> Overlaps
        }
        intervals.add(new int[]{start, end});
        return true;
    }

}

class MyCalendarITreeMap {

    TreeMap<Integer, Integer> intervals = new TreeMap<>();

    /**
     * Use sorted collection (TreeMap)
     * Get the closest interval to current end
     * CHeck if it ends before current starts
     *
     * Runtime: 97.06%
     * Memory Usage: 94.90%
     */
    public boolean book(int start, int end) {

        Integer lowestStartingNearEndIndex = intervals.lowerKey(end);

        if (lowestStartingNearEndIndex != null) {
            Integer lowestEndingNearEndIndex = intervals.get(lowestStartingNearEndIndex);
            if (start < lowestEndingNearEndIndex) {
                //         |----------------------|
                //        start                  end
                //    |---------------|
                // lowestStarting   lowestEnding
                return false;
            }
        }
        intervals.put(start, end);
        return true;
    }
}
