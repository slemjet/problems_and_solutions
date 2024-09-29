package us.slemjet.leetcode.medium.tasks_601_650;

/**
 * 641. Design Circular Deque
 * <p/>
 * Time:    -> 37.42%
 * Space:   -> 61.82%
 */
public class DesignCircularDeque {
    private int currSize;
    private int size;
    private Node head;
    private Node tail;

    public DesignCircularDeque(int k) {
        this.size = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value, null, head);
        if (isEmpty()) {
            head = tail = newNode;
            head.next = head.prev = newNode;
        } else {
            head.prev = newNode;
            tail.next = newNode;
            newNode.prev = tail;
            head = newNode;
        }
        currSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value, tail, null);
        if (isEmpty()) {
            head = tail = newNode;
            head.next = head.prev = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
        currSize++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (currSize == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        currSize--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (currSize == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        currSize--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return head.value;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return tail.value;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return size == currSize;
    }

    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
