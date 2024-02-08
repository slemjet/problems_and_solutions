package us.slemjet.leetcode.easy.tasks_151_200;

/**
 * 155. Min Stack
 *
 * Runtime: 32.83%
 * Memory Usage:37.60%
 */
class MinStack {

    private Node head;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            // Use previous node min value to calculate new node min value -> we don't need to track node with the actual min value
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int value;
        int min;
        Node next;

        public Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
