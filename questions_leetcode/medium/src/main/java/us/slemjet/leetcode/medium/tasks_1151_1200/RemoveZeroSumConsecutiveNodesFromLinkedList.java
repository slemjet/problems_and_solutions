package us.slemjet.leetcode.medium.tasks_1151_1200;

import us.slemjet.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1171. Remove Zero Sum Consecutive Nodes from Linked List
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    /**
     * Time: O(n)   ->  89.13%
     * Space:O(n)   ->  72.73%
     */
    public ListNode removeZeroSumSublists(ListNode head) {

        Map<Integer, ListNode> prefixSums = new HashMap<>();
        int sum = 0;
        ListNode curr = new ListNode(0);
        ListNode root = curr;
        curr.next = head;
        while (curr != null) {
            sum += curr.val;
            prefixSums.put(sum, curr);
            curr = curr.next;
        }
        // After this step map value points to the latest node with this prefix sum
        // We iterate again, linking every node with prefix sum with the latest node from the map

        curr = root;
        sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (prefixSums.containsKey(sum)) {
                // Link node, collapsing everything between
                curr.next = prefixSums.get(sum).next;
            }
            curr = curr.next;
        }

        return root.next;
    }

    /**
     * Time: O(n)   ->  9.29%
     * Space:O(n)   ->  50.00%
     */
    public ListNode removeZeroSumSublists2(ListNode head) {
        Map<Integer, ListNode> prefixSums = new HashMap<>();
        Stack<Integer> prefixes = new Stack<>();
        int sum = 0;
        ListNode curr = new ListNode(0);
        ListNode root = curr;
        curr.next = head;
        while (curr != null) {
            sum += curr.val;
            if (prefixSums.containsKey(sum)) {
                // there is already node with this sum - this means that all nodes between them sum up to 0
                // We can remove them
                prefixSums.get(sum).next = curr.next;
                while (!prefixes.isEmpty() && prefixes.peek() != sum) {
                    prefixSums.remove(prefixes.pop()); // Remove inactive keys
                }
            }
            else {
                prefixes.push(sum);
                prefixSums.put(sum, curr);
            }
            curr = curr.next;
        }

        return root.next;
    }

}
