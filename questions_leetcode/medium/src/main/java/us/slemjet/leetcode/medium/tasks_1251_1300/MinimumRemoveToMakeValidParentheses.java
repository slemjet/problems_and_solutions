package us.slemjet.leetcode.medium.tasks_1251_1300;

import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 */
public class MinimumRemoveToMakeValidParentheses {

    /**
     * Runtime: 29.15%
     * Memory Usage: 32.29%
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.length(); ++i) {
            if (result.charAt(i) == '(') stack.add(i);
            if (result.charAt(i) == ')') {
                if (!stack.empty()) stack.pop();
                else result.setCharAt(i, '*');
            }
        }
        while (!stack.empty()) result.setCharAt(stack.pop(), '*');
        return result.toString().replaceAll("\\*", "");
    }

    /**
     * Runtime: 6.99%
     * Memory Usage: 5.01%
     */
    public String minRemoveToMakeValid2(String s) {

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
