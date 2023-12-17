package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 96. Unique Binary Search Trees
 */
public class UniqueBinarySearchTrees {

    /**
     * DP Bottom Up
     * For each level (number of node) go over each node as a root
     * Sum combinations for this root, whis is a sum of combinations to the right and to the left
     * 1 2 [3] 4 5 6 dp[3] = (1 2) * (4 5 6) -> dp[2] * dp[3]
     *
     * Runtime: 100.00%
     * Memory Usage: 23.68%
     */
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        // Base scenario
        dp[0] = 1;
        dp[1] = 1;

        for (int totalNodes = 2; totalNodes <= n; totalNodes++) {
            for (int currRoot = 1; currRoot <= totalNodes; currRoot++) {
                // For each element current value = product of subset to the left,
                // multiplied by the product of the subset to the right
                // 1 2 [3] 4 5 6 dp[3] = (1 2) * (4 5 6) -> dp[2] * dp[3]
                dp[totalNodes] += dp[currRoot - 1] * dp[totalNodes - currRoot];
            }
        }

        return dp[n];
    }
}
