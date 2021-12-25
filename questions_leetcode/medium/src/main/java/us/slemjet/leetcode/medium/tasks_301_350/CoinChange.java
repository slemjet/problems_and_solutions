package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 322. Coin Change
 */
public class CoinChange {

    /**
     * Top - bottom approach - use memoization
     * Recursive approach
     * <p>
     * Runtime: 39.94%
     * Memory Usage: 36.54%
     */
    public int coinChangeMemo(int[] coins, int amount) {
        // Use memo to cache results
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1; // Incorrect result
        if (amount == 0) return 0; // Found combination
        if (memo[amount] != 0) return memo[amount]; // Returned already computed value

        int minCount = Integer.MAX_VALUE;
        // Go through all the coins combinations
        for (int coin : coins) {
            // Take 1 coin and check combinations
            int tmpResult = helper(coins, amount - coin, memo);
            if (tmpResult != -1) {
                // Compare current result with current min
                minCount = Math.min(minCount, 1 + tmpResult);
            }
        }
        memo[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[amount];
    }

    /**
     * Bottom up approach
     * Iterative approach - store all results up to amount as dp[] array
     * <p>
     * Runtime: 94.51%
     * Memory Usage: 95.22%
     */
    public int coinChange(int[] coins, int amount) {
        // Use dp array to store all results up to current value
        int[] dp = new int[amount + 1];
        // Fill with maximum value, so we can decrease it while calculating is result is found
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // For all amount sizes
        for (int i = 1; i <= amount; i++) {
            // Check for each coin
            for (int coin : coins) {
                if (coin <= i) { // If we can use this coin
                    int prevCount = dp[i - coin];
                    dp[i] = Math.min(dp[i], prevCount + 1);
                }
            }
        }
        // Consider corner cases when artificial initial amount + 1 is increased (no result)
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Use BFS
     *
     * Runtime: 11.01%
     * Memory Usage: 29.11%
     */
    public int coinChangeBFS(int[] coins, int amount) {
        Queue<Integer> combinations = new LinkedList<>();
        combinations.add(0);
        int count = 0;
        boolean[] visited = new boolean[amount + 1]; // Store amounts already processed
        while (!combinations.isEmpty()) {
            // Check for each of current combinations
            int combLength = combinations.size();
            for (int i = 0; i < combLength; i++) {
                int currAmount = combinations.poll();
                if (currAmount == amount) {
                    return count; // Found solution
                }
                if (currAmount > amount || visited[currAmount]) {
                    continue; // Skip combination
                }
                visited[currAmount] = true;
                for (int coin : coins) {
                    combinations.add(currAmount + coin); // Add more combinations with current sum and all other coins
                }
            }
            count++;
        }
        return -1;
    }
}
