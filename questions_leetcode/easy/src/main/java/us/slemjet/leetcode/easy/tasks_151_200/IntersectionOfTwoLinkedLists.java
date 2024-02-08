package us.slemjet.leetcode.easy.tasks_151_200;

/**
 * 160. Intersection of Two Linked Lists
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * Runtime: 98.61%
     * Memory Usage: 96.11%
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Get difference in length
        int aShift = 0;
        int bShift = 0;

        ListNode a = headA;
        ListNode b = headB;

        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }

        while (a != null) {
            a = a.next;
            aShift++;
        }

        while (b != null) {
            b = b.next;
            bShift++;
        }

        // Use shift to have lists of same length
        while (aShift > 0) {
            aShift--;
            headA = headA.next;
        }

        while (bShift > 0) {
            bShift--;
            headB = headB.next;
        }

        // Find common element
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
