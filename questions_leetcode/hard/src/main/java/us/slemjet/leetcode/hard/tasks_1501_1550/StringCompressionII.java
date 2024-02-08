package us.slemjet.leetcode.hard.tasks_1501_1550;

import java.util.Arrays;

/**
 * 1531. String Compression II
 */
public class StringCompressionII {

    /**
     * Time: -> 84.44%
     * Space: -> 33.33%
     */
    public int getLengthOfOptimalCompressionTopDown(String s, int k) {

        Integer[][] dp = new Integer[s.length()][k + 1];
        return minLength(s.toCharArray(), 0, k, dp);
    }

    private int minLength(char[] chars, int idx, int k, Integer[][] memo) {

        // Reach end or index at which we can just delete rest
        if (idx >= chars.length || chars.length - idx <= k) {
            return 0;
        }
        if (memo[idx][k] != null) {
            return memo[idx][k];
        }

        // Frequency of chars
        int[] freq = new int[26];
        int mostFreq = 0;
        int min = Integer.MAX_VALUE;

        for (int i = idx; i < chars.length; i++) {
            int freqIdx = chars[i] - 'a';
            freq[freqIdx]++;

            // Keep track on max frequency
            mostFreq = Math.max(mostFreq, freq[freqIdx]);

            int remaining = i - idx + 1 - mostFreq;
            if (remaining <= k) {
                // If we can delete rest
                min = Math.min(min, calculateLength(mostFreq) + minLength(chars, i + 1, k - remaining, memo));
            }
        }

        memo[idx][k] = min;
        return min;
    }

    /**
     * Time: -> 31.11%
     * Space: -> 73.33%
     */
    public int getLengthOfOptimalCompressionBottomUp(String s, int k) {

        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0) {
                    // Has previous
                    dp[i][j] = dp[i - 1][j - 1];
                }
                int removed = 0;
                int count = 0;
                for (int p = i; p > 0; p--) {
                    if (s.charAt(p - 1) == s.charAt(i - 1)) {
                        count++;
                    } else {
                        removed++;
                        if (removed > j) {
                            // No more to remove
                            break;
                        }
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[p - 1][j - removed] + calculateLength(count));
                }
            }
        }
        return dp[n][k];
    }

    private int calculateLength(int mostFreq) {
        if (mostFreq == 1) return 1; // a
        if (mostFreq < 10) return 2; // a9
        if (mostFreq < 100) return 3; // a99
        return 4; // a200
    }

}
