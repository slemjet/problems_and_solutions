package us.slemjet.leetcode.easy.tasks_851_900;

import us.slemjet.leetcode.common.ListNode;

/**
 * 876. Middle of the Linked List
 */
public class MiddleOfTheLinkedList {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  46.14%
     */
    public ListNode middleNode(ListNode head) {

        ListNode mid = head;
        while (head != null && head.next != null) {
            head = head.next.next;
            mid = mid.next;
        }

        return mid;
    }
}
