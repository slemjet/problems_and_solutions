package us.slemjet.leetcode.easy.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
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
