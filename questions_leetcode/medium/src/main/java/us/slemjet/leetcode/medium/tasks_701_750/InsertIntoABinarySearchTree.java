package us.slemjet.leetcode.medium.tasks_701_750;

import java.util.Objects;

/**
 * 701. Insert into a Binary Search Tree
 */
public class InsertIntoABinarySearchTree {

    /**
     * Runtime: 100.00%
     * Memory Usage: 41.97%
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;

        if (root.val > val) {
            if (root.left == null) root.left = newNode;
            else insertIntoBST(root.left, val);
        } else {
            if (root.right == null) root.right = newNode;
            else insertIntoBST(root.right, val);
        }

        return root;
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
