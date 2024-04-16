package us.slemjet.leetcode.medium.tasks_601_650;

import us.slemjet.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. Add One Row to Tree
 */
public class AddOneRowToTree {

    /**
     * Time: O(n)   ->  31.80%
     * Space:O(n)   ->  49.63%
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        TreeNode parent = new TreeNode(0, root, null);

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(parent);

        while (!nodes.isEmpty() && depth != 0) {
            int size = nodes.size();

            for (int i = 0; i < size; i++) {

                TreeNode polled = nodes.poll();
                if (polled == null) {
                    continue;
                }
                if (depth == 1) {
                    // Insert nodes
                    TreeNode insertedLeft = new TreeNode(val);
                    insertedLeft.left = polled.left;
                    TreeNode insertedRight = new TreeNode(val);
                    insertedRight.right = polled.right;
                    polled.left = insertedLeft;
                    polled.right = insertedRight;
                } else {
                    nodes.add(polled.left);
                    nodes.add(polled.right);
                }
            }
            depth--;
        }


        return parent.left;
    }
}
