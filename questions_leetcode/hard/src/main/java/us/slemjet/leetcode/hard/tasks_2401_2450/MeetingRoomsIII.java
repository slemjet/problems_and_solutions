package us.slemjet.leetcode.hard.tasks_2401_2450;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2402. Meeting Rooms III
 */
public class MeetingRoomsIII {

    /**
     * Time: O(nlogn)   ->  45.53%
     * Space:O(n)       ->  9.24%
     */
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(value -> value[0]));

        // long[room, meetings, end]
        Queue<long[]> occupiedRooms = new PriorityQueue<>(
                (o1, o2) -> o1[2] == o2[2] ? Long.compare(o1[0], o2[0]) : Long.compare(o1[2], o2[2]));
        Queue<long[]> freeRooms = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));

        for (int i = 0; i < n; i++) {
            freeRooms.offer(new long[]{i, 0, -1});
        }

        for (int[] meeting : meetings) {

            // Reallocate occupied rooms to free rooms
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[2] <= meeting[0]) {
                // Room is free for current meeting
                freeRooms.add(occupiedRooms.poll());
            }

            // Get next available room
            long[] nextAvailableMeetingRoom;

            if (!freeRooms.isEmpty()) {
                // Try to find free room
                nextAvailableMeetingRoom = freeRooms.poll();
            } else {
                // Or use occupied room that frees next
                nextAvailableMeetingRoom = occupiedRooms.poll();
            }

            nextAvailableMeetingRoom[1]++;
            long nextMeetingStart = Math.max(nextAvailableMeetingRoom[2], meeting[0]);
            long nextMeetingDuration = meeting[1] - meeting[0];
            nextAvailableMeetingRoom[2] = nextMeetingStart + nextMeetingDuration;
            occupiedRooms.offer(nextAvailableMeetingRoom);
        }

        while (!occupiedRooms.isEmpty()) {
            freeRooms.offer(occupiedRooms.poll());
        }

        return Math.toIntExact(freeRooms.stream()
                .max((o1, o2) -> o1[1] == o2[1] ? Long.compare(o2[0], o1[0]) : Long.compare(o1[1], o2[1]))
                .map(meetingRoom -> meetingRoom[0])
                .orElse(-1L));
    }
}
