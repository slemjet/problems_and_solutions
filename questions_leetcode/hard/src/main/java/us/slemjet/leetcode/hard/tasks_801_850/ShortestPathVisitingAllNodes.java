package us.slemjet.leetcode.hard.tasks_801_850;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 847. Shortest Path Visiting All Nodes
 */
public class ShortestPathVisitingAllNodes {

    /**
     * Runtime: 88.97%
     * Memory Usage: 43.57%
     */
    public int shortestPathLength(int[][] graph) {

        int result = Integer.MAX_VALUE;

        // Length of path int[from][mask]
        int[][] path = new int[graph.length][1 << graph.length];
        Queue<PathNode> queue = new LinkedList<>();

        // Populate initial state
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE); // Pre-populate with max value to decrease it later
            path[i][1 << i] = 0;
            queue.offer(new PathNode(1 << i, i));
        }

        while (!queue.isEmpty()) {
            PathNode nextState = queue.poll();

            for (int nextNode : graph[nextState.source]) {
                int nextMask = nextState.mask | 1 << nextNode;

                // Update path if is shortest
                if (path[nextNode][nextMask] > 1 + path[nextState.source][nextState.mask]) {
                    path[nextNode][nextMask] = 1 + path[nextState.source][nextState.mask];
                    queue.offer(new PathNode(nextMask, nextNode));
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            result = Math.min(result, path[i][(1 << graph.length) - 1]); // Take the shortest starting from each node
        }

        return result;
    }

    static class PathNode {
        int mask;
        int source;

        public PathNode(int mask, int sourceNode) {
            this.mask = mask;
            this.source = sourceNode;
        }
    }

    /**
     *
     */
    public int shortestPathLength2(int[][] graph) {

        int result;

        int target = 0;
        for (int i = 0; i < graph.length; i++) {
            target = target | 1 << i;
        }

        result = bfs(graph, 0, 0, target, 0);

        return result;
    }

    private int bfs(int[][] graph, int node, int curr, int target, int count) {
        if (curr == target) return count;

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < graph[node].length; i++) {
            int currNode = graph[node][i];
            int currTarget = curr | 1 << currNode;
            int currCount = bfs(graph, node, currTarget, target, count + 1);
            minCount = Math.min(minCount, currCount);
        }
        return minCount;
    }
}
