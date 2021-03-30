package us.slemjet.leetcode.medium.from_50_to_100;

/**
 * 91. Decode Ways
 */
public class DecodeWays {

    /**
     * Recursion + memo
     * <p>
     * Runtime: 94.87%
     * Memory Usage: 99.63%
     */
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0')
            return 0;

        Integer[] memo = new Integer[s.length()];
        return combinations(s.toCharArray(), 0, memo);
    }

    private int combinations(char[] chars, int idx, Integer[] memo) {

        int result = 0;

        if (idx == chars.length) {
            return 1; // solution found
        }

        if (idx > chars.length || chars[idx] == '0') {
            return 0; // failed
        }

        if (memo[idx] != null) {
            return memo[idx]; // load from cache
        }

        result += combinations(chars, idx + 1, memo); // add single digit combination
        if (idx < chars.length - 1 && (chars[idx] - '0') * 10 + (chars[idx + 1] - '0') <= 26) {
            result += combinations(chars, idx + 2, memo); // add double digit combination
        }

        memo[idx] = result;
        return result;
    }

    /**
     * Dynamic
     *
     * Runtime: 94.87%
     * Memory Usage: 92.03%
     */
    public int numDecodingsDynamic(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1]; // Store combinations as we progress
        // Set initial conditions
        dp[0] = 1;
        dp[1] = 1;

        // Iterate over array incrementing for each possible combination
        for (int i = 2; i <= chars.length; i++) { // easier to iterate from the end
            int char1 = chars[i - 1] - '0';
            if (char1 != 0) {
                dp[i] += dp[i - 1]; // add single combination
            }
            int char2 = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
            if (char2 >= 10 && char2 <= 26) {
                dp[i] += dp[i - 2]; // add double combination
            }
        }
        // Total combinations sum stored at the first element
        return dp[chars.length];
    }

    /**
     * Dynamic
     * <p>
     * Runtime: 94.87%
     * Memory Usage: 99.63%
     */
    public int numDecodingsDynamicReversed(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;

        char[] chars = s.toCharArray();

        int[] dp = new int[s.length() + 1]; // Store combinations as we progress
        // Set initial conditions
        dp[s.length()] = 1;

        // Iterate over array incrementing for each possible combination
        for (int i = chars.length - 1; i >= 0; i--) { // easier to iterate from the end
            if (chars[i] != '0') {
                dp[i] = dp[i + 1];
                if (i < chars.length - 1 && (chars[i] - '0') * 10 + chars[i + 1] - '0' <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        // Total combinations sum stored at the first element
        return dp[0];
    }

}
