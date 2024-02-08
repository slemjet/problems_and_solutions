package us.slemjet.leetcode.hard.tasks_1401_1450;

import java.util.Arrays;

/**
 * 1478. Allocate Mailboxes
 */
public class AllocateMailboxes {

    /**
     * DP Bottom UP
     *
     * Runtime: 56.47%
     * Memory Usage: 49.41%
     */
    public int minDistanceBottomUp(int[] houses, int k) {
        Arrays.sort(houses); // Sort as it is not mentioned that it is sorted
        // Use memo to store min distance sum for current index and k
        return dfs(houses, 0, k, new Integer[houses.length + 1][k + 1]);
    }

    private int dfs(int[] houses, int idx, int k, Integer[][] memo) {
        if (k >= houses.length - idx + 1) return 0; // Can put mailbox to every house
        if (k == 1) return sumDistance(houses, idx, houses.length - 1); // One mailbox is put at the median
        if (memo[idx][k] != null) return memo[idx][k];

        int minSum = Integer.MAX_VALUE;
        for (int i = idx; i < houses.length; i++) {
            // Compare current min with the interval from start idx to current and minimum of sums all remaining intervals
            minSum = Math.min(minSum, sumDistance(houses, idx, i) + dfs(houses, i + 1, k - 1, memo));
        }
        memo[idx][k] = minSum;
        return minSum;
    }

    private Integer sumDistance(int[] houses, int start, int end) {
        int medianIdx = start + (end - start) / 2;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += Math.abs(houses[medianIdx] - houses[i]);
        }
        return sum;
    }

    /**
     * DP Top to bottom
     *
     * Runtime: 82.35%
     * Memory Usage: 37.25%
     */
    public int minDistanceTopToBottom(int[] houses, int k) {
        Arrays.sort(houses); // Sort as it is not mentioned that it is sorted

        int[][] dp = new int[k][houses.length];
        // Prepare data
        for (int i = 1, idx = 0; i < houses.length; i++) {
            dp[0][i] = dp[0][i - 1] + houses[i] - houses[idx];
            if (i % 2 == 1) idx++;
        }

        for (int i = 1; i < k; i++) {
            for (int j = i + 1; j < houses.length; j++) {
                int minSum = dp[i - 1][j - 1];
                int currSum = 0;
                for (int l = j - 1, idx = j; l > 0; l--) { // Start in reversed order
                    currSum += houses[idx] - houses[l];
                    minSum = Math.min(minSum, dp[i - 1][l - 1] + currSum);
                    if ((j - l) % 2 == 1) idx--;
                }
                dp[i][j] = minSum;
            }
        }

        return dp[k - 1][houses.length - 1];
    }
}
