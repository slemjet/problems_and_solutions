package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {

    /**
     * Iterative - stack
     * <p>
     * Runtime: 29.82%
     * Memory Usage: 29.71%
     */
    public List<Integer> postorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.pop();
            if (next != null) {
                if (next.right == null && next.left == null) {
                    result.add(next.val);
                } else {
                    nodes.push(next);
                    nodes.push(next.right);
                    nodes.push(next.left);
                    // Set as null so next time they are not processed
                    next.left = null;
                    next.right = null;
                }
            }
        }

        return result;
    }

    /**
     * Recursive postorder
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 45.82%
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
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
