package us.slemjet.leetcode.easy.from_101_to_150;

/**
 * 141. Linked List Cycle
 */
public class LinkedListCycle {

    /**
     * Runtime: 100.00%
     * Memory Usage: 45.39%
     */
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        // If slower iterator catches faster - there is a loop
        while (fast != null) {
            if (fast.next == null || fast.next.next == null || fast.next.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
