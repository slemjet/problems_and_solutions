package us.slemjet.leetcode.easy.tasks_1_50;

import us.slemjet.leetcode.common.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

    /**
     * Runtime: 100.00%
     * Memory Usage: 78.26%
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list2 == null ? list1 : list2;

        ListNode merged, current; // assign head node
        if (list2.val < list1.val) {
            current = merged = list2;
            list2 = list2.next;
        } else {
            current = merged = list1;
            list1 = list1.next;
        }

        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = null;
        return merged;
    }
}
