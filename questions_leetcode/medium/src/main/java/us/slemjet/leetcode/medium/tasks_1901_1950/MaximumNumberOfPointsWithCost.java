package us.slemjet.leetcode.medium.tasks_1901_1950;

import java.util.stream.LongStream;

/**
 * 1937. Maximum Number of Points with Cost
 */
public class MaximumNumberOfPointsWithCost {

    /**
     * <p>
     * Time:    O(n^2)  ->  54.75%
     * Space:   O(n)    ->  60.89%
     */
    public long maxPoints(int[][] points) {

        long result;

        long[] prevRow = new long[points[0].length];

        for (int i = 0; i < points.length; i++) { // Rows

            long[] currRow = new long[points[i].length];

            long currMax = 0;

            // Go from left to right and than from right to left and find max value to pick from interval
            for (int j = 0; j < currRow.length; j++) {
                currMax = Math.max(currMax - 1, prevRow[j]);
                currRow[j] = currMax;
            }

            currMax = 0;
            for (int j = currRow.length - 1; j >= 0; j--) {
                currMax = Math.max(currMax - 1, prevRow[j]);
                currRow[j] = points[i][j] + Math.max(currMax, currRow[j]);
            }

            prevRow = currRow;
        }

        result = LongStream.of(prevRow).max().orElse(-1L);
        return result;
    }

}
