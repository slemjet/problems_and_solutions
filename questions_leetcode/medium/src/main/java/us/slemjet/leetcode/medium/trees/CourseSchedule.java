package us.slemjet.leetcode.medium.trees;

import java.util.*;

public class CourseSchedule {

    /**
     * Runtime: 50.43%
     * Memory Usage: 25.06%
     * Kahn algorithm
     */
    public boolean canFinishKahn(int numCourses, int[][] prerequisites) {

        List<Integer> topology = new ArrayList<>();

        int[] inLinks = new int[numCourses];
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        Queue<Integer> nodes = new ArrayDeque<>();

        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]);
            inLinks[pair[1]]++;
        }

        for (int i = 0; i < inLinks.length; i++) {
            if (inLinks[i] == 0) {
                nodes.offer(i);
            }
        }

        while (!nodes.isEmpty()) {
            Integer node = nodes.poll();
            topology.add(node);

            graph[node].forEach(childNode -> {
                --inLinks[childNode];
                if (inLinks[childNode] == 0) {
                    nodes.offer(childNode);
                }
            });
        }

        return topology.size() == numCourses;
    }

    /**
     * Runtime: 54.79%
     * Memory 12.18%
     * BFS algorithm
     */
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]);
        }

        // Cache the done nodes
        boolean[] done = new boolean[numCourses];
        // Store visited
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycleDfs(graph, done, visited, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycleDfs(List<Integer>[] graph, boolean[] done, boolean[] visited, int i) {
        if (visited[i]) // already visited - cycle
            return true;

        if (done[i]) // already completed
            return false;

        visited[i] = true; // mark visited

        for (int j = 0; j < graph[i].size(); j++) {
            if (hasCycleDfs(graph, done, visited, graph[i].get(j)))
                return true;
        }

        visited[i] = false; // unmark visited as it is completed now
        done[i] = true; // node is completely processed

        return false;
    }
}
