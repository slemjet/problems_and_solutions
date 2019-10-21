package us.slemjet.leetcode.hard.lists;

public class ListNode {
    public  int val;
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
}
