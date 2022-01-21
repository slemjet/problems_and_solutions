package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {

    /**
     * Runtime: 100.00%
     * Memory Usage: 8.55%
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    /**
     *
     * Runtime: 100.00%
     * Memory Usage: 48.97%
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.pop();
            if (next != null) {
                result.add(next.val);
                nodes.push(next.right);
                nodes.push(next.left);
            }
        }

        return result;
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
