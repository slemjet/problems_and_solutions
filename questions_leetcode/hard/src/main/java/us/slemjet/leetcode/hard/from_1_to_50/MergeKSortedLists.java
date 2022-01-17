package us.slemjet.leetcode.hard.from_1_to_50;

import us.slemjet.leetcode.hard.lists.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    // Merge with divide and conquer
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return divider(lists, 0, lists.length - 1);
    }

    private ListNode divider(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int median = left + (right - left) / 2;
        return merge(divider(lists, left, median), divider(lists, median + 1, right));
    }

    // Use priority queue with custom comparator
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        ListNode head = new ListNode(0); // dummy head mode
        ListNode next = head;

        // fill with nodes from the list
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
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

    // Merge with all nodes one by one
    public ListNode mergeKLists3(ListNode[] lists) {

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
            merged = merge(merged, lists[i]);
        }
        return merged;
    }

    private ListNode merge(ListNode first, ListNode second) {
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

    // Collect all the first elements and get min, which is added to the list. Shift node with min value to next.
    // Repeat until there are non-empty nodes in the list
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        ListNode merged = null;
        ListNode next = null;
        while (true) {
            int min = Integer.MAX_VALUE;
            int minNodeIndex = 0;
            boolean hasValue = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (min > lists[i].val) {
                        min = lists[i].val;
                        minNodeIndex = i;
                    }
                    hasValue = true;
                }
            }
            if (!hasValue) break;
            if (merged == null) {
                merged = new ListNode(min);
                next = merged;
            } else {
                next.next = new ListNode(min);
                next = next.next;
            }
            lists[minNodeIndex] = lists[minNodeIndex].next;
        }
        return merged;
    }
}
