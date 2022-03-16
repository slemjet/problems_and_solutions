package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.Stack;

/**
 * 946. Validate Stack Sequences
 */
public class ValidateStackSequences {

    /**
     * Try simulation - push until can pop, pop as much as can, check if stack is empty
     *
     * Runtime: 66.35%
     * Memory Usage: 48.27%
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int poppedIdx = 0;
        for (int next : pushed) {
            stack.push(next);

            while (!stack.isEmpty() && stack.peek() == popped[poppedIdx]) {
                stack.pop();
                poppedIdx++;
            }
        }

        return stack.isEmpty();
    }
}
