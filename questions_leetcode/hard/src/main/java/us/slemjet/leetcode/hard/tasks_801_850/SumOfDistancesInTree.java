package us.slemjet.leetcode.hard.tasks_801_850;

import java.util.*;

/**
 * 834. Sum of Distances in Tree
 *
 */
public class SumOfDistancesInTree {

    /**
     * TODO: Understand this
     * Time: O(n)   ->  6.68%
     * Space:O(n)   ->  6.90%
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        int[] result = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        if (edges.length != 0) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                graph.computeIfAbsent(from, (a) -> new HashSet<>()).add(to);
                graph.computeIfAbsent(to, (a) -> new HashSet<>()).add(from);
            }
        } else {
            graph.put(0, new HashSet<>());
        }

        // First - calculate for on node (0)
        dfs(0, -1, count, graph, result);
        // Calculate for other nodes using tree re-rooting DP
        rerouteDfs(0, -1, count, graph, result);

        return result;
    }

    private void dfs(int node, int parent, int[] count, Map<Integer, Set<Integer>> graph, int[] result) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node, count, graph, result);
                count[node] += count[child];
                result[node] += result[child] + count[child];
            }
        }
    }

    private void rerouteDfs(int node, int parent, int[] count, Map<Integer, Set<Integer>> graph, int[] result) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                result[child] = result[node] - count[child] + count.length - count[child];
                rerouteDfs(child, node, count, graph, result);
            }
        }
    }
}
