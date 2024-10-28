package us.slemjet.leetcode.medium.tasks_1501_1550;

/**
 * 1541. Minimum Insertions to Balance a Parentheses String
 */
public class MinimumInsertionsToBalanceAParenthesesString {

    /**
     * Time: O(n)   ->  96.20%
     * Space:O(1)   ->  56.40%
     */
    public int minInsertions(String s) {

        int result = 0;

        char[] chars = s.toCharArray();

        int openBrackets = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == '(') {
                // Opening bracket
                openBrackets++;
            } else {
                // Closing bracket - need 2 consecutive
                if (i == chars.length - 1 || chars[i + 1] != ')') {
                    // Single closing bracket
                    if (openBrackets == 0) {
                        result += 2; // Add opening and closing bracket
                    } else {
                        result++;
                        openBrackets--; // Close one opening bracket
                    }
                } else {
                    if (openBrackets == 0) {
                        result++; // Add opening bracket
                    } else {
                        openBrackets--; // Close one opening bracket
                    }
                    i++;
                }
            }
        }
        result += 2 * openBrackets; // close remaining brackets

        return result;
    }
}
