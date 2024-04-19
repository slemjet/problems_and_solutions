package us.slemjet.leetcode.easy.tasks_1451_1500;

import us.slemjet.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1469. Find All The Lonely Nodes
 */
public class FindAllTheLonelyNodes {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  33.97%
     */
    public List<Integer> getLonelyNodes(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        getLonelyNodes(root, result);
        return result;
    }

    private void getLonelyNodes(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        if (root.left != null && root.right == null) {
            result.add(root.left.val);
        }
        if (root.right != null && root.left == null) {
            result.add(root.right.val);
        }

        getLonelyNodes(root.left, result);
        getLonelyNodes(root.right, result);
    }
}
