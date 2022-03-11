package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.Objects;

/**
 * 61. Rotate List
 */
public class RotateList {

    /**
     * Runtime: 75.83%
     * Memory Usage: 22.03%
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;

        // Get length
        int length = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        // Remove length larger than k since they are cyclical
        k = length - k % length;
        if (k == length) return head; // Shortcut if no rotation is needed

        ListNode curr = head;
        while (--k > 0) {
            curr = curr.next;
        }

        // Now curr is pointing to length - k node, last is pointing to the last node
        last.next = head; // Link end with head
        head = curr.next; // Length - k is a new head
        curr.next = null; // Set new tail

        return head;
    }


    public static class ListNode {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
