package us.slemjet.leetcode.medium.tasks_201_250;

/**
 * 223. Rectangle Area
 */
public class RectangleArea {

    /**
     * Runtime: than 100.00%
     * Memory Usage: 92.41%
     *
     * Space: O(1)
     * Time: O(1)
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int x1 = Math.max(ax1, bx1);
        int x2 = Math.min(ax2, bx2);
        int y1 = Math.max(ay1, by1);
        int y2 = Math.min(ay2, by2);

        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        if (ax1 > bx2 || ax2 < bx1 || ay1 > by2 || ay2 < by1) {
            // No intersection
            return areaA + areaB;
        }

        int areaIntersection = (x2 - x1) * (y2 - y1);
        return areaA + areaB - areaIntersection;
    }
}
