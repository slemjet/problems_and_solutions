package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.stream.IntStream;

/**
 * 416. Partition Equal Subset Sum
 */
public class PartitionEqualSubsetSum {

    /**
     * Top-Down Approach - Recursion + memo
     * Time:  O(n*m)    ->  96.05%
     * Space: O(n*m)    ->  41.26%
     */
    public boolean canPartitionMemo(int[] nums) {

        int sum = IntStream.of(nums).sum();

        if (sum % 2 != 0) {
            // Cannot partition in  halves
            return false;
        }

        int targetSum = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][targetSum + 1];
        return canPartitionMemo(nums.length - 1, nums, targetSum, memo);
    }

    private boolean canPartitionMemo(int idx, int[] nums, int targetSum, Boolean[][] memo) {
        if (targetSum == 0) {
            // Can partition
            return true;
        }

        if (idx < 0 || targetSum < 0) {
            return false;
        }

        if (memo[idx][targetSum] == null) {
            memo[idx][targetSum] =
                    canPartitionMemo(idx - 1, nums, targetSum - nums[idx], memo) || // Add to sum
                            canPartitionMemo(idx - 1, nums, targetSum, memo); // Or not add to sum
        }

        return memo[idx][targetSum];
    }

    /**
     * Use bottom Up - Tabulation approach
     * Time: O(n*m)   ->  44.21%
     * Space:O(n*m)   ->  59.79%
     */
    public boolean canPartitionTabulation(int[] nums) {

        int sum = IntStream.of(nums).sum();

        if (sum % 2 != 0) {
            // Cannot partition in  halves
            return false;
        }

        int targetSum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true; // Initial state - can get sum 0 for any index
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int currSum = 1; currSum <= targetSum; currSum++) {

                dp[i][currSum] = dp[i - 1][currSum]; // Don't add number
                if (nums[i - 1] <= currSum) {
                    // Can add number to sum
                    dp[i][currSum] |= dp[i - 1][currSum - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][targetSum];
    }
}
