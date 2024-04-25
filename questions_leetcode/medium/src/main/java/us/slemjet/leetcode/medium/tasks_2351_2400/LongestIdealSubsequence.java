package us.slemjet.leetcode.medium.tasks_2351_2400;

/**
 * 2370. Longest Ideal Subsequence
 */
public class LongestIdealSubsequence {

    /**
     * DP Top to Bottom + Memoization
     * <p>
     * Time: O(n * m)   ->  17.46%
     * Space:O(n * m)   ->  5.55%
     */
    public int longestIdealStringTopToBottom(String s, int k) {

        Integer[][] memo = new Integer[s.length()][26];

        int result = 0;
        for (int letter = 0; letter < 26; letter++) {
            // Try with every char in alphabet
            result = Math.max(result, longestIdealStringTopToBottom(s.toCharArray(), s.length() - 1, letter, k, memo));
        }

        return result;
    }

    private int longestIdealStringTopToBottom(char[] charArray, int idx, int letter, int k, Integer[][] memo) {

        if (memo[idx][letter] == null) {
            if (idx == 0) {
                // Base case - either match or not
                memo[idx][letter] = letter == charArray[idx] - 'a' ? 1 : 0;
            } else {
                // If skip this char
                int maxSkip = longestIdealStringTopToBottom(charArray, idx - 1, letter, k, memo);

                // If take this char
                int maxUse = 0;
                boolean charsMatch = letter == charArray[idx] - 'a';
                if (charsMatch) {
                    for (int candidate = 0; candidate < 26; candidate++) {
                        if (Math.abs(letter - candidate) <= k) {
                            // If char is within boundaries
                            maxUse = Math.max(maxUse, 1 + longestIdealStringTopToBottom(charArray, idx - 1, candidate, k, memo));
                        }
                    }
                }

                memo[idx][letter] = Math.max(maxSkip, maxUse);
            }
        }

        return memo[idx][letter];
    }

    /**
     * DP Bottom Up
     *
     * Time: O(n*m) ->  52.38%
     * Space:O(n)   ->  55.56%
     */
    public int longestIdealStringBottomUp(String s, int k) {

        int result = 0;
        int[] dp = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i) - 'a';
            int maxLength = 0;
            for (int candidate = 0; candidate < 26; candidate++) {
                if (Math.abs(letter - candidate) <= k) {
                    maxLength = Math.max(maxLength, dp[candidate]);
                }
            }

            dp[letter] = Math.max(dp[letter], maxLength + 1);
            result = Math.max(result, dp[letter]);
        }

        return result;
    }
}
