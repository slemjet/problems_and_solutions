package us.slemjet.leetcode.easy.from_201_to_250;

/**
 * 234. Palindrome Linked List
 */
public class PalindromeLinkedList {

    /**
     * Runtime: 98.00%
     * Memory Usage: 34.31%
     */
    public boolean isPalindrome(ListNode head) {

        ListNode reversed = head != null ? new ListNode(head.val) : null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                reversed = new ListNode(slow.val, reversed);
                fast = fast.next;
            }
        }

        while (slow != null) {
            if (slow.val != reversed.val) return false;

            slow = slow.next;
            reversed = reversed.next;
        }

        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
