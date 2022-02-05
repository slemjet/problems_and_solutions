package us.slemjet.leetcode.hard.from_1_to_50;

import us.slemjet.leetcode.hard.lists.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 */
public class MergeKSortedLists {

    /**
     * Merge with Divide and Conquer approach
     * <p>
     * Runtime: 94.42%
     * Memory Usage: 5.33%
     */
    public ListNode mergeKListsDivAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return divider(lists, 0, lists.length - 1);
    }

    private ListNode divider(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int median = left + (right - left) / 2;
        return mergeTwoLists(divider(lists, left, median), divider(lists, median + 1, right));
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null || second == null)
            return first == null ? second : first;

        ListNode merged = new ListNode(0);
        ListNode next = merged;
        while (first != null || second != null) {
            if (second == null || (first != null && first.val < second.val)) {
                next.next = first;
                first = first.next;
            } else {
                next.next = second;
                second = second.next;
            }
            next = next.next;
        }
        return merged.next;
    }

    /**
     * Merge sequentially one by one to the merged list
     * <p>
     * Runtime: 7.10%
     * Memory Usage: 10.34%
     */
    public ListNode mergeKListsSequentialMerge(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        ListNode merged = lists[0];
        for (int i = 1; i < lists.length; i++) {
            if (merged == null) {
                merged = lists[i];
                continue;
            }
            merged = mergeTwoLists(merged, lists[i]);
        }
        return merged;
    }

    /**
     * PriorityQueue with custom comparator
     * <p>
     * Runtime: 30.16%
     * Memory Usage: 12.28%
     */
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode head = new ListNode(0); // dummy head mode
        ListNode next = head;

        // fill with nodes from the list
        for (ListNode list : lists) {
            ListNode node = list;
            while (node != null) {
                queue.add(node); // Fill with all the "next" nodes
                node = node.next;
            }
        }

        while (!queue.isEmpty()) {
            next.next = queue.poll();
            next = next.next;
        }

        next.next = null;
        return head.next;
    }

    /**
     * Runtime: 33.72%
     * Memory Usage: 5.33%
     */
    public ListNode mergeKListsPriorityQueue2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode head = new ListNode(0); // dummy head mode
        ListNode next = head;

        // fill with nodes from the list
        for (ListNode node : lists) {
            if (node != null) queue.offer(node);
        }

        while (!queue.isEmpty()) {
            next.next = queue.poll();
            next = next.next;
            if (next.next != null) queue.offer(next.next);
        }

        return head.next;
    }
}
