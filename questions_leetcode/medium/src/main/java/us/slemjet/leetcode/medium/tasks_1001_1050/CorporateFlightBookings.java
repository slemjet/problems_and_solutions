package us.slemjet.leetcode.medium.tasks_1001_1050;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1109. Corporate Flight Bookings
 */
public class CorporateFlightBookings {

    /**
     * Runtime: 73.08%
     * Memory Usage: 60.00%
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] result = new int[n];

        // Populate deltas '+' or '-' except last element ending
        for (int[] booking : bookings) {
            result[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                result[booking[1]] -= booking[2]; // Exclude element ending last
            }
        }
        for (int i = 1; i < result.length; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }

    /**
     * Runtime: 21.30%
     * Memory Usage: 89.62%
     */
    public int[] corpFlightBookingsQueues(int[][] bookings, int n) {

        int[] result = new int[n];

        Arrays.sort(bookings, Comparator.comparingInt(value -> value[0]));

        PriorityQueue<int[]> firstOut = new PriorityQueue<>(Comparator.comparingInt((int[] value) -> value[1]));

        int idx = 1;
        int count = 0;

        for (int[] booking : bookings) {

            // Remove all ending before next booking
            while (!firstOut.isEmpty() && firstOut.peek()[1] + 1 < booking[0]) {
                int[] poll = firstOut.poll();
                while (idx <= poll[1]) result[idx++ - 1] = count;
                count -= poll[2];
            }

            while (idx < booking[0]) result[idx++ - 1] = count;

            count += booking[2];
            firstOut.offer(booking);
        }

        while (!firstOut.isEmpty()) {
            int[] poll = firstOut.poll();
            while (idx <= poll[1]) result[idx++ - 1] = count;
            count -= poll[2];
        }

        return result;
    }

    /**
     * Runtime:  10.60%
     * Memory Usage: 40.97%
     * <p>
     * Time: O(n*m)
     * Space: O(n)
     */
    public int[] corpFlightBookingsBrute(int[][] bookings, int n) {

        int[] result = new int[n];

        for (int[] interval : bookings) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                result[i - 1] += interval[2];
            }
        }
        return result;
    }
}
