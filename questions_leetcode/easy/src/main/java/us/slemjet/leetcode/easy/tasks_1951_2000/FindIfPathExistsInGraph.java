package us.slemjet.leetcode.easy.tasks_1951_2000;

import us.slemjet.leetcode.common.UnionFind;

import java.util.*;

/**
 * 1971. Find if Path Exists in Graph
 */
public class FindIfPathExistsInGraph {


    /**
     * Union Find
     * <p>
     * Time: O(n)   ->  93.51%
     * Space:O(n)   ->  90.57%
     */
    public boolean validPathUnion(int n, int[][] edges, int source, int destination) {

        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            unionFind.unite(edge[0], edge[1]);
        }

        return unionFind.isConnected(source, destination);
    }

    /**
     * Map + BFS -> TLE
     * <p>
     * Time: O(n + m)
     * Space:O(n + m)
     */
    public boolean validPathBfs(int n, int[][] edges, int source, int destination) {

        // Create a map with all the vertices
        Map<Integer, Set<Integer>> vertices = new HashMap<>();
        for (int[] edge : edges) {
            vertices.computeIfAbsent(edge[0], (a) -> new HashSet<>()).add(edge[1]);
            vertices.computeIfAbsent(edge[1], (a) -> new HashSet<>()).add(edge[0]);
        }

        // BFS to find connection
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            Integer polled = queue.poll();
            visited[polled] = true;

            if (polled == destination) {
                return true;
            }

            if (!vertices.containsKey(polled)) {
                continue;
            }
            Set<Integer> candidates = vertices.get(polled);
            for (int candidate : candidates) {
                if (!visited[candidate]) {
                    queue.add(candidate);
                }
            }
        }

        return false;
    }

    /**
     * Map + DFS
     * <p>
     * Time: O(n + m)   ->  5.01%
     * Space:O(n + m)   ->  5.10%
     */
    public boolean validPathDfs(int n, int[][] edges, int source, int destination) {

        // Create a map with all the vertices
        Map<Integer, Set<Integer>> vertices = new HashMap<>();
        for (int[] edge : edges) {
            vertices.computeIfAbsent(edge[0], (a) -> new HashSet<>()).add(edge[1]);
            vertices.computeIfAbsent(edge[1], (a) -> new HashSet<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // DFS to find connection
        return validPath(vertices, visited, source, destination);
    }

    private boolean validPath(Map<Integer, Set<Integer>> vertices, boolean[] visited, int source, int destination) {

        if (source == destination) {
            return true;
        }

        if (!visited[source]) {
            visited[source] = true;
            for (int node : vertices.get(source)) {
                if (validPath(vertices, visited, node, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
