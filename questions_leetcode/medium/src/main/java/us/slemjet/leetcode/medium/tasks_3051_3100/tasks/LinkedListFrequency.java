package us.slemjet.leetcode.medium.tasks_3051_3100.tasks;

import us.slemjet.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3063. Linked List Frequency
 */
public class LinkedListFrequency {

    /**
     * Time: O(n)   ->  90.28%
     * Space:O(n)   ->  100.00%
     */
    public ListNode frequenciesOfElements(ListNode head) {

        Map<Integer, ListNode> countsByValue = new HashMap<>();

        while (head != null){
            countsByValue.computeIfAbsent(head.val, k -> new ListNode(0)).val++;
            head = head.next;
        }

        ListNode result = new ListNode(0);
        ListNode current = result;

        for (ListNode count : countsByValue.values()){
            current.next = count;
            current = current.next;
        }

        return result.next;
    }
}
