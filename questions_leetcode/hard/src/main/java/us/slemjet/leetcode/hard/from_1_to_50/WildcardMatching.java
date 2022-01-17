package us.slemjet.leetcode.hard.from_1_to_50;

/**
 * 44. Wildcard Matching
 */
public class WildcardMatching {

    /**
     * Runtime: 100.00%
     * Memory Usage: 92.45%
     */
    public boolean isMatch(String s, String p) {

        int sIdx = 0, pIdx = 0, matchIdx = 0, starIdx = -1;
        while (sIdx < s.length()) {
            // If ? wildcard or both pattern and string char match -> increment both pointers
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || (/*p.charAt(pIdx) != '*' &&*/ s.charAt(sIdx) == p.charAt(pIdx)))) {
                sIdx++;
                pIdx++;
            }

            // If * pattern found -> increment pattern pointer
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                // record start index start (in pattern) and match index start (in string)
                starIdx = pIdx;
                matchIdx = sIdx;
                pIdx++;
            }

            // If last pattern char was * -> advance string pointer
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                matchIdx++;
                sIdx = matchIdx;
            }

            // If current pattern pointer is not * and last patter pointer was not * -> characters do not match
            else return false;
        }

        // Check is all remaining pattern chars are star
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        // We need to reach end of pattern by this time
        return pIdx == p.length();
    }


    public boolean isMatchDp(String s, String p) {

        // Initialize the match table -> extra row and column for initial values
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        // handle patterns, starting from *
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) { // next will match
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                }

            }
        }
        return dp[s.length()][p.length()];
    }

}
