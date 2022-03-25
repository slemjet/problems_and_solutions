package us.slemjet.leetcode.medium.tasks_1001_1050;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. Two City Scheduling
 */
public class TwoCityScheduling {

    /**
     * Runtime: 21.03%
     * Memory Usage: 20.80%
     */
    public int twoCitySchedCost(int[][] costs) {

        int result = 0;

        // Sort by difference between A and B
        Arrays.sort(costs, Comparator.comparingInt(value -> value[0] - value[1]));

        // Most negative delta -> go to A, most positive -> go to B

        int leftIdx = 0;
        int rightIdx = costs.length - 1;

        while (leftIdx < rightIdx) {
            result += costs[leftIdx++][0] + costs[rightIdx--][1];
        }

        return result;
    }

    /**
     * DP Bottom Up
     * Runtime: 78.86%
     * Memory Usage: 70.91%
     */
    public int twoCitySchedCostBottomUp(int[][] costs) {

        int halfSize = costs.length / 2;
        int[][] dp = new int[halfSize + 1][halfSize + 1];

        // Prepopulate data
        for (int i = 1; i <= halfSize; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
            dp[0][i] = dp[0][i - 1] + costs[i - 1][1];
        }

        for (int i = 1; i <= halfSize; i++) {
            for (int j = 1; j <= halfSize; j++) {
                // Populate dp, taking minimum from possible values
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }

        return dp[halfSize][halfSize];
    }

    /**
     * Top to Bottom
     * Runtime: 99.69%
     * Memory Usage: 5.48%
     */
    public int twoCitySchedCostTopToBottom(int[][] costs) {
        int n = costs.length;
        int[][] memo = new int[n][n];
        return dp(costs, 0, 0, n, memo);
    }

    private int dp(int[][] costs, int a, int b, int n, int[][] memo) {
        if (a + b == n) return 0;
        if (memo[a][b] != 0) return memo[a][b];

        int takeA = Integer.MAX_VALUE;
        int takeB = Integer.MAX_VALUE;
        if (a < n / 2) takeA = costs[a + b][0] + dp(costs, a + 1, b, n, memo);
        if (b < n / 2) takeB = costs[a + b][1] + dp(costs, a, b + 1, n, memo);
        memo[a][b] = Math.min(takeA, takeB);

        return memo[a][b];
    }
}
