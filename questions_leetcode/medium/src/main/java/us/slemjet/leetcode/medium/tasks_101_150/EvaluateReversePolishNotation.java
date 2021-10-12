package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {

    /**
     * Runtime: 89.38%
     * Memory Usage: 59.79%
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> operands = new Stack<>();
        int idx = 0;
        while (idx < tokens.length) {
            String token = tokens[idx++];
            if (!"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token)) {
                operands.push(Integer.valueOf(token));
            } else {
                Integer operand2 = operands.pop();
                Integer operand1 = operands.pop();
                switch (token) {
                    case "+":
                        operands.push(operand1 + operand2);
                        break;
                    case "-":
                        operands.push(operand1 - operand2);
                        break;
                    case "*":
                        operands.push(operand1 * operand2);
                        break;
                    case "/":
                        operands.push(operand1 / operand2);
                        break;
                }
            }
        }

        return operands.pop();
    }
}
