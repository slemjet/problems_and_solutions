package us.slemjet.leetcode.medium.tasks_851_900;

import java.util.Stack;

/**
 * 856. Score of Parentheses
 */
public class ScoreOfParentheses {

    /**
     * Keep track on the current level value and add nodes wit that value
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 83.17%
     */
    public int scoreOfParentheses(String s) {

        int result = 0;
        int level = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // String is balanced so there will be next
                if (s.charAt(i + 1) == '(') {
                    // level increase
                    level = level << 1;
                } else {
                    // '()' scenario - add node at level
                    result += level;
                    i++;
                }
            } else {
                // Level is decreased
                level = level >> 1;
            }
        }

        return result;
    }

    /**
     * Use stack to keep track of added nodes
     * Runtime: 68.63%
     * Memory Usage: 7.15%
     */
    public int scoreOfParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();
        int value = 0;

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '(') {
                // Add current value to the stack since we have opening bracket
                stack.push(value);
                value = 0;
            } else {
                // Remove value from stack as per closing bracket
                value = stack.pop() + Math.max(1, 2 * value); // 1 is for empty parenthesis case '()'
            }
        }
        return value;
    }
}
