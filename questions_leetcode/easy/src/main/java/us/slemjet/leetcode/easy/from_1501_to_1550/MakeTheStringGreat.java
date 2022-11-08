package us.slemjet.leetcode.easy.from_1501_to_1550;

import java.util.Stack;

/**
 * 1544. Make The String Great
 */
public class MakeTheStringGreat {

    /**
     * Runtime: 41.61%
     * Memory Usage: 64.62%
     *
     * Space: O(n)
     * Time: O(n)
     */
    public String makeGood(String s) {

        Stack<Character> chars = new Stack<>();

        for (char nextChar : s.toCharArray()) {
            if (!chars.isEmpty()) {
                Character prevChar = chars.peek();
                // 32 is the difference between 'A' and 'a' or 'b' and 'B'
                if (Math.abs(prevChar - nextChar) == 32) {
                    // Remove from stack and skip char
                    chars.pop();
                    continue;
                }
            }
            chars.push(nextChar);
        }

        StringBuilder result = new StringBuilder();
        while (!chars.isEmpty()) result.append(chars.pop());
        return result.reverse().toString();
    }
}
