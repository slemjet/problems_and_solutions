package us.slemjet.leetcode.easy.from_101_to_150;

/**
 * 112. Path Sum
 */
public class PathSum {

    /**
     * Runtime: 100.00%
     * Memory Usage: 65.40%
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false;

        if (root.left == null && root.right == null) return targetSum == root.val; // Is a leaf

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * Runtime: 39.12%
     * Memory Usage: 25.24%
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        return checkSum(root, 0, targetSum);
    }

    private boolean checkSum(TreeNode root, int currSum, int targetSum) {
        if (root == null) return false;

        currSum += root.val;

        if (root.left != null || root.right != null) {
            return checkSum(root.left, currSum, targetSum) || checkSum(root.right, currSum, targetSum);
        } else {
            return currSum == targetSum;
        }
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
