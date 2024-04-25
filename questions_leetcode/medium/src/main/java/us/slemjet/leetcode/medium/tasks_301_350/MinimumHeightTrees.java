package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.*;

/**
 * 310. Minimum Height Trees
 */
public class MinimumHeightTrees {

    /**
     * Time: O(n)   ->  11.99%
     * Space:O(n)   ->  37.40%
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return List.of(0);
        }

        // Holds connections counts for each node
        int[] connections = new int[n];

        // Holds links between each node
        Map<Integer, Set<Integer>> adjacenyMap = new HashMap<>();

        if (edges.length != 0) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                connections[from]++;
                connections[to]++;
                adjacenyMap.computeIfAbsent(from, (a) -> new HashSet<>()).add(to);
                adjacenyMap.computeIfAbsent(to, (a) -> new HashSet<>()).add(from);
            }
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (connections[i] == 1) {
                // Add all initial leaves
                leaves.add(i);
            }
        }

        int nodes = n;
        while (nodes > 2) {

            int size = leaves.size();
            nodes -= size;

            for (int i = 0; i < size; i++) {
                Integer leaf = leaves.poll();

                for (int otherNode : adjacenyMap.get(leaf)) {
                    connections[otherNode]--;

                    if (connections[otherNode] == 1) {
                        // Node becomes a leaf
                        leaves.add(otherNode);
                    }
                }
            }
        }

        return new ArrayList<>(leaves);
    }
}
