package us.slemjet.leetcode.hard.from_1301_to_1350;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1326. Minimum Number of Taps to Open to Water a Garden
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {

    /**
     * Use DP
     *
     * Time: O(n*m) ->  55.51%
     * Space:O(n)   ->  90.59%
     */
    public int minTapsDP(int n, int[] ranges) {

        // Min number to get to this position
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        // Initialize start
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {

            // Get reach of current tap
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            for (int j = left; j <= right; j++) {
                // Get minimum number of taps to get to max right position
                dp[right] = Math.min(dp[right], dp[j] + 1);
            }
        }

        return dp[n] == Integer.MAX_VALUE - 1 ? - 1: dp[n];

    }

    /**
     * Use greedy Approach
     * + Optimized by space - array of just one value instead of intervals
     * + Optimized by time - no sorting needed
     * <p>
     * Time: O(n)   ->  91.68%
     * Space:O(n)   ->  46.33%
     */
    public int minTapsGreedy(int n, int[] ranges) {

        int[] maxReach = new int[n + 1];

        // Store max possible reach from each position
        for (int i = 0; i < ranges.length; i++) {
            int min = Math.max(0, i - ranges[i]);
            int max = i + ranges[i];
            maxReach[min] = Math.max(maxReach[min], max);
        }

        int count = 0;

        int currEnd = 0;
        int nextMaxEnd = 0;

        for (int i = 0; i <= n; i++) {
            if (nextMaxEnd < i) {
                return -1; // Current position is unreachable
            }

            if (currEnd < i) {
                // Switch to next interval
                count++;
                currEnd = nextMaxEnd;
            }
            nextMaxEnd = Math.max(nextMaxEnd, maxReach[i]);
        }
        return count;
    }
}
