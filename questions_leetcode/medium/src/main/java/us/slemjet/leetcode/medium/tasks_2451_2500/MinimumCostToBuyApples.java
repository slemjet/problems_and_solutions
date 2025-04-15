package us.slemjet.leetcode.medium.tasks_2451_2500;

import java.util.*;

/**
 * 2473. Minimum Cost to Buy Apples
 */
public class MinimumCostToBuyApples {

    /**
     * Time:    O(n^2 * log(n)) -> Due to running Dijkstra's algorithm from each node.
     * Space:   O(n^2) -> Space for adjacency list representation of graph (nodes map) and distances array.
     */
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {

        long[] costs = new long[n];

        Map<Integer, Collection<Integer[]>> nodes = new HashMap<>();

        for (int[] road : roads) {
            int a = road[0] - 1;
            int b = road[1] - 1;
            int cost = road[2];
            nodes.putIfAbsent(a, new ArrayList<>());
            nodes.putIfAbsent(b, new ArrayList<>());
            nodes.get(a).add(new Integer[]{b, cost});
            nodes.get(b).add(new Integer[]{a, cost});
        }

        // Do Dijkstra for each node
        for (int startNode = 0; startNode < n; startNode++) {

            long[] distances = getMinDistances(n, startNode, nodes);

            long minCost = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (distances[i] == Long.MAX_VALUE) {
                    continue;
                }
                long cost = distances[i] * (1 + k) + appleCost[i];
                minCost = Math.min(minCost, cost);
            }
            costs[startNode] = minCost;
        }

        return costs;
    }

    /**
     * Use Dijkstra algo to calculate min distances
     */
    private static long[] getMinDistances(int n, int startNode, Map<Integer, Collection<Integer[]>> nodes) {
        long[] distances = new long[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[startNode] = 0;
        pq.add(new int[]{startNode, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currDistance = current[1];

            if (currDistance > distances[currNode]) continue;

            for (Integer[] neighbor : nodes.getOrDefault(currNode, Collections.emptyList())) {
                int nextNode = neighbor[0];
                int newDist = currDistance + neighbor[1];

                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }
        return distances;
    }
}
