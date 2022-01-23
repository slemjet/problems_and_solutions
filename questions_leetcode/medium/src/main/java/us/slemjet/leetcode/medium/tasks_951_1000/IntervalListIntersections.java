package us.slemjet.leetcode.medium.tasks_951_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
 */
public class IntervalListIntersections {

    /**
     * Runtime: 7 ms, faster than 21.07%
     * Memory Usage: 52.4 MB, less than 29.27%
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> result = new ArrayList<>();

        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < A.length && bIdx < B.length) {

            int start = Math.max(A[aIdx][0], B[bIdx][0]); // get possible start of interval
            int end = Math.min(A[aIdx][1], B[bIdx][1]); // get possible end of interval

            if (start <= end)
                result.add(new int[]{start, end}); // pair is correct - add it

            if (A[aIdx][1] < B[bIdx][1])
                aIdx++; // A pair is less - skip to next A pair
            else
                bIdx++; // B pair is less - skip to next B pir
        }

        return result.toArray(new int[0][]);
    }
}
