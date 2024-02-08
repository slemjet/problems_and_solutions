package us.slemjet.leetcode.easy.tasks_1251_1300;

/**
 * 1266. Minimum Time Visiting All Points
 */
public class MinimumTimeVisitingAllPoints {

    /**
     * Time: O(n) -> 86.94%
     * Space: O(1) -> 28.60%
     */
    public int minTimeToVisitAllPoints(int[][] points) {

        int result = 0;

        for (int i = 1; i < points.length; i++) {
            int[] prev = points[i - 1];
            int[] curr = points[i];

            int deltaDiag = Math.min(Math.abs(curr[0] - prev[0]), Math.abs(curr[1] - prev[1]));
            int deltaX = Math.abs(curr[0] - prev[0]) - deltaDiag;
            int deltaY = Math.abs(curr[1] - prev[1]) - deltaDiag;

            result += deltaDiag + deltaX + deltaY;
        }

        return result;
    }
}
