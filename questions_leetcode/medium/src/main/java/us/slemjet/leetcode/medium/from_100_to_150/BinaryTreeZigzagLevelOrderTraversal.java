package us.slemjet.leetcode.medium.from_100_to_150;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * Recursive
     * Runtime: 100.00%
     * Memory Usage: 40.06%
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        populateLevels(root, levels, 0, false);

        return levels;
    }

    private void populateLevels(TreeNode root, List<List<Integer>> levels, int depth, boolean reversed) {
        if (root == null) return;

        if (levels.size() <= depth) levels.add(new LinkedList<>());
        List<Integer> level = levels.get(depth);
        if (reversed) level.add(0, root.val); // prepend
        else level.add(root.val); // append

        depth++;
        populateLevels(root.left, levels, depth, !reversed);
        populateLevels(root.right, levels, depth, !reversed);
    }

    /**
     * 2 Queues solution
     * Runtime: 74.37%
     * Memory Usage: 90.65%
     */
    public List<List<Integer>> zigzagLevelOrder2Queue(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> primary = new ArrayDeque<>();
        Queue<TreeNode> secondary = new ArrayDeque<>();

        boolean reversed = false;
        primary.offer(root);

        while (!primary.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            while (!primary.isEmpty()) {
                TreeNode pop = primary.poll();
                if (reversed) current.add(0, pop.val);
                else current.add(pop.val);
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
            reversed = !reversed;
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
