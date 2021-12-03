package us.slemjet.leetcode.medium.tasks_201_250;


import java.util.ArrayDeque;
import java.util.Objects;

/**
 * 227. Basic Calculator II
 */
public class BasicCalculatorII {

    /**
     * Runtime: 93.88%
     * Memory Usage: 94.09%
     */
    public int calculate(String s) {

        int result = 0;
        int curr = 0;
        int prev = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (Character.isWhitespace(aChar))
                continue;

            if (Character.isDigit(aChar)) {
                // Next digit of current value
                curr = curr * 10 + Character.getNumericValue(aChar);
            } else {
                if (sign == '+') { // for '+' and '-' We just shift values without immediate execution
                    result += prev;
                    prev = curr;
                } else if (sign == '-') {
                    result += prev;
                    prev = -curr;
                } else if (sign == '*') { // '*' and '/' have precedence and are executed immediately
                    prev = prev * curr;
                } else if (sign == '/') {
                    prev = prev / curr;
                }
                sign = aChar;
                curr = 0;
            }
        }

        // Post - process last operation
        if (sign == '+') {
            result += prev + curr;
        } else if (sign == '-') {
            result += prev - curr;
        } else if (sign == '*') {
            result += prev * curr;
        } else if (sign == '/') {
            result += prev / curr;
        }
        return result;
    }

    /**
     * Runtime: 37.98% of Java online submissions for Basic Calculator II.
     * Memory Usage: 9.30% of Java online submissions for Basic Calculator II.
     */
    public int calculate2(String s) {

        int result = 0;

        ArrayDeque<String> items = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') items.add("+");
            else if (c == '-') items.add("-");
            else if (c == '*' || c == '/') {
                // get next number
                StringBuilder numberStr = new StringBuilder();
                while (i < s.length() - 1) {
                    char nextChar = s.charAt(i + 1);
                    if (Character.isDigit(nextChar)) {
                        i++;
                        numberStr.append(s.charAt(i));
                    } else if (nextChar == '*' || nextChar == '/' || nextChar == '+' || nextChar == '-')
                        break;
                    else
                        i++;
                }
                int number = Integer.parseInt(numberStr.toString());
                String prevNumberStr = items.pollLast();
                int prevNumber = Integer.parseInt(prevNumberStr);
                number = c == '*' ? prevNumber * number : prevNumber / number;
                items.offerLast(String.valueOf(number));
            } else if (Character.isDigit(c)) {
                int number = Character.getNumericValue(c);
                while (i < s.length() - 1) {
                    char nextChar = s.charAt(i + 1);
                    if (Character.isDigit(nextChar)) {
                        i++;
                        number = number * 10 + Character.getNumericValue(s.charAt(i));
                    } else if (nextChar == '*' || nextChar == '/' || nextChar == '+' || nextChar == '-')
                        break;
                    else
                        i++;
                }
                items.add(String.valueOf(number));
            }
        }

        result = Integer.parseInt(items.pollFirst());

        while (!items.isEmpty()) {
            String operator = items.pollFirst();
            int number = Integer.parseInt(items.pollFirst());
            number = Objects.equals(operator, "+") ? number : -number;
            result += number;
        }

        return result;
    }
}
