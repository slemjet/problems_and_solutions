package us.slemjet.leetcode.easy.tasks_1451_1500;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 1496. Path Crossing
 */
public class PathCrossing {

    /**
     * Time: O(n) -> 96.48%
     * Space: O(n) -> 26.43%
     */
    public boolean isPathCrossing(String path) {

        Set<Point> points = new HashSet<>();
        Point currPoint = new Point(0, 0);
        points.add(currPoint);

        for (char direction : path.toCharArray()) {
            currPoint = switch (direction) {
                case 'N' -> new Point(currPoint.x, currPoint.y + 1);
                case 'E' -> new Point(currPoint.x + 1, currPoint.y);
                case 'S' -> new Point(currPoint.x, currPoint.y - 1);
                case 'W' -> new Point(currPoint.x - 1, currPoint.y);
                default -> currPoint;
            };
            if (points.contains(currPoint))
                return true;
            else points.add(currPoint);
        }

        return false;
    }

    static class Point {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private final int x;

        private final int y;
    }
}
