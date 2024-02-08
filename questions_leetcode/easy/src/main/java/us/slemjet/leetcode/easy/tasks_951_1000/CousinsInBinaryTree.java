package us.slemjet.leetcode.easy.tasks_951_1000;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tree
 */
public class CousinsInBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 37 MB, less than 92.81%
     */
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> backup = new ArrayDeque<>();
        queue.add(root);

        // Do a BFS
        while (!queue.isEmpty()) {

            // start processing current row
            int matches = 0;
            while (!queue.isEmpty()) {
                TreeNode next = queue.poll();
                int currentMatch = 0;

                if (next.left != null) {
                    backup.add(next.left);

                    if (next.left.val == x || next.left.val == y) {
                        matches++;
                        currentMatch++;
                    }
                }

                if (next.right != null) {
                    backup.add(next.right);

                    if (next.right.val == x || next.right.val == y) {
                        matches++;
                        currentMatch++;
                    }
                }
                // current row has 2 matches - fails the requirement
                if (currentMatch == 2)
                    return false;
            }

            if (matches == 2)
                return true;
            if (matches == 1)
                return false;
            else {
                queue = backup;
                backup = new ArrayDeque<>();
            }
        }
        return false;
    }

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 37.3 MB, less than 76.82%
     */
    public boolean isCousinsDelimiter(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // Delimiter to separate levels
        TreeNode delimiter = new TreeNode(0);
        queue.add(delimiter);

        // Do a BFS
        while (!queue.isEmpty()) {

            // start processing current row
            int matches = 0;
            while (!queue.isEmpty()) {
                TreeNode next = queue.poll();

                if (next == delimiter) {
                    if (matches == 2)
                        return true;
                    if (matches == 1)
                        return false;


                    if (!queue.isEmpty()) {
                        queue.add(delimiter);
                    }
                    continue;
                }

                int currentMatch = 0;

                if (next.left != null) {
                    queue.add(next.left);

                    if (next.left.val == x || next.left.val == y) {
                        matches++;
                        currentMatch++;
                    }
                }

                if (next.right != null) {
                    queue.add(next.right);

                    if (next.right.val == x || next.right.val == y) {
                        matches++;
                        currentMatch++;
                    }
                }
                // current row has 2 matches - fails the requirement
                if (currentMatch == 2)
                    return false;
            }
        }
        return false;
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
