package us.slemjet.leetcode.medium.tasks_1601_1650;

/**
 * 1638. Count Substrings That Differ by One Character
 */
public class CountSubstringsThatDifferByOneCharacter {

    /**
     * Use DP
     * Runtime: 23.42%
     * Memory Usage: 26.02%
     * <p>
     * Space: O(n*m)
     * Time: O(n*m)
     */
    public int countSubstringsDp(String s, String t) {

        // i - index of s, j - index of t
        // can have either 0 different chars or 1 (task requirement)
        int[][][] dp = new int[s.length() + 1][t.length() + 1][2];

        int combinations = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1][0] = dp[i][j][0] + 1; // Just increment
                    dp[i + 1][j + 1][1] = dp[i][j][1]; // Same count
                } else {
                    dp[i + 1][j + 1][0] = 0; // Reset matched count
                    dp[i + 1][j + 1][1] = dp[i][j][0] + 1; // Get matched + 1
                }
                combinations += dp[i + 1][j + 1][1];
            }
        }
        return combinations;
    }

    /**
     * Find chr that is different and count sum of combinations around it
     * < 2 >    <  4  >
     * ... n] a b [c] d e f g [x...
     * ... m] a b [f] d e f g [y...
     * <p>
     * combinations = (2 + 1) * (4 + 1) = 15
     * <p>
     * Runtime: 79.18%
     * Memory Usage: 92.57%
     * <p>
     * Space: O(n*m)
     * Time: O(1)
     */
    public int countSubstrings(String s, String t) {

        int combinations = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) continue; // We skip chars that match

                int leftCount = 0;
                int x = i - 1, y = j - 1;
                // Shift to the left until find another char that is different
                while (x >= 0 && y >= 0) {
                    if (s.charAt(x--) != t.charAt(y--)) break;
                    leftCount++;
                }

                int rightCount = 0;
                x = i + 1;
                y = j + 1;
                // Shift to the left until find another char that is different
                while (x < s.length() && y < t.length()) {
                    if (s.charAt(x++) != t.charAt(y++)) break;
                    rightCount++;
                }

                combinations += (leftCount + 1) * (rightCount + 1);
            }
        }
        return combinations;
    }
}
