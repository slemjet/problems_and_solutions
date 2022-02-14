package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Recursive / DFS
     * Runtime: 100.00%
     * Memory Usage: 89.61%
     */
    public int maxDepthDFS(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(depth(root.left, depth + 1), depth(root.right, depth + 1));
    }

    /**
     * BFS
     * Runtime: 27.75%
     * Memory Usage: 22.86%
     */
    public int maxDepthBFS(TreeNode root) {

        int result = 0;
        if (root == null) return result;

        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);

        while (!level.isEmpty()) {
            int levelSize = level.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = level.poll();
                if (poll.left != null) level.offer(poll.left);
                if (poll.right != null) level.offer(poll.right);
            }
            result++;
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
