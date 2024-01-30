package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.Arrays;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {

    /**
     * Time: O(n)   -> 99.11%
     * Space:O(n)   -> 68.63%
     */
    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        // Store current operands to be processed
        Stack<Integer> operands = new Stack<>();

        Arrays.stream(tokens).forEach(token -> {
                    Integer result = switch (token) {
                        case "+" -> {
                            Integer operand2 = operands.pop();
                            Integer operand1 = operands.pop();
                            yield operand1 + operand2;
                        }
                        case "-" -> {
                            Integer operand2 = operands.pop();
                            Integer operand1 = operands.pop();
                            yield operand1 - operand2;
                        }
                        case "*" -> {
                            Integer operand2 = operands.pop();
                            Integer operand1 = operands.pop();
                            yield operand1 * operand2;
                        }
                        case "/" -> {
                            Integer operand2 = operands.pop();
                            Integer operand1 = operands.pop();
                            yield operand1 / operand2;
                        }
                        // It's a number - just add for future processing
                        default -> Integer.valueOf(token);
                    };

                    operands.push(result);
                }
        );

        return operands.pop();
    }
}
