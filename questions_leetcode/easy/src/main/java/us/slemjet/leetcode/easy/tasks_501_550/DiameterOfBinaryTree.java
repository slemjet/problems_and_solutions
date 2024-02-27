package us.slemjet.leetcode.easy.tasks_501_550;

import us.slemjet.leetcode.common.TreeNode;

/**
 * 543. Diameter of Binary Tree
 */
public class DiameterOfBinaryTree {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  48.17%
     */
    public int diameterOfBinaryTree(TreeNode root) {

        int[] helper = helper(root);

        return helper[1];
    }

    /**
     * int[maxDepth, maxDiameter]
     */
    private int[] helper(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int maxDepth = 1 + Math.max(left[0], right[0]);
        int maxDiameter = Math.max(
                left[0] + right[0],
                Math.max(left[1], right[1])
        );

        return new int[]{maxDepth, maxDiameter};
    }
}
