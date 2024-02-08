package us.slemjet.leetcode.easy.tasks_901_950;

/**
 * 938. Range Sum of BST
 */
public class RangeSumOfBST {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  8.65%
     */
    public int rangeSumBST(TreeNode root, int low, int high) {

        int sum = 0;

        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val >= low) {
            sum += rangeSumBST(root.left, low, high);
        }

        if (root.val <= high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
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
