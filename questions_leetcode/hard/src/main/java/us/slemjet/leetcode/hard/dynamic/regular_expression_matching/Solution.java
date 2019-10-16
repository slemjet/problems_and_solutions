package us.slemjet.leetcode.hard.dynamic.regular_expression_matching;

public class Solution {
    public boolean isMatch(String s, String p) {

        // adding extra row and column for initial values
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];

        // fill with initial values
        memo[0][0] = true;

        // handle patterns like a* or a*b*
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                memo[0][i] = memo[0][i - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // case pattern[j] == '.' or string[i] == pattern[j]
                if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                }
                // handle * pattern
                else if (p.charAt(j - 1) == '*') {
                    memo[i][j] = memo[i][j - 2];
                    if (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
                        memo[i][j] = memo[i][j] || memo[i - 1][j];
                    }
                }
            }
        }

        return memo[s.length()][p.length()];
    }
}
