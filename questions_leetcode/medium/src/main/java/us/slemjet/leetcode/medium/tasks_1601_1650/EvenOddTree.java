package us.slemjet.leetcode.medium.tasks_1601_1650;

import us.slemjet.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. Even Odd Tree
 */
public class EvenOddTree {

    /**
     * Time: O(n)   ->  99.22%
     * Space:O(n)   ->  45.70%
     */
    public boolean isEvenOddTree(TreeNode root) {

        int level = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        TreeNode prevNode = root;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = nodes.poll();
                if (level % 2 != 0) {
                    // Odd level - nodes need to go in increasing order and be even
                    if (node.val % 2 != 0 || (i > 0 && prevNode.val <= node.val)) {
                        return false;
                    }
                } else {
                    // Even level - nodes need to go in decreasing order and be odd
                    if (node.val % 2 == 0 || (i > 0 && prevNode.val >= node.val)) {
                        return false;
                    }
                }
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
                prevNode = node;
            }
            level++;
        }

        return true;
    }
}
