package us.slemjet.leetcode.hard.tasks_801_850;

import java.util.*;

/**
 * 815. Bus Routes
 */
public class BusRoutes {

    /**
     * Create a map of busses for stops
     * Add first stop to a queue
     * process elements of the queue, looking for target
     * or adding all stops from a route
     * <p>
     * Time: 63.78% -> O(buses*stops)
     * Space: 14.09% -> O (buses*stops)
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target)
            return 0;

        // Structure that will be used to get bus by stop
        Map<Integer, Set<Integer>> busByStop = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int stop : route) {
                busByStop.computeIfAbsent(stop, integer -> new HashSet<>()).add(i);
            }
        }

        Set<Integer> visitedStops = new HashSet<>();
        boolean[] visitedRoutes = new boolean[routes.length];

        Queue<int[]> stops = new LinkedList<>();
        stops.add(new int[]{source, 0}); // [stop, #buses]

        while (!stops.isEmpty()) {

            int[] curr = stops.poll();
            int currStop = curr[0];
            int currNumberOfBuses = curr[1];

            // For each route
            for (int route : busByStop.getOrDefault(currStop, Collections.emptySet())) {
                if (!visitedRoutes[route]) {
                    visitedRoutes[route] = true;
                    // Foe each stop
                    for (int stop : routes[route]) {
                        if (!visitedStops.contains(stop)) {
                            visitedStops.add(stop);
                            // Reached destination
                            if (stop == target) {
                                return currNumberOfBuses + 1;
                            }
                            // Add stop for next loop
                            stops.offer(new int[]{stop, currNumberOfBuses + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
