package us.slemjet.leetcode.easy.tasks_651_700;

import java.util.Objects;

/**
 * 700. Search in a Binary Search Tree
 */
public class SearchInABinarySearchTree {

    /**
     * Runtime: 100.00%
     * Memory Usage: 16.30%
     */
    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
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
