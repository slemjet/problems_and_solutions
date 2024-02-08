package us.slemjet.leetcode.common;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode of(int... values) {
        if (values != null && values.length > 0) {
            ListNode result, node;
            node = result = new ListNode(values[0]);
            for (int i = 1; i < values.length; i++) {
                node.next = new ListNode(values[i]);
                node = node.next;
            }
            return result;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return val + " -> " + (next == null ? "null" : next.toString());
    }
}
