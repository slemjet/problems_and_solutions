package us.slemjet.leetcode.medium.from_100_to_150;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Recursive
     * Runtime: 100.00%
     * Memory Usage: 89.61%
     */
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode root, int depth) {
        if(root == null) return depth;
        return Math.max(depth(root.left, depth + 1), depth(root.right, depth + 1));
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
