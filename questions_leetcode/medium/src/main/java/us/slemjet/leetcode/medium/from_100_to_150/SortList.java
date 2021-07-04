package us.slemjet.leetcode.medium.from_100_to_150;

import java.util.Objects;

/**
 * 148. Sort List
 */
public class SortList {

    /**
     * Merge Sort
     * Runtime: 83.67%
     * Memory Usage: 74.80%
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 1. Split in half. When fast reaches end, half(slower) will reach middle
        ListNode half = head, fast = head, leftEnd = null;
        while (fast != null && fast.next != null) {
            leftEnd = half;
            half = half.next;
            fast = fast.next.next;
        }
        leftEnd.next = null; // Cut off left tail

        // 2. Sort halves
        ListNode sortedLeft = sortList(head);
        ListNode sortedRight = sortList(half);

        // 3. Merge halves
        return merge(sortedLeft, sortedRight);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode start = new ListNode(0);
        ListNode curr = start;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        }

        if (right != null) {
            curr.next = right;
        }

        return start.next;
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
