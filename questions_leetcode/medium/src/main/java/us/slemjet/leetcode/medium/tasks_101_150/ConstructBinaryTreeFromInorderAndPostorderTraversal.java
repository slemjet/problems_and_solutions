package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     *
     * Recursive + cache
     * Time: O(n) -> Runtime: 97.95%
     * Space: O(n) -> Memory Usage: 45.31%
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inorderIndexes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexes.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderIndexes);
    }

    private TreeNode buildTree(int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderIndexes) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRootIdx = inorderIndexes.get(rootValue);

        int leftSubtreeSize = inRootIdx - inStart;

        root.left = buildTree(inStart, inRootIdx - 1, postorder, postStart, postStart + leftSubtreeSize - 1, inorderIndexes);
        root.right = buildTree(inRootIdx + 1, inEnd, postorder, postStart + leftSubtreeSize, postEnd - 1, inorderIndexes);

        return root;
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
