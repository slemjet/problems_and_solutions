package us.slemjet.leetcode.easy.tasks_201_250;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 */
public class ImplementQueueUsingStacks {

    /**
     * Amortized version - re-order stacks only once per value - when output stack becomes empty
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 88.38%
     */
    static class MyQueueAmortized {

        private final Stack<Integer> outStack; // Contains elements in reversed order - ready to be sent out
        private final Stack<Integer> inStack; // Contains elements as they come in

        public MyQueueAmortized() {
            outStack = new Stack<>();
            inStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) { // Need to move values from in to out stack
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) { // Need to move values from in to out stack
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return outStack.empty() && inStack.empty();
        }
    }

    /**
     * Basic version - re-order stacks on each input
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 8.83%
     */
    static class MyQueueBasic {

        private final Stack<Integer> container;
        private final Stack<Integer> temp;

        public MyQueueBasic() {
            container = new Stack<>();
            temp = new Stack<>();
        }

        public void push(int x) {
            while (!container.isEmpty()) {
                temp.push(container.pop());
            }
            temp.push(x);
            while (!temp.isEmpty()) {
                container.push(temp.pop());
            }
        }

        public int pop() {
            return container.pop();
        }

        public int peek() {
            return container.peek();
        }

        public boolean empty() {
            return container.empty();
        }
    }
}
