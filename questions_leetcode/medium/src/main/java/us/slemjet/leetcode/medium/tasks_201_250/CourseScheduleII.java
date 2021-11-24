package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.*;

/**
 * 210. Course Schedule II
 */
public class CourseScheduleII {

    /**
     * Use DFS
     * Runtime: 32.63%
     * Memory Usage: 30.46%
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> nodes = new ArrayList<>();
        Status[] flags = new Status[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[0], value -> new LinkedList<>()).add(pair[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, nodes, flags, graph)) return new int[0];
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        return result;
    }

    private boolean dfs(int node, List<Integer> nodes, Status[] flags, Map<Integer, List<Integer>> graph) {

        if (flags[node] == Status.CURRENT) return false; // Cycle
        if (flags[node] == Status.DONE) return true; // End

        flags[node] = Status.CURRENT; // Start processing

        List<Integer> dependencies = graph.get(node);
        if (dependencies != null) {
            boolean hasCycle = dependencies.stream().anyMatch(dependency -> !dfs(dependency, nodes, flags, graph));
            if (hasCycle) {
                return false; // Propagate cycle
            }
        }

        flags[node] = Status.DONE; // Mark done
        nodes.add(node);

        return true;
    }

    private enum Status {
        NEW,
        CURRENT,
        DONE
    }

    /**
     * Kahn algo solution
     * Runtime: 26.58%
     * Memory Usage: 21.54%
     */
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {

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

        Collections.reverse(topology);
        return topology.size() == numCourses ? topology.stream().mapToInt(value -> value).toArray() : new int[0];
    }
}
