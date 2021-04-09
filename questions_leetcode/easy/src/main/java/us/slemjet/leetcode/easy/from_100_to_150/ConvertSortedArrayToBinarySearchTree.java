package us.slemjet.leetcode.easy.from_100_to_150;

import java.util.Objects;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * Runtime: 100.00%
     * Memory Usage: 86.44%
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums, 0, nums.length - 1);
    }

    private TreeNode createNode(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + ((end - start + 1) / 2);

        TreeNode node = new TreeNode(nums[mid]);

        node.left = createNode(nums, start, mid - 1);
        node.right = createNode(nums, mid + 1, end);

        return node;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
