package us.slemjet.leetcode.easy.tasks_1601_1650;

/**
 * 1614. Maximum Nesting Depth of the Parentheses
 */
public class MaximumNestingDepthOfTheParentheses {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  100.00%
     */
    public int maxDepth(String s) {

        int result = 0;
        int depth = 0;

        for (char aChar : s.toCharArray()) {
            if (aChar == '(') {
                depth++;
            } else if (aChar == ')') {
                depth--;
            }
            result = Math.max(result, depth);
        }

        return result;
    }
}
