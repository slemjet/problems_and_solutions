package us.slemjet.leetcode.medium.tasks_1251_1300;

import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 */
public class MinimumRemoveToMakeValidParentheses {

    /**
     *
     */
    public String minRemoveToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();
        int openedBrackets = 0;
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (aChar == '(') openedBrackets++;
            else if (aChar == ')') {
                openedBrackets--;
                if (openedBrackets < 0) {
                    openedBrackets = 0;
                    continue;
                }
            }
            stack.push(aChar);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.append(stack.pop());
        s = result.reverse().toString();

        openedBrackets = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char aChar = s.charAt(i);
            if (aChar == ')') openedBrackets++;
            else if (aChar == '(') {
                openedBrackets--;
                if (openedBrackets < 0) {
                    openedBrackets = 0;
                    continue;
                }
            }
            stack.push(aChar);
        }

        result = new StringBuilder();
        while (!stack.isEmpty()) result.append(stack.pop());
        s = result.toString();

        return s;
    }
}
