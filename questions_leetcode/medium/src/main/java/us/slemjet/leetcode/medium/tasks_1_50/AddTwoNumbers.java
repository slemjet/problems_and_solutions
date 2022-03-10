package us.slemjet.leetcode.medium.tasks_1_50;

import java.util.Objects;

/**
 * 2. Add Two Numbers
 */
public class AddTwoNumbers {

    /**
     * Runtime: 73.45%
     * Memory Usage: 51.58%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode currentResult = result;
        int caryOver = 0;

        while (current1 != null || current2 != null || caryOver != 0) {
            int val1 = current1 != null ? current1.val : 0;
            int val2 = current2 != null ? current2.val : 0;
            int sum = val1 + val2 + caryOver;
            currentResult.val = sum % 10;
            caryOver = sum / 10;
            current1 = current1 != null ? current1.next : null;
            current2 = current2 != null ? current2.next : null;
            if (current1 != null || current2 != null || caryOver != 0) {
                currentResult.next = new ListNode(0);
                currentResult = currentResult.next;
            }
        }
        return result;
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
