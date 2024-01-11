package us.slemjet.leetcode.medium.tasks_1001_1050;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 */
public class MaximumDifferenceBetweenNodeAndAncestor {

    /**
     * Time: O(n)   ->  100.00%
     * Space: O(n)  ->  5.25%
     */
    public int maxAncestorDiff(TreeNode root) {

        return maxAncestorDiff(root, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private int maxAncestorDiff(TreeNode root, int minValue, int maxValue, int maxDifference) {

        // For each subtree pass current max and min values and for each nod update them and recalculate difference
        if (root == null) {
            return 0;
        }

        maxValue = Math.max(maxValue, root.val);
        minValue = Math.min(minValue, root.val);
        maxDifference = Math.max(maxDifference, Math.abs(maxValue - minValue));

        int maxLeftDifference = maxAncestorDiff(root.left, minValue, maxValue, maxDifference);
        int maxRightDifference = maxAncestorDiff(root.right, minValue, maxValue, maxDifference);
        maxDifference = Math.max(maxDifference, maxLeftDifference);
        maxDifference = Math.max(maxDifference, maxRightDifference);

        return maxDifference;
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
