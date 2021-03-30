package us.slemjet.leetcode.medium.from_1_to_50;

import us.slemjet.leetcode.hard.lists.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode currentHead = dummyHead;

        while (currentHead != null && currentHead.next != null && currentHead.next.next != null) {
            ListNode first = currentHead.next;
            ListNode second = currentHead.next.next;

            first.next = second.next; // 1 -> 3
            second.next = first; // 2 -> 1
            currentHead.next = second; // head -> 2

            currentHead = first;
        }
        return dummyHead.next;
    }
}
