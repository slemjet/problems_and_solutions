package us.slemjet.leetcode.medium.tasks_1301_1350;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1305. All Elements in Two Binary Search Trees
 */
public class AllElementsInTwoBinarySearchTrees {

    /**
     * Do preorder on both trees, than merge resulting lists
     * <p>
     * Runtime: 32.61%
     * Memory Usage: 17.74%
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> results = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        preorder(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        preorder(root2, list2);

        int i1 = 0;
        int i2 = 0;

        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1) > list2.get(i2)) {
                results.add(list2.get(i2));
                i2++;
            } else {
                results.add(list1.get(i1));
                i1++;
            }
        }

        while (i1 < list1.size()) results.add(list1.get(i1++));
        while (i2 < list2.size()) results.add(list2.get(i2++));

        return results;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        preorder(root.left, list);
        list.add(root.val);
        preorder(root.right, list);
    }

    /**
     * Use 2 stacks to contain next node to process from each tree
     *
     * Runtime: 18.09%
     * Memory Usage: 47.09%
     */
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {

        List<Integer> result = new ArrayList<>();

        // Use 2 stacks to keep current leaf node (starting from leftmost) that can be compared and merged
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {

            // Populate stacks with leftmost leafs
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val <= stack2.peek().val)) {
                // Need to process values from stack1
                root1 = stack1.pop(); // Node has no unprocessed nodes to the left
                result.add(root1.val); // Add to result since it is <= stack 2 value
                root1 = root1.right; // Check right subtree
            } else {
                // Need to process values from stack2
                root2 = stack2.pop();
                result.add(root2.val);
                root2 = root2.right;
            }
        }
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
