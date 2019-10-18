package us.slemjet.leetcode.medium.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
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
