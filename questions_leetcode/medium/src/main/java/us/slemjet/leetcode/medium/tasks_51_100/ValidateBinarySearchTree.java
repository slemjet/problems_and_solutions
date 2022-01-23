package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {

    /**
     * Runtime: 50.41%
     * Memory Usage: 28.86%
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min || max != null && root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * Runtime: 16.68%
     * Memory Usage: 48.19%
     */
    public boolean isValidBST2(TreeNode root) {
        return traverseInorder(root, new ArrayList<>());
    }

    private boolean traverseInorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return true;

        if (node.left != null && !traverseInorder(node.left, list))
            return false;

        if (list.size() > 0 && list.get(list.size() - 1) >= node.val)
            return false;
        else
            list.add(node.val);

        return node.right == null || traverseInorder(node.right, list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int x) {
            val = x;
        }
    }
}
