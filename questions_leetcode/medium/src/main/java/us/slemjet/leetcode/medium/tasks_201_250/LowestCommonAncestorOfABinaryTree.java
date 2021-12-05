package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * Runtime: 100.00%
     * Memory Usage: 57.79%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root; // Solution found
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Both left and right have solutions - common is current
        if (left != null && right != null)
            return root;

        // Solution is not to the left subtree - it should be in the right subtree
        if (left == null) return right;
            // Solution is not to the right subtree - return left
        else return left;
    }

    /**
     * Runtime: 22.59%
     * Memory Usage: 99.34%
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode result = null;

        Queue<TreeNode> pathP = getPath(root, p, new HashSet<>());
        Queue<TreeNode> pathQ = getPath(root, q, new HashSet<>());

        while (!pathQ.isEmpty() && !pathP.isEmpty() && pathQ.peek() == pathP.peek()) {
            result = pathQ.peek();
            pathQ.poll();
            pathP.poll();
        }

        return result;
    }

    private Queue<TreeNode> getPath(TreeNode root, TreeNode p, HashSet<Integer> visited) {

        Deque<TreeNode> path = new ArrayDeque<>();
        while (root != null) {
            path.add(root);
            visited.add(root.val);
            if (root.val == p.val) {
                return path;
            } else if (root.left != null && !visited.contains(root.left.val)) {
                root = root.left;
            } else if (root.right != null && !visited.contains(root.right.val)) {
                root = root.right;
            } else {
                // Backtrack
                path.pollLast();
                root = path.pollLast();
            }
        }

        return path;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
