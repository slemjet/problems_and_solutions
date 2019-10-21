package us.slemjet.leetcode.easy.lists;

import us.slemjet.leetcode.hard.lists.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l2 == null ? l1 : l2;

        ListNode merged, current; // assign head node
        if (l2.val < l1.val) {
            current = merged = l2;
            l2 = l2.next;
        } else {
            current = merged = l1;
            l1 = l1.next;
        }

        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = null;
        return merged;
    }
}
