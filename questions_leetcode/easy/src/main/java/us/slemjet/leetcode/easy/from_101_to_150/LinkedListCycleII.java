package us.slemjet.leetcode.easy.from_101_to_150;

/**
 * 142. Linked List Cycle II
 */
public class LinkedListCycleII {

    /**
     * Make 2 pointers fast and slow meet (if there is a cycle) - they meet exactly at the distance from head to the loop entrance
     * After start again 2 pointers with the same speed -> they meet at the cycle beginning
     *
     * Runtime: 100.00%
     * Memory Usage: 71.79%
     */
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        // If slower iterator catches faster - there is a loop
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // Use his node to start a new traversal from start
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2; // Meeting point - entry to the loop
            }
        }
        return null;
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
