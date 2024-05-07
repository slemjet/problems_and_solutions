package us.slemjet.leetcode.medium.tasks_2801_2850;

import us.slemjet.leetcode.common.ListNode;

import java.util.Stack;

/**
 * 2816. Double a Number Represented as a Linked List
 */
public class DoubleANumberRepresentedAsALinkedList {

    /**
     * Time: O(n)   ->  21.31%
     * Space:O(n)   ->  97.25%
     */
    public ListNode doubleItStack(ListNode head) {

        Stack<ListNode> nodes = new Stack<>();

        // Push to stack
        ListNode curr = head;
        while (curr != null) {
            nodes.push(curr);
            curr = curr.next;
        }

        // Double all values + keep track on carry value
        int carry = 0;
        while (!nodes.isEmpty()) {
            curr = nodes.pop();
            int newVal = curr.val * 2 + carry;
            curr.val = newVal % 10;
            carry = newVal / 10;
        }

        if (carry != 0) {
            // If carry value -> prepend new head node
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    /**
     * Double reverse
     * Time: O(n)   ->  51.55%
     * Space:O(1)   ->  26.46%
     */
    public ListNode doubleItDoubleReverse(ListNode head) {

        // Reverse list
        ListNode first = reverseList(head);

        // Double each node value
        int carry = 0;
        ListNode last = first;
        while (last != null) {
            int doubled = last.val * 2 + carry;
            last.val = doubled % 10;
            carry = doubled / 10;
            if (last.next == null) {
                break;
            }
            last = last.next;
        }

        // Add extra node for carry value
        if (carry != 0) {
            last.next = new ListNode(carry);
        }

        // Reverse again
        head = reverseList(first);

        return head;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode newHead;

        // Reverse List
        while (head != null && head.next != null) {
            newHead = head.next;
            head.next = head.next.next;
            newHead.next = first;
            first = newHead;
        }
        return first;
    }
}
