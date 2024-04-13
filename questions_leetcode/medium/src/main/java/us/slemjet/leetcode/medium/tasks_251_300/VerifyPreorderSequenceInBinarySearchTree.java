package us.slemjet.leetcode.medium.tasks_251_300;

import java.util.Stack;

/**
 * 255. Verify Preorder Sequence in Binary Search Tree
 */
public class VerifyPreorderSequenceInBinarySearchTree {

    /**
     * Time: O(n)   ->  30.12%
     * Space:O(n)   ->  51.89%
     */
    public boolean verifyPreorder(int[] preorder) {

        // Preorder: self - left - right
        // BST: al nodes in left subtree < self < all nodes in right subtree

        Stack<Integer> depth = new Stack<>();
        int subnodeLeftLimit = Integer.MIN_VALUE;

        for (int next : preorder) {

            // Use monotonic stack
            while (!depth.isEmpty() && depth.peek() < next) {
                subnodeLeftLimit = depth.pop(); // Return from node - every net node must be greater than this value
            }

            if (next <= subnodeLeftLimit) {
                return false; // Cannot add as left node as is less than limit
            }

            depth.push(next);
        }

        return true;
    }
}