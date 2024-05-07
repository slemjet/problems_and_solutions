package us.slemjet.leetcode.medium.tasks_2451_2500;

import us.slemjet.leetcode.common.ListNode;

import java.util.Stack;

/**
 * 2487. Remove Nodes From Linked List
 */
public class RemoveNodesFromLinkedList {

    /**
     * Use monotonous stack
     * Time: O(n)  ->  16.27%
     * Space:O(n)  ->  91.65%
     */
    public ListNode removeNodesStack(ListNode head) {

        Stack<ListNode> nodes = new Stack<>();

        while (head != null) {

            while (!nodes.isEmpty() && nodes.peek().val < head.val) {
                nodes.pop();
            }
            nodes.push(head);

            head = head.next;
        }

        head = new ListNode(0);

        while (!nodes.isEmpty()) {
            ListNode prevNext = head.next;
            head.next = nodes.pop();
            head.next.next = prevNext;
        }

        return head.next;
    }

    /**
     * Time: O(n)  ->  41.14%
     * Space:O(n)  ->  24.70%
     *
     */
    public ListNode removeNodesRecursion(ListNode head) {

        if (head == null || head.next == null) {
            // base scenario
            return head;
        }

        // Calculate next node
        ListNode next = removeNodesRecursion(head.next);

        if (next.val > head.val) {
            // Replace current head
            return next;
        }

        // Switch to new next node
        head.next = next;
        return head;
    }
}
