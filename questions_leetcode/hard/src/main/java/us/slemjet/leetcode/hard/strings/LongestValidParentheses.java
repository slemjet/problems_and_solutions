package us.slemjet.leetcode.hard.strings;

import java.util.Stack;

public class LongestValidParentheses {

    /**
     * We start by pushing −1 onto the stack.
     * <p>
     * For every ‘(’ encountered, we push its index onto the stack.
     * <p>
     * For every ‘)’ encountered, we pop the topmost element and subtract the current element's index
     * from the top element of the stack, which gives the length of the currently encountered valid string of parentheses.
     * If while popping the element, the stack becomes empty, we push the current element's index onto the stack.
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int result = 0;

        Stack<Integer> occurrences = new Stack<>();
        // initialize with -1
        occurrences.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                occurrences.push(i);
            else {
                occurrences.pop();
                if (occurrences.isEmpty())
                    occurrences.push(i); // empty shift start of correct sequence
                else
                    result = Math.max(result, i - occurrences.peek()); // corrects sequence is between this element and last in stack
            }
        }
        return result;
    }

    /**
     * Substrings ending with ‘(’ will always contain '0' at their corresponding dp indices.
     * Thus, we update the dp array only when ‘)’ is encountered.
     * <p>
     * To fill dp array we will check every two consecutive characters of the string and if
     * <p>
     * s[i]=‘)’ and s[i−1]=‘(’, i.e. string looks like ``.......()" ⇒ * dp[i]=dp[i-2]+dp[i]=dp[i−2]+2
     * <p>
     * We do so because the ending "()" portion is a valid substring anyhow and leads to an increment of 2 in the length
     * of the just previous valid substring's length.
     * <p>
     * s[i]=‘)’ and s[i−1]=‘)’, i.e. string looks like ``.......))"⇒
     * <p>
     * if s[i−dp[i−1]−1]=‘(’ then dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     * <p>
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesDynamic(String s) {
        int result = 0;

        int dp[] = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                dp[i] = 0; // no valid string can end with this
            else {
                if (i > 0 && s.charAt(i - 1) == '(') // -> valid string with +2 chars
                    dp[i] = 2 + (i > 1 ? dp[i - 2] : 0);
                else if (i > 0 && s.charAt(i - 1) == ')') // possible +4 and more chars
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                        dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
