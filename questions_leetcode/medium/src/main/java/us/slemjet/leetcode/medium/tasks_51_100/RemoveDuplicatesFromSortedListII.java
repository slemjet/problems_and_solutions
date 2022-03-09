package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.Objects;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * Runtime: 77.24%
     * Memory Usage: 30.33%
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(0, head);

        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            // prev.next -> current
            // prev.next.next -> next
            if (prev.next.val == prev.next.next.val) {
                int duplicateValue = prev.next.val;
                ListNode nextNode = prev.next.next.next;
                while (nextNode != null && nextNode.val == duplicateValue) nextNode = nextNode.next;
                prev.next = nextNode;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
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
