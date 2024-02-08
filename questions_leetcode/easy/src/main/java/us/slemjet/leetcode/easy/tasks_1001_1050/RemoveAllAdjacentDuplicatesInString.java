package us.slemjet.leetcode.easy.tasks_1001_1050;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 */
public class RemoveAllAdjacentDuplicatesInString {

    /**
     * Runtime: 44.98%
     * Memory Usage: 36.95%
     *
     * Space: O(n)
     * Time: O(n)
     */
    public String removeDuplicates(String s) {

        Stack<Character> uniqueChars = new Stack<>();

        for (char nextChar : s.toCharArray()) {
            if (!uniqueChars.isEmpty() && uniqueChars.peek().equals(nextChar)) {
                uniqueChars.pop();
                continue;
            }
            uniqueChars.push(nextChar);
        }

        StringBuilder result = new StringBuilder();

        while (!uniqueChars.isEmpty()) result.append(uniqueChars.pop());

        return result.reverse().toString();
    }
}
