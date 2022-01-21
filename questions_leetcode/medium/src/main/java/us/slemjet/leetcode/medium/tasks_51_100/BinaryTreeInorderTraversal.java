package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 */
public class BinaryTreeInorderTraversal {

    /**
     * Iterative - stack
     *
     * Runtime: 100.00%
     * Memory Usage: 63.77%
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {

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
                    nodes.push(next.right);
                    nodes.push(next);
                    nodes.push(next.left);
                    next.left = null;
                    next.right = null;
                }
            }
        }

        return result;
    }

    /**
     * Recursive inorder
     *
     * Runtime: 100.00%
     * Memory Usage: 93.06%
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
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
