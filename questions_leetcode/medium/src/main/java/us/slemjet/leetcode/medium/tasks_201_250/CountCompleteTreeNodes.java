package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.Objects;

/**
 * 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {

    /**
     * Runtime: 100.00%
     * Memory Usage: 27.73%
     */
    public int countNodes(TreeNode root) {

        if (root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Optimization: If both left and rights subtree has same depths than
     * size is just 1 << depth (height)
     *
     * Runtime: 100.00%
     * Memory Usage: 34.04%
     */
    public int countNodesOptimized(TreeNode root) {

        if (root == null) return 0;

        // Left subtree
        int leftHeight = 0;
        TreeNode curr = root;
        while (curr != null) {
            curr = curr.left;
            leftHeight++;
        }
        // Right subtree
        int rightHeight = 0;
        curr = root;
        while (curr != null) {
            curr = curr.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return 1 + countNodesOptimized(root.left) + countNodesOptimized(root.right);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
