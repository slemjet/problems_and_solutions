package us.slemjet.leetcode.medium.arrays.add_two_numbers;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return " " + val + (next != null ? next : "");
    }
}
