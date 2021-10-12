package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.Objects;

/**
 * 138. Copy List with Random Pointer
 */
public class CopyListWithRandomPointer {

    /**
     * Runtime: 100.00%
     * Memory Usage: 84.78%
     */
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node originalHead = head;
        // Add copy node after each node
        while (head != null) {
            Node copy = new Node(head.val);
            copy.next = head.next;
            head.next = copy;
            head = copy.next;
        }

        head = originalHead;
        // Update random reference to copy
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        Node copyHead = originalHead.next;
        head = originalHead;
        // Restore original list and extract copy
        while (head != null) {
            Node copyNext = head.next;
            Node headNext = head.next.next;
            head.next = headNext;
            if (headNext != null)
                copyNext.next = headNext.next;
            head = headNext;
        }

        return copyHead;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
