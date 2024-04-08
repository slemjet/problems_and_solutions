package us.slemjet.leetcode.medium.tasks_651_700;

/**
 * 678. Valid Parenthesis String
 */
public class ValidParenthesisString {

    /**
     * DP
     * Time: O(n)   ->  38.41%
     * Space:O(n)   ->  5.28%
     */
    public boolean checkValidString(String s) {
        return checkValidString(0, 0, s, new Boolean[s.length()][s.length()]);
    }

    private boolean checkValidString(int leftCount, int idx, String s, Boolean[][] memo) {
        if (leftCount < 0) {
            return false;
        }
        if (idx >= s.length()) {
            return leftCount == 0;
        }

        if (memo[leftCount][idx] == null) {
            char charAt = s.charAt(idx);
            if (charAt == '(') {
                memo[leftCount][idx] = checkValidString(leftCount + 1, idx + 1, s, memo);
            } else if (charAt == ')') {
                memo[leftCount][idx] = checkValidString(leftCount - 1, idx + 1, s, memo);
            } else {
                // Wildcard '*'
                memo[leftCount][idx] = checkValidString(leftCount - 1, idx + 1, s, memo) ||
                        checkValidString(leftCount + 1, idx + 1, s, memo) ||
                        checkValidString(leftCount, idx + 1, s, memo);
            }
        }
        return memo[leftCount][idx];
    }
}
