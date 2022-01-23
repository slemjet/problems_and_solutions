package us.slemjet.leetcode.easy.from_651_to_700;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 */
public class TwoSumIVInputIsABST {

    /**
     * Runtime: 70.09%
     * Memory Usage: 91.32%
     */
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(new HashSet<>(), root, k);
    }

    private boolean findTarget(Set<Integer> complements, TreeNode root, int k) {

        if (root == null) return false;

        if (complements.contains(root.val)) return true;
        complements.add(k - root.val);

        return findTarget(complements, root.left, k) || findTarget(complements, root.right, k);
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
    }
}
