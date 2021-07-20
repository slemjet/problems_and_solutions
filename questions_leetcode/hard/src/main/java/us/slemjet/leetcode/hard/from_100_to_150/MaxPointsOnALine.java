package us.slemjet.leetcode.hard.from_100_to_150;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    /**
     * Runtime: 21.81%
     * Memory Usage: 43.86%
     */
    public int maxPoints(int[][] points) {

        int max = 0;
        Map<String, Integer> deltas = new HashMap<>();

        for (int[] point1 : points) {
            int localMax = 0;
            int x1 = point1[0];
            int y1 = point1[1];
            int duplicates = 0;
            deltas.clear();
            for (int[] point2 : points) {
                int x2 = point2[0];
                int y2 = point2[1];

                int dx = x2 - x1;
                int dy = y2 - y1;

                if (dx == 0 && dy == 0) {
                    duplicates++;
                } else {
                    // Deltas should be the key
                    // Since division may produce inconsistent result - we store composite key
                    // Use GCD: greatest common divisor to get same key for different coordinate deltas
                    int gcd = gcd(dx, dy);
                    dx = dx / gcd;
                    dy = dy / gcd;

                    String key = dx + ":" + dy;
                    int value = deltas.getOrDefault(key, 0) + 1;
                    deltas.put(key, value);
                    // Store local maximum - for all rays coming from current point
                    localMax = Math.max(localMax, value);
                }
            }
            // Global maximum - local + sum of duplicate points
            max = Math.max(max, localMax + duplicates);
        }

        return max;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
