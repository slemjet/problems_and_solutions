package us.slemjet.leetcode.add_two_numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode currentResult = result;
        int caryOver = 0;

        while (true) {
            int val1 = current1 != null ? current1.val : 0;
            int val2 = current2 != null ? current2.val : 0;
            int sum = val1 + val2 + caryOver;
            currentResult.val = sum % 10;
            caryOver = sum / 10;
            current1 = current1 != null ? current1.next : null;
            current2 = current2 != null ? current2.next : null;
            if (current1 == null && current2 == null && caryOver == 0) {
                break;
            } else {
                currentResult.next = new ListNode(0);
                currentResult = currentResult.next;
            }
        }
        return result;
    }

}