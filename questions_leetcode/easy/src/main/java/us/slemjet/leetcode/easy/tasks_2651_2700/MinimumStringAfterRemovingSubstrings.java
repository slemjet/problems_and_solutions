package us.slemjet.leetcode.easy.tasks_2651_2700;

import java.util.Stack;

/**
 * 2696. Minimum String Length After Removing Substrings
 */
public class MinimumStringAfterRemovingSubstrings {

    /**
     * Time:    O(n)    ->  62.54%
     * Space    O(n)    ->  93.99%
     */
    public int minLength(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if ((c == 'B' && stack.peek() == 'A')
                        || (c == 'D' && stack.peek() == 'C')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        return stack.size();
    }
}
