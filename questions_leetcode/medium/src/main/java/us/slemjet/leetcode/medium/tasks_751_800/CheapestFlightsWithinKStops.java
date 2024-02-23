package us.slemjet.leetcode.medium.tasks_751_800;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 */
public class CheapestFlightsWithinKStops {

    /**
     * Use Queue
     * Time: O(n + k*e)    ->  19.16%
     * Space:O(n + k*e)    ->  52.73%
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<List<Integer>>> outboundFlights = new HashMap<>();

        for (int[] flight : flights) {
            List<List<Integer>> outFlights = outboundFlights.getOrDefault(flight[0], new ArrayList<>());
            outFlights.add(List.of(flight[1], flight[2], 0));
            outboundFlights.put(flight[0], outFlights);
        }

        int[] minSums = new int[n];
        Arrays.fill(minSums, Integer.MAX_VALUE);

        int minSum = Integer.MAX_VALUE;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(src, 0));

        for (int i = 0; i <= k; i++) {
            int size = queue.size(); // Each level is a stop that decreases k by one
            for (int j = 0; j < size; j++) {
                List<Integer> flight = queue.poll();
                Integer nextSrc = flight.get(0);
                if (!outboundFlights.containsKey(nextSrc)) {
                    continue; // No outbound flights
                }
                List<List<Integer>> nextFlights = outboundFlights.get(nextSrc);
                for (List<Integer> nextFlight : nextFlights) {
                    Integer nextDest = nextFlight.get(0);
                    int totalSum = flight.get(1) + nextFlight.get(1);
                    if (totalSum >= minSums[nextDest]) {
                        continue; // Longer than the previous one - skip
                    }
                    minSums[nextDest] = totalSum;
                    List<Integer> flightToAdd = List.of(nextDest, totalSum);
                    if (flightToAdd.get(0) == dst) {
                        minSum = Math.min(minSum, flightToAdd.get(1)); // Potential solution
                    } else {
                        queue.offer(flightToAdd); // Keep searching
                    }
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }


}
