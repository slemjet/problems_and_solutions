package us.slemjet.leetcode.hard.tasks_1_50;

/**
 * memo matrix for string = 'x a a b y c' and pattern = 'x a * b . c'
 *
 *    _0_|_1_|_2_|_3_|_4_|_5_|_6_|         string[i] == pattern[j] || pattern[j] == '.'    -->  T[i][j] = T[i-1][j-1]
 * 0 |_T_|_x_|_a_|_*_|_b_|_._|_c_|
 * 1 | x | T | F | T | F | F | F |         pattern[j] == '*'   --> T[i-1][j-2]
 * 2 | a | F | T | T | F | F | F |
 * 3 | a | F | F | T | F | F | F |         string[i] = pattern[j-1] || pattern[j-1] == '.' -->  T[i-1][j-2] || T[i-1][j]
 * 4 | b | F | F | F | T | F | F |
 * 5 | y | F | F | F | F | T | F |
 * 6 |_c_|_F_|_F_|_F_|_F_|_F_|_T_|  <-- result = T[length_string][length_pattern]
 */
public class RegularExpressionMatching {
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
