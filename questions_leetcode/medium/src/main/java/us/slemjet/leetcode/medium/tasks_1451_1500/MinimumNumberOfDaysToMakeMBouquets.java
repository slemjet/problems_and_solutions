package us.slemjet.leetcode.medium.tasks_1451_1500;

import java.util.stream.IntStream;

/**
 * 1482. Minimum Number of Days to Make m Bouquets
 */
public class MinimumNumberOfDaysToMakeMBouquets {

    /**
     * Use Binary Search on number of days
     * <p>
     * Runtime: 99.73%
     * Memory Usage: 58.24%
     */
    public int minDays(int[] bloomDay, int m, int k) {

        if (m * k > bloomDay.length) return -1; // Impossible to create enough bouquets
        int left = 1;
        int right = IntStream.of(bloomDay).max().orElse(0);

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Calculate current bouquets for days mid
            int flowers = 0, bouquets = 0;
            for (int day : bloomDay) {
                if (day <= mid) {
                    if (++flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
