package us.slemjet.leetcode.medium.tasks_2351_2400;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2385. Amount of Time for Binary Tree to Be Infected
 */
public class AmountOfTimeForBinaryTreeToBeInfected {

    /**
     * Time: O(n)   ->  7.62%
     * Space: O(n)  ->  21.82%
     */
    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, List<Integer>> connections = new HashMap<>();

        populateConnections(root, connections);

        Queue<Integer> nodes = new LinkedList<>(connections.get(start));
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int time = 0;
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();

            for (int i = 0; i < levelSize; i++) {
                Integer currentNode = nodes.poll();
                visited.add(currentNode);
                List<Integer> nextNodes = connections.get(currentNode).stream()
                        .filter(nextNode -> !visited.contains(nextNode))
                        .toList();
                nodes.addAll(nextNodes);
            }
            time++;
        }

        return time;
    }

    private void populateConnections(TreeNode root, Map<Integer, List<Integer>> connections) {
        if (root == null) {
            return;
        }

        List<Integer> currentConnections = connections.getOrDefault(root.val, new ArrayList<>());
        if (root.left != null) {
            currentConnections.add(root.left.val);
            List<Integer> leftConnections = connections.getOrDefault(root.left.val, new ArrayList<>());
            leftConnections.add(root.val);
            connections.put(root.left.val, leftConnections);
            populateConnections(root.left, connections);
        }

        if (root.right != null) {
            currentConnections.add(root.right.val);
            List<Integer> rightConnections = connections.getOrDefault(root.right.val, new ArrayList<>());
            rightConnections.add(root.val);
            connections.put(root.right.val, rightConnections);
            populateConnections(root.right, connections);
        }

        connections.put(root.val, currentConnections);
    }

    /**
     * Time: O(n)   ->  97.91%
     * Space:O(n)   ->  54.56%
     */
    public int amountOfTimeOneTraverse(TreeNode root, int start) {

        AtomicInteger maxDistance = new AtomicInteger(0);
        traverse(root, start, maxDistance);
        return maxDistance.get();
    }

    private int traverse(TreeNode root, int start, AtomicInteger maxDistance) {
        if (root == null) {
            return 0;
        }

        int leftDepth = traverse(root.left, start, maxDistance);
        int rightDepth = traverse(root.right, start, maxDistance);

        if (root.val == start) {
            // Found first infected node
            maxDistance.set(Math.max(leftDepth, rightDepth));
            // Return -1 to indicate that subtree contains infected node
            return -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            // None of the subtrees contain infected node
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            // One of the subtrees contains infected nodes
            // The distance is sum distances of each subtree
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance.set(Math.max(maxDistance.get(), distance));
            return Math.min(leftDepth, rightDepth) - 1;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
