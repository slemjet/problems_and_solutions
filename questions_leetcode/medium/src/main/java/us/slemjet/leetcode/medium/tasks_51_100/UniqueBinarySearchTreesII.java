package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 95. Unique Binary Search Trees II
 */
public class UniqueBinarySearchTreesII {

    /**
     * Time: -> 99.67%
     * Space: -> 52.55%
     */
    public List<TreeNode> generateTrees(int n) {

        return generateBst(1, n, new List[n + 1][n + 1]);
    }

    private List<TreeNode> generateBst(int start, int end, List<TreeNode>[][] memo) {

        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        if (memo[start][end] != null) {
            return memo[start][end];
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateBst(start, i - 1, memo);
            List<TreeNode> rightSubtrees = generateBst(i + 1, end, memo);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode rootNode = new TreeNode(i);
                    rootNode.left = left;
                    rootNode.right = right;
                    result.add(rootNode);
                }
            }
        }

        memo[start][end] = result;

        return result;
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
