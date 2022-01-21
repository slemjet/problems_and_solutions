package us.slemjet.leetcode.easy.from_201_to_250;

import java.util.Objects;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {

    /**
     * Runtime: 100.00%
     * Memory Usage: 78.47%
     */
    public TreeNode invertTree(TreeNode root) {

        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        reverse(root.left);
        reverse(root.right);
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
