package us.slemjet.leetcode.hard.lists;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previous = dummy;
        ListNode current = dummy.next;

        int i = 0;
        while (current != null) {
            i++;
            if (i % k == 0) { // Found k-th node
                previous = reverseNodeHeads(previous, current);
                current = previous.next;
            } else
                current = current.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = new ListNode(0);
        dummyHead.next.next = head;
        ListNode currentHead = dummyHead.next;

        while (currentHead.next != null) {
            // find k-th node
            int i = k;
            ListNode kthNodeHead = currentHead;

            while (kthNodeHead != null && i > 0) {
                kthNodeHead = kthNodeHead.next;
                i--;
            }

            if (i > 0 || kthNodeHead == null)
                break; // skip as group is not complete

            currentHead = reverseNodeHeads(currentHead, kthNodeHead);
        }
        return dummyHead.next.next;
    }

    private ListNode reverseNodeHeads(ListNode start, ListNode end) {
        ListNode tail = end.next;
        end.next = null;

        ListNode node = start.next;
        while (node.next != null) {
            ListNode next = node.next; // grab next node
            node.next = next.next; // exclude next node
            next.next = null; // clear next node tail

            ListNode prevHead = start.next;
            start.next = next; // set next node as new head
            next.next = prevHead; // add prev head as next
        }
        node.next = tail;
        return node;
    }
}