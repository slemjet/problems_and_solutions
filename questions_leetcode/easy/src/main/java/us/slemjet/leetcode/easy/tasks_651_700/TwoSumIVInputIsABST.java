package us.slemjet.leetcode.easy.tasks_651_700;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 */
public class TwoSumIVInputIsABST {

    /**
     * Use Set
     * <p>
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

    /**
     * Use Binary Search
     *
     * Runtime: 70.09%
     * Memory Usage: 42.38%
     */
    public boolean findTargetBinary(TreeNode root, int k) {
        return hasMatch(root, root, k);
    }

    private boolean hasMatch(TreeNode root, TreeNode curr, int k) {
        if (curr == null) return false;
        // Do binary search for current val and check subnodes for possible match
        return binarySearch(root, curr, k - curr.val) || hasMatch(root, curr.left, k) || hasMatch(root, curr.right, k);
    }

    private boolean binarySearch(TreeNode root, TreeNode curr, int k) {
        if (root == null) return false;
        // Traverse the tree looking for a match
        return root.val == k && root != curr
                || root.val < k && binarySearch(root.right, curr, k)
                || root.val > k && binarySearch(root.left, curr, k);
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
