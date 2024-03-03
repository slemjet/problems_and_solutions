package us.slemjet.leetcode.medium.tasks_301_350;

import us.slemjet.leetcode.common.TreeNode;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 */
public class BinaryTreeVerticalOrderTraversal {

    /**
     * BFS (no sorting)
     * Time: O(n)  ->  97.85%
     * Space:O(n)  ->  90.65%
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> nodeByIndex = new HashMap<>();

        Queue<Pair<Integer, TreeNode>> nodes = new LinkedList<>();
        nodes.offer(new Pair<>(0, root));

        // To avoid sorting - we store indices range
        int leftmostIdx = Integer.MAX_VALUE;
        int rightmostIdx = Integer.MIN_VALUE;

        while (!nodes.isEmpty()) {

            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, TreeNode> nodeWithIndex = nodes.poll();
                Integer idx = nodeWithIndex.t1;
                TreeNode node = nodeWithIndex.t2;
                nodeByIndex.computeIfAbsent(idx, k -> new ArrayList<>()).add(node.val);
                leftmostIdx = Math.min(leftmostIdx, idx);
                rightmostIdx = Math.max(rightmostIdx, idx);
                if (node.left != null) {
                    nodes.offer(new Pair<>(idx - 1, node.left));
                }
                if (node.right != null) {
                    nodes.offer(new Pair<>(idx + 1, node.right));
                }
            }
        }

        for (int i = leftmostIdx; i <= rightmostIdx; i++) {
            if(nodeByIndex.containsKey(i)){
                result.add(nodeByIndex.get(i));
            }
        }

        return result;
    }

    private static class Pair<T1, T2> {
        public T1 t1;
        public T2 t2;


        public Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    }
}
