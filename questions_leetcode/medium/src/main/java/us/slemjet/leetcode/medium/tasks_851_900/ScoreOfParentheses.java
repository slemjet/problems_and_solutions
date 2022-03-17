package us.slemjet.leetcode.medium.tasks_851_900;

/**
 * 856. Score of Parentheses
 */
public class ScoreOfParentheses {

    /**
     * Runtime: 100.00%
     * Memory Usage: 83.17%
     */
    public int scoreOfParentheses(String s) {

        int result = 0;
        int level = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // String is balanced so there will be next
                if (s.charAt(i + 1) == '(') {
                    // level increase
                    level = level << 1;
                } else {
                    // '()' scenario - add node at level
                    result += level;
                    i++;
                }
            } else {
                // Level is decreased
                level = level >> 1;
            }
        }

        return result;
    }
}
