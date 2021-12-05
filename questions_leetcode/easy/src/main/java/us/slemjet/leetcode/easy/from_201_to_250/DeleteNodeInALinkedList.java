package us.slemjet.leetcode.easy.from_201_to_250;

/**
 * 237. Delete Node in a Linked List
 */
public class DeleteNodeInALinkedList {

    /**
     * Runtime: 100.00%
     * Memory Usage: 84.47%
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
