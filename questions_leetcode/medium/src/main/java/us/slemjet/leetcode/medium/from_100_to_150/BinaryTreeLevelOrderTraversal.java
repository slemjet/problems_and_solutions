package us.slemjet.leetcode.medium.from_100_to_150;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Recursive
     * Runtime: 100.00%
     * Memory Usage: 73.52%
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        populateLevels(root, levels, 0);
        return levels;
    }

    private void populateLevels(TreeNode root, List<List<Integer>> levels, int depth) {
        if (root == null) return;

        if (levels.size() <= depth) levels.add(new ArrayList<>());
        levels.get(depth).add(root.val);

        depth++;
        populateLevels(root.left, levels, depth);
        populateLevels(root.right, levels, depth);
    }

    /**
     * 2 Queues solution
     * Runtime: 56.72%
     * Memory Usage: 24.85%
     */
    public List<List<Integer>> levelOrder2Queue(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> primary = new ArrayDeque<>();
        Queue<TreeNode> secondary = new ArrayDeque<>();

        primary.offer(root);

        while (!primary.isEmpty()){
            List<Integer> current = new ArrayList<>();
            while (!primary.isEmpty()){
                TreeNode pop = primary.poll();
                current.add(pop.val);
                if (pop.left != null) {
                    secondary.offer(pop.left);
                }
                if (pop.right != null) {
                    secondary.offer(pop.right);
                }
            }
            levels.add(current);
            Queue<TreeNode> tmp = primary;
            primary = secondary;
            secondary = tmp;
        }
        return levels;
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
