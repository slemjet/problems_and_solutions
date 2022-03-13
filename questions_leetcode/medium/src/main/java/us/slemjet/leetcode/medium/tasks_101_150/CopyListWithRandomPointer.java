package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.HashMap;
import java.util.Map;
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

    /**
     * Runtime: 41.57%
     * Memory Usage: 21.75%
     */
    public Node copyRandomListMap(Node head) {

        Map<Node, Node> copies = new HashMap<>();

        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node current = dummyHead;
        while (current != null) {
            Node next = current.next;
            if (next != null) {
                Node copyNext = copies.get(next);
                if (copyNext == null) {
                    copyNext = new Node(next.val);
                    if (copyNext.random == null) {
                        copyNext.random = next.random;
                        copies.put(next, copyNext);
                    }
                }
                current.next = copyNext;
            }

            Node random = current.random;
            if (random != null) {
                Node copyRandom = copies.get(random);
                if (copyRandom == null) {
                    copyRandom = new Node(random.val);
                    copies.put(random, copyRandom);
                }
                current.random = copyRandom;
            }

            current = current.next;
            if (next != null) {
                current.next = next.next;
                current.random = next.random;
            }
        }

        return dummyHead.next;
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

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
