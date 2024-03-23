package us.slemjet.leetcode.medium.tasks_101_150;

import us.slemjet.leetcode.common.ListNode;

/**
 * 143. Reorder List
 */
public class ReorderList {

    /**
     * Time: O(n)   ->  88.69%
     * Space:O(1)   ->  74.69%
     */
    public void reorderList(ListNode head) {

        // Find middle node
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = head;

        while (fast != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        prevSlow.next = null;

        // slow is the middle node. We need to reverse nodes after middle
        ListNode tail = slow;
        ListNode newTail;

        while (slow != null && slow.next != null) {
            newTail = slow.next;
            slow.next = slow.next.next;
            newTail.next = tail;
            tail = newTail;
        }

        // merge lists
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = tail;
            head = nextHead;
            if (tail != null) {
                ListNode nextTail = tail.next;
                tail.next = head;
                tail = nextTail;
            }
        }
    }
}
