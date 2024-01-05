package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 */
public class HouseRobberIII {

    /**
     * Time:    ->  11.27%
     * Space:   ->  26.11%
     */
    public int rob(TreeNode root) {
        Map<TreeNode, Integer[]> memo = new HashMap<>();
        return Math.max(robSubtree(root, true, memo), robSubtree(root, false, memo));
    }

    private int robSubtree(TreeNode root, boolean include, Map<TreeNode, Integer[]> memo) {

        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root) && memo.get(root)[include ? 1 : 0] != null) {
            return memo.get(root)[include ? 1 : 0];
        }

        int includeSum = 0;
        if (include) {
            includeSum = root.val + robSubtree(root.left, false, memo) + robSubtree(root.right, false, memo);
        }
        int excludeSum = robSubtree(root.left, true, memo) + robSubtree(root.right, true, memo);

        int maxSum = Math.max(includeSum, excludeSum);
        if (!memo.containsKey(root)) {
            memo.put(root, new Integer[2]);
        }
        memo.get(root)[include ? 1 : 0] = maxSum;
        return maxSum;
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
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
