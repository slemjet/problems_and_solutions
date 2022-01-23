package us.slemjet.leetcode.medium.tasks_1001_1050;

import java.util.Stack;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    /**
     * Runtime: 1 ms, faster than 42.98%
     * Memory Usage: 37.6 MB, less than 72.48%
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> depth = new Stack<>();
        depth.add(root);

        for (int i = 1; i < preorder.length; i++) {
            int value = preorder[i];
            TreeNode nextNode = new TreeNode(value);
            TreeNode next = depth.peek();
            if (value < next.val) {
                // Left - just add
                next.left = nextNode;
            } else {
                // Right - seek for node to append to right
                while (!depth.isEmpty() && value > depth.peek().val) {
                    next = depth.pop();
                }
                next.right = nextNode;
            }
            depth.add(nextNode);
        }
        return root;
    }

    int currIdx = 0;

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 37.7 MB, less than 65.67%
     */
    public TreeNode bstFromPreorderBFS(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bst(int[] preorder, int upperBound) {
        if (currIdx == preorder.length || preorder[currIdx] > upperBound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[currIdx]);
        currIdx++;
        root.left = bst(preorder, root.val); // only less than values can be to the left
        root.right = bst(preorder, upperBound); // more than values can be to hte right
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
    }
}
