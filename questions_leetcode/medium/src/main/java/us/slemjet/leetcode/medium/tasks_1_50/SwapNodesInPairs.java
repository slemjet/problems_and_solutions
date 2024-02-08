package us.slemjet.leetcode.medium.tasks_1_50;


import us.slemjet.leetcode.common.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {

    /**
     * Runtime: 100.00%
     * Memory Usage: 30.86%
     */
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
