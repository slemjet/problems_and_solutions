package pl.slemjet.katas.nesting;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {

    public static int solution(String S) {
        // write your code in Java SE 8
        Map<Character, Character> brackets = Collections.unmodifiableMap(new HashMap<Character, Character>() {{
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }});

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char sym = S.charAt(i);

            if (sym == '{' || sym == '(' || sym == '[') // opening bracket
                stack.add(sym);
            else if (stack.isEmpty() || sym != brackets.get(stack.peek())) // incorrect closing
                return 0;
            else // correctly closing
                stack.pop();
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
