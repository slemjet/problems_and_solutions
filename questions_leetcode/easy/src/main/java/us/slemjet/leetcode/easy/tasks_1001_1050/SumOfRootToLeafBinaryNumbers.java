package us.slemjet.leetcode.easy.tasks_1001_1050;

import java.util.ArrayList;
import java.util.List;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 */
public class SumOfRootToLeafBinaryNumbers {

    /**
     * Runtime: 100.00%
     * Memory Usage: 26.66%
     */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = sum << 1; // Next grade -> we travers from higher bit to lower
        sum += node.val; // Add current node

        if (node.left == null && node.right == null)
            return sum; // Reached combination end

        int result = 0;
        result += dfs(node.left, sum);
        result += dfs(node.right, sum);

        return result;
    }

    /**
     * Runtime: 40.24%
     * Memory Usage: 13.71%
     */
    public int sumRootToLeaf2(TreeNode root) {
        return dfs(0, new ArrayList<>(), root);
    }

    private int dfs(int result, List<Integer> current, TreeNode node) {
        current.add(node.val);
        if (node.left == null && node.right == null) {
            int add = 0;
            for (int i = 0; i < current.size(); i++) {
                int shift = current.size() - 1 - i;
                add += (current.get(i) & 1) << shift;
            }
            result += add;
        } else {
            if (node.left != null)
                result = dfs(result, current, node.left);
            if (node.right != null)
                result = dfs(result, current, node.right);
        }
        current.remove(current.size() - 1);

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
    }
}
