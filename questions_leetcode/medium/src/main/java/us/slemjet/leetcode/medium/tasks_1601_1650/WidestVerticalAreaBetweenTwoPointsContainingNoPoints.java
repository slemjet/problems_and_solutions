package us.slemjet.leetcode.medium.tasks_1601_1650;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1637. Widest Vertical Area Between Two Points Containing No Points
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    /**
     * Time: O(nlogn) -> 9.23%
     * Space: O(1) -> 5.00%
     */
    public int maxWidthOfVerticalArea(int[][] points) {

        int result = 0;

        Arrays.sort(points, Comparator.comparingInt((int[] value) -> value[0]));

        for (int i = 1; i < points.length; i++) {
            result = Math.max(result, points[i][0] - points[i - 1][0]);
        }

        return result;
    }
}
