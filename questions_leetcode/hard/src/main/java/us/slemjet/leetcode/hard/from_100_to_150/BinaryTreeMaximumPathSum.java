package us.slemjet.leetcode.hard.from_100_to_150;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 124.Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    /**
     * Runtime: 100.00%
     * Memory Usage: 73.57%
     */
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode node) {
        if (node == null) return 0;

        int leftMax = Math.max(maxPath(node.left), 0); // Cut off negatives
        int rightMax = Math.max(maxPath(node.right), 0); // Cut off negatives

        int sum = leftMax + rightMax + node.val;
        // Check if sum is maximum
        max = Math.max(max, sum);
        // can take either left ot right as it is a subtree path
        return node.val + Math.max(leftMax, rightMax);
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
