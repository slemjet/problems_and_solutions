package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.ArrayDeque;
import java.util.Objects;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * Using next node
     * Runtime: 100.00%
     * Memory Usage: 82.64%
     */
    public Node connect(Node root) {
        if (root == null) return root;

        Node head = root;
        Node nextHead = null;

        while (head != null) {

            if (head.left != null) {
                head.left.next = head.right; // Link left to right

                if (nextHead == null) {
                    nextHead = head.left; // Set next level start
                }
            }

            if (head.next != null) {
                if (head.right != null) {
                    head.right.next = head.next.left; // Link right to left
                }
                head = head.next;
            } else {
                head = nextHead; // Switch to next level
                nextHead = null;
            }
        }

        return root;
    }

    /**
     * Double queue
     * Runtime: 41.39%
     * Memory Usage: 97.56%
     */
    public Node connectDoubleQueues(Node root) {
        if (root == null) return root;

        ArrayDeque<Node> nodes = new ArrayDeque<>();
        ArrayDeque<Node> nextNodes = new ArrayDeque<>();
        ArrayDeque<Node> tmp = null;

        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node next = null;
            while (!nodes.isEmpty()) {
                Node pop = nodes.pollLast();
                pop.next = next;
                next = pop;
                if (pop.right != null)
                    nextNodes.offerFirst(pop.right);
                if (pop.left != null)
                    nextNodes.offerFirst(pop.left);
            }

            tmp = nextNodes;
            nextNodes = nodes;
            nodes = tmp;
        }

        return root;
    }

    /**
     * Single queue
     * Runtime: 10.02%
     * Memory Usage:92.26%
     */
    public Node connectSingleQueue(Node root) {
        if (root == null) return root;

        ArrayDeque<Node> tmp = new ArrayDeque<>();
        tmp.push(root);
        int counter = 0;
        int nextLevel = 1;
        while (!tmp.isEmpty()) {
            Node last = tmp.pollLast();
            counter++;
            if (counter != nextLevel && !tmp.isEmpty() && tmp.peekLast() != null) {
                Node prev = tmp.peekLast();
                prev.next = last;
            }

            if (counter == nextLevel) {
                nextLevel *= 2;
                counter = 0;
            }

            if (last.right != null)
                tmp.offerFirst(last.right);
            if (last.left != null)
                tmp.offerFirst(last.left);
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right, next);
        }
    }
}
