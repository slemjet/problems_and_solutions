package us.slemjet.leetcode.easy.tasks_1_50;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {

    /**
     * Runtime: 42.64%
     * Memory Usage: 31.08%
     */
    private static final Map<Character, Character> openToClose =
            Collections.unmodifiableMap(new HashMap<Character, Character>() {{
                put('{', '}');
                put('(', ')');
                put('[', ']');
            }});

    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;

        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (chars.isEmpty() || c == '(' || c == '[' || c == '{')
                chars.push(c);
            else {
                Character closingChar = openToClose.get(chars.peek());
                if (closingChar != null && closingChar.equals(c))
                    chars.pop(); // Correct closing char
                else
                    return false; // Incorrectly closing char
            }
        }
        return chars.isEmpty();
    }
}
