package us.slemjet.leetcode.medium.lists;

import us.slemjet.leetcode.hard.lists.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null)
            return null;
        // We use 2 pointers technique. One(prev) will be shifted from another(node) by n(input)
        ListNode prev = head;
        ListNode node = head;
        int index = 0;

        while (node != null) {
            if (index > n) // start incrementing once  i - n-th node is reached
                prev = prev.next; // increment shifted Node

            node = node.next;
            index++;
        }

        if (index == n)
            return head.next; // remove head case

        prev.next = prev.next.next; // remove n-th from end
        return head;
    }
}
