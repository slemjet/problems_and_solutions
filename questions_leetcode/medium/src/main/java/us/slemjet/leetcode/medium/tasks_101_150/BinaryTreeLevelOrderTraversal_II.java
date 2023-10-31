package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 */
public class BinaryTreeLevelOrderTraversal_II {

    /**
     *
     * Time: O(n) -> 94.64%
     * Space: O(n) -> Beats 22.28%
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty() && nodes.peek() != null){
            int size = nodes.size();
            List<Integer> currLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodes.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) nodes.add(currNode.left);
                if (currNode.right != null) nodes.add(currNode.right);
            }
            result.add(currLevel);
        }

        Collections.reverse(result);

        return result;
    }

    protected static class TreeNode {
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
