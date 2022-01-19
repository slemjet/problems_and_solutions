package us.slemjet.leetcode.easy.from_201_to_250;

import java.util.Objects;

/**
 * 203. Remove Linked List Elements
 */
public class RemoveLinkedListElements {

    /**
     * Runtime: 82.14%
     * Memory Usage: 26.58%
     */
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            // Skip leading values in the list
            head = head.next;
        }

        ListNode curr = head; // Node for traversal

        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                // Skip values inside list
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

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
    }
}
