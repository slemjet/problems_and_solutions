package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * Use 2 pointers fast and slow to get middle element
     * Time: O(logn)-> 100.00%
     * Space: 0(logn) -> 88.79%
     */
    public TreeNode sortedListToBST2Pointers(ListNode head) {

        if (head == null)
            return null;

        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail)
            return null;

        // Use 2 pointers to get middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);

        return root;
    }

    /**
     * Use auxiliary array and after standard binary tree to build
     * Time: O(logn)-> 37.97%
     * Space: 0(n) -> 7.77%
     */
    public TreeNode sortedListToBSTArray(ListNode head) {

        List<Integer> sortedTree = new ArrayList<>();
        while (head != null) {
            sortedTree.add(head.val);
            head = head.next;
        }

        return buildTree(sortedTree, 0, sortedTree.size() - 1);
    }

    private TreeNode buildTree(List<Integer> sortedTree, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(sortedTree.get(mid));

        root.left = buildTree(sortedTree, start, mid - 1);
        root.right = buildTree(sortedTree, mid + 1, end);

        return root;
    }

    protected static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
            TreeNode node = (TreeNode) o;
            return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
