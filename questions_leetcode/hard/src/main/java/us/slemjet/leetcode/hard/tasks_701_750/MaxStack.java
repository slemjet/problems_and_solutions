package us.slemjet.leetcode.hard.tasks_701_750;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 716. Max Stack
 * tags: Linkedin
 *
 * Time: O(nlogn)   ->  5.20%
 * Space:O(n)       ->  15.73%
 */
public class MaxStack {

    TreeSet<Node> stack;
    TreeSet<Node> orderedValues;
    int nextId;

    public MaxStack() {
        stack = new TreeSet<>(Comparator.comparingInt((Node node) -> node.id).thenComparingInt(node -> node.val));
        orderedValues = new TreeSet<>(Comparator.comparingInt((Node node) -> node.val).thenComparingInt(node -> node.id));
        nextId = 0;
    }

    public void push(int x) {
        Node newNode = new Node(nextId++, x);
        stack.add(newNode);
        orderedValues.add(newNode);
    }

    public int pop() {
        Node lastNode = stack.pollLast();
        orderedValues.remove(lastNode);
        return lastNode.val;
    }

    public int top() {
        return stack.last().val;
    }

    public int peekMax() {
        return orderedValues.last().val;
    }

    public int popMax() {
        Node maxValNode = orderedValues.pollLast();
        stack.remove(maxValNode);
        return maxValNode.val;
    }

    static class Node {

        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        int id;
        int val;
    }
}
