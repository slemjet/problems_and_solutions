package us.slemjet.leetcode.easy.from_100_to_150;

/**
 * 101. Symmetric Tree
 */
public class SymmetricTree {

    /**
     * Runtime: 100.00%
     * Memory Usage: 80.13%
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return reversedEquals(root.left, root.right);

    }

    private boolean reversedEquals(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;

        if (left != null && right != null) {
            return left.val == right.val && reversedEquals(left.left, right.right) && reversedEquals(left.right, right.left);
        }
        return false;

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
