package us.slemjet.leetcode.hard.from_201_to_250;

import java.util.Stack;

/**
 * 224. Basic Calculator
 */
public class BasicCalculator {

    /**
     * Store previous block result + sign in stack
     * Runtime: 51.48%
     * Memory Usage: 31.03%
     */
    public int calculate(String s) {

        // Store blocks of code between brackets '(' ')'
        Stack<Integer> stored = new Stack<>();

        int result = 0;
        int value = 0;
        int sign = 1; // '+' -> 1; '-' -> -1

        for (char aChar : s.toCharArray()) {
            if (Character.isDigit(aChar)) {
                // Next digit
                value = value * 10 + aChar - '0';
            } else if (aChar == '+') {
                // Next operand - end of previous  value -> need to calculate operation
                result += sign * value;
                sign = 1;
                value = 0;
            } else if (aChar == '-') {
                // Next operand - end of previous  value -> need to calculate operation
                result += sign * value;
                sign = -1;
                value = 0;
            } else if (aChar == '(') {
                // Store current state sign + result
                stored.push(result);
                stored.push(sign);
                // Reset since we begin a new block
                result = 0;
                sign = 1;
            } else if (aChar == ')') {
                result += sign * value;
                value = 0;
                // Add previously stored state sign * result
                Integer storedSign = stored.pop();
                Integer storedResult = stored.pop();
                result = storedSign * result + storedResult;
            }
        }

        if (value != 0) {
            // There is a remaining value - need to process it
            result += sign * value;
        }

        return result;
    }

    /**
     * Store only sign in stack
     *
     * Runtime: 89.45%
     * Memory Usage: 97.20%
     */
    public int calculateSignOnly(String s) {
        if (s == null) return 0;

        int result = 0;
        int value = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(sign); // Initial sign is +

        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);

            if (aChar >= '0' && aChar <= '9') {
                // If is number - add
                value = value * 10 + (aChar - '0');
            } else if (aChar == '+' || aChar == '-') {
                result += sign * value;
                // Consider previous block sign - before parenthesis
                sign = stack.peek() * (aChar == '+' ? 1 : -1);
                value = 0;
            } else if (aChar == '(') {
                // Add previous block sign to stack
                stack.push(sign);
            } else if (aChar == ')') {
                stack.pop();
            }
        }

        result += sign * value;
        return result;
    }
}
