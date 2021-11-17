package us.slemjet.leetcode.easy.from_201_to_250;

/**
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {

    /**
     * Runtime: 100.00%
     * Memory Usage: 71.04%
     */
    public ListNode reverseList(ListNode head) {

        ListNode first = head;
        ListNode newHead;

        // The idea is to keep track on the first element and prepend current to it while traversing lost
        while (head != null && head.next != null){
            newHead = head.next;
            head.next = head.next.next;
            newHead.next = first;
            first = newHead;
        }
        return first;
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
    }
}
