package us.slemjet.leetcode.easy.from_201_to_250;

import java.util.Objects;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * Runtime: 29.37%
     * Memory Usage: 11.05%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q); // Both '>' -> common to the right
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);  // Both '<' -> common to the left
        else return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
