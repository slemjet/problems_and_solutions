package us.slemjet.leetcode.medium.tasks_51_100;

import us.slemjet.leetcode.common.ListNode;

/**
 * 92. Reverse Linked List II
 */
public class ReverseLinkedListII {

    /**
     * Time:    ->  65.04% ->   O(n)
     * Space:   ->  76.83% ->   O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int idx = 0;
        ListNode curr = dummy;

        while (idx < left - 1) {
            curr = curr.next;
            idx++;
        }

        // Need to reverse after this node
        head = curr;
        curr = curr.next;
        idx++;

        while (idx < right) {
            // Move node from end to beginning
            ListNode next = curr.next;

            curr.next = next.next;
            next.next = head.next;
            head.next = next;

            idx++;
        }

        return dummy.next;
    }
}
