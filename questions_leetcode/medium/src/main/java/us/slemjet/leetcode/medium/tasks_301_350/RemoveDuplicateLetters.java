package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.Stack;

/**
 * 316. Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {

    /**
     * Runtime: 39.37%
     * Memory Usage: 52.66%
     */
    public String removeDuplicateLetters(String s) {

        // Use stack to keep current ordered elements
        Stack<Character> ordered = new Stack<>();

        // Bitmask for current elements in the stack
        int currentLettersMask = 0;

        // Array of bitmasks of remaining elements to keep track if they can occur later (can use count array instead)
        int[] remainingMasks = new int[s.length()];
        remainingMasks[s.length() - 1] = 1 << s.charAt(s.length() - 1) - 'a';

        for (int i = s.length() - 2; i >= 0; i--) {
            remainingMasks[i] = remainingMasks[i + 1] | 1 << s.charAt(i) - 'a';
        }

        for (int i = 0; i < s.length(); i++) {
            char nextLetter = s.charAt(i);
            int remainingMask = remainingMasks[i];

            // Skip if exists
            if ((currentLettersMask & 1 << nextLetter - 'a') != 0) continue;

            // Pop all bigger than current
            while (!ordered.isEmpty() && ordered.peek() > nextLetter && (remainingMask & 1 << ordered.peek() - 'a') != 0) {
                Character popped = ordered.pop();
                currentLettersMask = currentLettersMask ^ 1 << popped - 'a';
            }

            ordered.push(nextLetter);
            currentLettersMask = currentLettersMask | 1 << nextLetter - 'a';
        }

        StringBuilder result = new StringBuilder();
        while (!ordered.isEmpty()) result.append(ordered.pop());

        return result.reverse().toString();
    }
}
