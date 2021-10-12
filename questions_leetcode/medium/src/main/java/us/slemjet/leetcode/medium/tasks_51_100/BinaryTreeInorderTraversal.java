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
     * Runtime: 100.00%
     * Memory Usage: 19.11%
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode peek = nodes.peek();
            if (peek.left != null) {
                nodes.push(peek.left);
                peek.left = null;
            } else {
                TreeNode pop = nodes.pop();
                result.add(pop.val);
                if (pop.right != null) {
                    nodes.push(pop.right);
                }
            }
        }
        return result;
    }

    /**
     * Recursive inorder
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
        if (root.left != null) inorder(root.left, result);
        result.add(root.val);
        if (root.right != null) inorder(root.right, result);
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
