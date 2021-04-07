package us.slemjet.leetcode.medium.from_100_to_150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * Recursive + cache
     * Runtime: 98.59%
     * Memory Usage: 18.60%
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Cache inorder indexes
        Map<Integer, Integer> inByIdx = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inByIdx.put(inorder[i], i);
        }

        // We create node using next preorder element as node value and interval of inorder indexes for subtrees
        return createNode(0, 0, inorder.length - 1, inByIdx, preorder);
    }

    private TreeNode createNode(int preIdx, int inLeft, int inRight, Map<Integer, Integer> inByIdx, int[] preorder) {

        if (inLeft > inRight || preIdx >= preorder.length) return null;

        int nodeVal = preorder[preIdx];
        int inIdx = inByIdx.get(nodeVal);

        TreeNode node = new TreeNode(nodeVal);
        node.left = createNode(preIdx + 1, inLeft, inIdx - 1, inByIdx, preorder);

        // inIdx - inLeft; // we skip nodes traversed earlier by preorder - left subtree
        node.right = createNode(preIdx + (inIdx - inLeft) + 1, inIdx + 1, inRight, inByIdx, preorder);

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
