package us.slemjet.leetcode.medium.tasks_501_550;

import us.slemjet.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 513. Find Bottom Left Tree Value
 */
public class FindBottomLeftTreeValue {

    /**
     * Use BFS
     * Time: O(n)    ->  30.43%
     * Space:O(n)    ->  55.25%
     */
    public int findBottomLeftValueBFS(TreeNode root) {

        int result = 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        // Do BFS and store first node from each level
        while (!nodes.isEmpty()) {

            int size = nodes.size();

            result = nodes.peek().val; // Leftmost node

            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
        }

        return result;
    }

    /**
     * DFS + Recursion
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  35.45%
     */
    public int findBottomLeftValueDFSRecursion(TreeNode root) {

        // int[val, depth]
        return findBottomLeftValueDFSRecursion(root, 0)[0];
    }

    private int[] findBottomLeftValueDFSRecursion(TreeNode root, int depth) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] result = new int[]{root.val, depth + 1};
        int[] left = findBottomLeftValueDFSRecursion(root.left, depth + 1);
        if (left[1] > result[1]) {
            result = left;
        }
        int[] right = findBottomLeftValueDFSRecursion(root.right, depth + 1);
        if (right[1] > result[1]) {
            result = right;
        }

        return result;
    }

    /**
     * Use DFS + Stack
     *
     * Time: O(n)   ->  10.45%
     * Space:O(n)   ->  42.15%
     */
    public int findBottomLeftValueDFSStack(TreeNode root) {

        int result = 0;
        int maxDepth = 0;

        Stack<Object[]> nodes = new Stack<>();
        nodes.push(new Object[]{root, 1});

        while (!nodes.isEmpty()) {

            Object[] record = nodes.pop();
            TreeNode node = (TreeNode) record[0];
            Integer depth = (Integer) record[1];
            if (depth > maxDepth) {
                // Starting next level
                result = node.val;
                maxDepth = depth;
            }
            if (node.right != null) {
                nodes.push(new Object[]{node.right, depth + 1});
            }
            // Push left last so it is processed first
            if (node.left != null) {
                nodes.push(new Object[]{node.left, depth + 1});
            }
        }

        return result;
    }
}
