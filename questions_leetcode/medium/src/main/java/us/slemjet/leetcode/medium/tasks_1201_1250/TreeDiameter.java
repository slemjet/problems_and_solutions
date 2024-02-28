package us.slemjet.leetcode.medium.tasks_1201_1250;

import java.util.*;

/**
 * 1245. Tree Diameter
 */
public class TreeDiameter {

    /**
     *
     */
    public int treeDiameter(int[][] edges) {

        if (edges.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> nodeEdges = new HashMap<>();

        for (int[] edge : edges) {
            nodeEdges.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            nodeEdges.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Find furthestNode
        int furthestsNode = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(edges[0][0]); // Start from any node
        while (!nodes.isEmpty()) {
            Integer currentNode = nodes.poll();
            if (nodeEdges.containsKey(currentNode)) {
                List<Integer> nextNodes = nodeEdges.get(currentNode);
                for (int nextNode : nextNodes) {
                    if (!visited.contains(nextNode)) {
                        furthestsNode = nextNode; // Set furthestNode
                        nodes.offer(nextNode);
                    }
                }
            }
            visited.add(currentNode);
        }

        // Start from furthestNode and get to other furthest node - get max distance - diameter
        int diameter = 0;
        visited.clear();
        nodes.offer(furthestsNode);
        visited.add(furthestsNode);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Integer currentNode = nodes.poll();
                if (nodeEdges.containsKey(currentNode)) {
                    List<Integer> nextNodes = nodeEdges.get(currentNode);
                    for (int nextNode : nextNodes) {
                        if (!visited.contains(nextNode)) {
                            nodes.offer(nextNode);
                        }
                    }
                }
                visited.add(currentNode);
            }
            if (!nodes.isEmpty()) {
                diameter++;
            }
        }

        return diameter;
    }
}
