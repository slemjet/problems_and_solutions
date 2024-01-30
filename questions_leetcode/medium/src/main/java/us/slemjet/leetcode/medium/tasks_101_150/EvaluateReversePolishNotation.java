package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {

    /**
     * Time: O(n)   -> 78.23%
     * Space:O(n)   -> 68.63%
     */
    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        // Store current operands to be processed
        Stack<Integer> operands = new Stack<>();

        for (String token : tokens) {
            if (!("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))) {
                // It's a number - just push to process later
                operands.push(Integer.valueOf(token));
            } else {
                // It's an operation sign - get 2 operands and compute operation
                Integer operand2 = operands.pop();
                Integer operand1 = operands.pop();
                Integer result = switch (token) {
                    case "+" -> operand1 + operand2;
                    case "-" -> operand1 - operand2;
                    case "*" -> operand1 * operand2;
                    case "/" -> operand1 / operand2;
                    default -> 0;
                };
                operands.push(result);
            }
        }

        return operands.pop();
    }
}
