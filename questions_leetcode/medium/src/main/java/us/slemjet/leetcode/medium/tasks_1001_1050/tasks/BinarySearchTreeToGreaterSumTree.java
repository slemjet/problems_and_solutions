package us.slemjet.leetcode.medium.tasks_1001_1050.tasks;

import java.util.Objects;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 */
public class BinarySearchTreeToGreaterSumTree {

    /**
     * Runtime: 100.00%
     * Memory Usage: 18.71%
     */
    public TreeNode bstToGst(TreeNode root) {
        postorder(root, 0);
        return root;
    }

    private int postorder(TreeNode node, int acc) {
        if (node == null) return acc;

        node.val += postorder(node.right, acc); // Process right subtree and add to current node value
        return postorder(node.left, node.val); // Process left subtree and return result
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
