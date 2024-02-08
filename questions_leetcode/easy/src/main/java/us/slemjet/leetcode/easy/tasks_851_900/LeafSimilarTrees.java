package us.slemjet.leetcode.easy.tasks_851_900;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 872. Leaf-Similar Trees
 */
public class LeafSimilarTrees {

    /**
     * Time: O(n + m)   ->  7.08%
     * Space:O(1)       ->  22.06%
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leaves1 = getLeavesPreorder(root1);
        List<Integer> leaves2 = getLeavesPreorder(root2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }

        for (int i = 0; i < leaves1.size(); i++) {
            if (!Objects.equals(leaves1.get(i), leaves2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> getLeavesPreorder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> leaves = new ArrayList<>();

        if (root.left == null && root.right == null) {
            // Leaf node
            leaves.add(root.val);
        } else {
            // Aggregate subleaf
            List<Integer> leftLeaves = getLeavesPreorder(root.left);
            List<Integer> rightLeaves = getLeavesPreorder(root.right);

            if (leftLeaves != null) {
                leaves.addAll(leftLeaves);
            }
            if (rightLeaves != null) {
                leaves.addAll(rightLeaves);
            }
        }

        return leaves;
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
