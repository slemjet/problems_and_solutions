package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 97. Interleaving String
 */
public class InterleavingString {

    /**
     * Time: O(n*m) -> 62.43%
     * Space: O(n*m) -> 26.60%
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // Empty string can be formed
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            // Fill the first chars of s1 string match s3
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= s2.length(); i++) {
            // Fill the first chars of s2 string match s3
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // If the previous substring for s1 matched s3 and current s1 char matches s3 char
                // or previous substring for s2 char matched s3 and current s2 char matches s3 char - set to true
                char s3Char = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3Char)
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3Char);

            }
        }

        // Check if we can form s3 out of s2 and s1
        return dp[s1.length()][s2.length()];
    }
}
