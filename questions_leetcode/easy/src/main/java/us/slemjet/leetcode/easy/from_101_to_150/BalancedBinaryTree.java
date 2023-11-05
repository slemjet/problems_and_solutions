package us.slemjet.leetcode.easy.from_101_to_150;

import java.util.Objects;

/**
 * 110. Balanced Binary Tree
 */
public class BalancedBinaryTree {

    /**
     * Run DFS measuring height and checking inbalance
     *
     * Time: O(n) -> 100.00%
     * Space: O(h) where O(log n) in a balanced tree and O(n) in an unbalanced tree  -> 93.16%
     */
    public boolean isBalanced(TreeNode root) {

        // -1 indicates that there is inbalance of the tree
        return checkIfBalanced(root) != -1;
    }

    private int checkIfBalanced(TreeNode root) {
        if (root == null)
            return 0;

        int left = checkIfBalanced(root.left);
        int right = checkIfBalanced(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }


    protected static class TreeNode {
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
            TreeNode node = (TreeNode) o;
            return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
