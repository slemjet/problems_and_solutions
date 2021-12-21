package us.slemjet.leetcode.hard.from_251_to_300;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 */
public class FindMedianFromDataStream {

    /**
     * 2 Heaps
     * <p>
     * Runtime: 41.64%
     * Memory Usage: 29.00%
     */
    public static class MedianFinder {

        PriorityQueue<Integer> smaller;
        PriorityQueue<Integer> larger;

        public MedianFinder() {
            smaller = new PriorityQueue<>();
            larger = new PriorityQueue<>(Comparator.reverseOrder()); // Reversed so latest is min
        }

        public void addNum(int num) {
            smaller.offer(num);
            larger.offer(smaller.poll());
            if (larger.size() > smaller.size()) {
                smaller.offer(larger.poll()); // Rebalance
            }
        }

        public double findMedian() {
            if (larger.size() == smaller.size()) {
                return ((double) larger.peek() + (double) smaller.peek()) / 2;
            } else {
                return (double) smaller.peek();
            }
        }
    }

    /**
     * Use BST approach
     *
     * Exceeds time limit
     */
    public static class MedianFinderBst {

        private Node root;
        private Node medianLeft;
        private Node medianRight;
        private int size;

        public MedianFinderBst() {
        }

        // Adds a number into the data structure.
        public void addNum(int num) {
            if (root == null) {
                root = new Node(num);
                medianLeft = root;
                medianRight = root;
            } else {
                root.addNode(num);
                if (size % 2 == 0) {
                    if (num < medianLeft.value) {
                        medianRight = medianLeft;
                    } else if (medianLeft.value <= num && num < medianRight.value) {
                        medianLeft = medianLeft.successor();
                        medianRight = medianRight.predecessor();
                    } else if (medianRight.value <= num) {
                        medianLeft = medianRight;
                    }
                } else {
                    if (num < medianLeft.value) {
                        medianLeft = medianLeft.predecessor();
                    } else {
                        medianRight = medianRight.successor();
                    }
                }
            }
            size++;
        }

        // Returns the median of current data stream
        public double findMedian() {
            return (medianLeft.value + medianRight.value) / 2.0;
        }

        class Node {
            private Node parent;
            private Node left;
            private Node right;
            private int value;

            public Node(int value) {
                this.value = value;
            }

            public void addNode(int value) {
                if (value >= this.value) {
                    if (right == null) {
                        right = new Node(value);
                        right.parent = this;
                    } else
                        right.addNode(value);
                } else {
                    if (left == null) {
                        left = new Node(value);
                        left.parent = this;
                    } else
                        left.addNode(value);
                }
            }

            public Node predecessor() {
                if (left != null)
                    return left.rightMost();

                Node predecessor = parent;
                Node child = this;

                while (predecessor != null && child != predecessor.right) {
                    child = predecessor;
                    predecessor = predecessor.parent;
                }

                return predecessor;
            }

            public Node successor() {
                if (right != null)
                    return right.leftMost();

                Node successor = parent;
                Node child = this;

                while (successor != null && child != successor.left) {
                    child = successor;
                    successor = successor.parent;
                }

                return successor;
            }

            public Node leftMost() {
                if (left == null)
                    return this;
                else
                    return left.leftMost();
            }

            private Node rightMost() {
                if (right == null)
                    return this;
                else
                    return right.rightMost();
            }
        }
    }
}
