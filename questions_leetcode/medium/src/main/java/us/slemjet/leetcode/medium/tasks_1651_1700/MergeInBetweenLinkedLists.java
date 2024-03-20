package us.slemjet.leetcode.medium.tasks_1651_1700;

import us.slemjet.leetcode.common.ListNode;

/**
 * 1669. Merge In Between Linked Lists
 */
public class MergeInBetweenLinkedLists {

    /**
     * Time: O(n + m)   ->  40.65%
     * Space:O(1)       ->  44.30%
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode head = new ListNode(0, list1);

        int idx = 0;
        ListNode from = null;
        ListNode to = null;

        ListNode curr = head.next;
        // Find insertion points
        while (curr != null) {
            if (idx == a - 1) {
                from = curr;
            }
            if (idx - 1 == b) {
                to = curr;
                break;
            }
            curr = curr.next;
            idx++;
        }

        // Insert second list
        from.next = list2;

        curr = list2;
        while (curr != null) {
            if (curr.next == null) {
                curr.next = to;
                break;
            }
            curr = curr.next;
        }

        return head.next;
    }
}
