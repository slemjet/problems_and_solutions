package us.slemjet.leetcode.medium.tasks_601_650;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 662. Maximum Width of Binary Tree
 */
public class MaximumWidthOfBinaryTree {

    /**
     * Runtime: 78.55%
     * Memory Usage: 36.97%
     */
    public int widthOfBinaryTreeDfs(TreeNode root) {
        List<Integer> leftNodes = new ArrayList<>();
        return dfs(root, leftNodes, 1, 0);
    }

    private int dfs(TreeNode node, List<Integer> leftNodes, int idx, int depth) {
        if (node == null) return 0;
        if (depth >= leftNodes.size()) leftNodes.add(idx); // New leftmostNode
        int currWidth = idx - leftNodes.get(depth) + 1;
        return Math.max(currWidth,
                Math.max(
                        dfs(node.left, leftNodes, idx * 2, depth + 1),
                        dfs(node.right, leftNodes, idx * 2 + 1, depth + 1)));
    }

    /**
     * Runtime: 51.78%
     * Memory Usage: 5.07%
     */
    public int widthOfBinaryTree(TreeNode root) {

        int result = 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>();
        nodes.add(root);
        indices.add(1);

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            int left = 0, right = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.remove();
                int index = indices.remove();

                if (i == 0) left = index; // Start index of a level
                if (i == levelSize - 1) right = index; // End index of a level

                if (node.left != null) {
                    nodes.add(node.left);
                    indices.add(2 * index); // Left child idx = parent * 2
                }

                if (node.right != null) {
                    nodes.add(node.right);
                    indices.add(2 * index + 1); // Right child idx = parent * 2 + 1
                }
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
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
