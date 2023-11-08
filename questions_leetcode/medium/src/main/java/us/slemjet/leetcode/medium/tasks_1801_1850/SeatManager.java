package us.slemjet.leetcode.medium.tasks_1801_1850;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 1845. Seat Reservation Manager
 */
public class SeatManager {

    Queue<Integer> seats = new PriorityQueue<>(Comparator.naturalOrder());

    /**
     * Time: O(logn) -> 14.57%
     * Space: O(n) -> 77.71%
     */
    public SeatManager(int n) {
        IntStream.range(1, n + 1).forEach(seats::add);
    }

    public int reserve() {

        if (!seats.isEmpty()) {
            return seats.poll();
        }
        return 0;
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}
