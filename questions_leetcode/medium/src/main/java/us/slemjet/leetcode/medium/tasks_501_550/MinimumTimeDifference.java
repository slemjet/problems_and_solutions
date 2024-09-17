package us.slemjet.leetcode.medium.tasks_501_550;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 539. Minimum Time Difference
 */
public class MinimumTimeDifference {

    /**
     * Runtime:         O(n) -> 90%
     * Memory Usage:    O(1) -> 80.2%
     */
    public int findMinDifferenceBucket(List<String> timePoints) {

        boolean[] buckets = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int minutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            if (buckets[minutes]) {
                return 0; // If the time point is repeated, the minimum difference is 0
            }
            buckets[minutes] = true;
        }

        int firstTime = -1, prevTime = -1, minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i]) {
                if (firstTime == -1) {
                    firstTime = i;
                } else {
                    minDifference = Math.min(minDifference, i - prevTime);
                }
                prevTime = i;
            }
        }

        // Compare the difference between the last and the first time point across midnight
        minDifference = Math.min(minDifference, firstTime + 24 * 60 - prevTime);

        return minDifference;

    }

    /**
     * Runtime:         O(nlgn) -> 9.17%
     * Memory Usage:    O(n)    -> 6.41%
     */
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timePointsInMinutes = convertTimePointsToMinutes(timePoints);

        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < timePointsInMinutes.size(); i++) {
            minDifference = Math.min(minDifference, timePointsInMinutes.get(i) - timePointsInMinutes.get(i - 1));
        }

        return minDifference;
    }

    private List<Integer> convertTimePointsToMinutes(List<String> timePoints) {

        List<Integer> timePointsInMinutes = new ArrayList<>();

        for (String tp : timePoints) {
            int minutesInTimePoints = 60 * Integer.parseInt(tp.substring(0, 2)) + Integer.parseInt(tp.substring(3, 5));
            timePointsInMinutes.add(minutesInTimePoints);

            // Add 24+ time point
            int minutesInTimePoints24 = 24 * 60 + minutesInTimePoints;
            timePointsInMinutes.add(minutesInTimePoints24);

        }

        return timePointsInMinutes.stream().sorted().collect(Collectors.toList());
    }
}
