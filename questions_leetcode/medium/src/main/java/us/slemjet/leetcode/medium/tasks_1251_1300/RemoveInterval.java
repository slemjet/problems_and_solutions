package us.slemjet.leetcode.medium.tasks_1251_1300;

import java.util.ArrayList;
import java.util.List;

/**
 * 1272. Remove Interval
 */
public class RemoveInterval {

    /**
     *  Time: O(n)  ->  87.65%
     *  Space:O(n)  ->  71.61%
     */
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        List<List<Integer>> result = new ArrayList<>();

        for (int[] interval : intervals) {

            if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
                // Interval is not overlapping with toBeRemoved -> can add full interval
                result.add(List.of(interval[0], interval[1]));
            } else {
                if (interval[0] < toBeRemoved[0] && interval[1] > toBeRemoved[0]) {
                    // Interval end overlaps with toBeRemoved
                    result.add(List.of(interval[0], toBeRemoved[0]));
                }
                if (interval[0] < toBeRemoved[1] && interval[1] > toBeRemoved[1]) {
                    // Interval start overlaps with toBeRemoved
                    result.add(List.of(toBeRemoved[1], interval[1]));
                }
            }
        }
        return result;
    }
}
