package us.slemjet.leetcode.hard.tasks_1151_1200;

import java.util.*;

/**
 * 1192. Critical Connections in a Network
 */
public class CriticalConnectionsInANetwork {

    /**
     * Use Tarjan algorithm to find bridges in a graph
     * <p>
     * Runtime: 29.80%
     * Memory Usage: 13.38%
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> result = new ArrayList<>();

        // Migrate graph to node - neighbours format
        Set<Integer>[] graph = new Set[n];

        for (List<Integer> connection : connections) {
            Integer node1 = connection.get(0);
            Integer node2 = connection.get(1);
            if (graph[node1] == null) graph[node1] = new HashSet<>();
            graph[node1].add(node2);

            if (graph[node2] == null) graph[node2] = new HashSet<>();
            graph[node2].add(node1);
        }

        // Contains currently assigned node number
        Integer[] nodeNumber = new Integer[n];
        // Contains the lowest assigned node number, reachable from current node
        Integer[] lowestNode = new Integer[n];
        // Accumulator to assign to newly visited node
        int[] acc = new int[]{0};
        tarjan(0, null, acc, nodeNumber, lowestNode, graph, result);

        return result;
    }

    private void tarjan(int node, Integer parent, int[] acc, Integer[] nodeNumber, Integer[] lowestNode, Set<Integer>[] graph, List<List<Integer>> result) {

        acc[0]++;
        nodeNumber[node] = acc[0];
        lowestNode[node] = acc[0];

        // Process neighbour nodes - for each of them we check whether node is part of strongly connected network or is a bridge - a weak link with 1 connection
        for (int neighbour : graph[node]) {
            if (parent != null && neighbour == parent) continue; // Do not go to parent
            if (lowestNode[neighbour] == null) {
                // Process Neighbour - calculate the lowest node
                tarjan(neighbour, node, acc, nodeNumber, lowestNode, graph, result);
            }

            // Update the lowest reachable from processed neighbour node
            lowestNode[node] = Math.min(lowestNode[node], lowestNode[neighbour]);
            // If current node is out of reach from neighbours
            if (nodeNumber[node] < lowestNode[neighbour]) result.add(List.of(node, neighbour));
        }
    }

    /**
     * Look for any loops within graph and remove them, any remaining connections are critical
     *
     * Runtime: 24.01%
     * Memory Usage: 5.12%
     */
    public List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {

        // Migrate graph to node - neighbours format
        Set<Integer>[] graph = new Set[n];

        for (List<Integer> connection : connections) {
            Integer node1 = connection.get(0);
            Integer node2 = connection.get(1);
            if (graph[node1] == null) graph[node1] = new HashSet<>();
            graph[node1].add(node2);

            if (graph[node2] == null) graph[node2] = new HashSet<>();
            graph[node2].add(node1);
        }

        // We will remove connections with a loop from this set
        Set<List<Integer>> remainingConnections = new HashSet<>(connections);

        int[] rank = new int[n];
        Arrays.fill(rank, -2);

        dfs(graph, 0, 0, rank, remainingConnections);

        return new ArrayList<>(remainingConnections);
    }

    /**
     *
     * @return min depth reachable by this node
     */
    private int dfs(Set<Integer>[] graph, int node, int depth, int[] rank, Set<List<Integer>> remainingConnections) {
        if (rank[node] >= 0) return rank[node]; // Already visited

        rank[node] = depth;
        int minDepth = depth;

        for (int neighbour : graph[node]) {
            if (rank[neighbour] == depth - 1) continue; // Parent -> ignore

            // Do dfs for all neighbours
            int currMinDepth = dfs(graph, neighbour, depth + 1, rank, remainingConnections);

            if (currMinDepth <= depth) {
                // Remove combinations - they are part of a loop
                remainingConnections.remove(List.of(node, neighbour));
                remainingConnections.remove(List.of(neighbour, node));
            }

            minDepth = Math.min(minDepth, currMinDepth);
        }

        return minDepth;
    }
}
