package us.slemjet.leetcode.medium.tasks_451_500;

/**
 * 486. Predict the Winner
 */
public class PredictTheWinner {

    /**
     * Time O(2^n)  ->  54.51%
     * Space: O(n)  ->  5.16%
     */
    public boolean predictTheWinnerTopDown(int[] nums) {

        Integer[][] memo = new Integer[nums.length][nums.length];

        boolean maxScoreDifference = maxScoreDiff(nums, 0, nums.length - 1, memo) >= 0;
        return maxScoreDifference;
    }

    private int maxScoreDiff(int[] nums, int start, int end, Integer[][] memo) {

        if (start == end) {
            return nums[start]; // No more moves for the opponent after we pick this one
        } else {

            if (memo[start][end] != null) {
                return memo[start][end];
            }
            // We are looking for maximum possible difference
            memo[start][end] = Math.max(
                    nums[start] - maxScoreDiff(nums, start + 1, end, memo), // Pick current value - what opponent could get
                    nums[end] - maxScoreDiff(nums, start, end - 1, memo)
            );
            return memo[start][end];
        }
    }

    /**
     * Time: O(n*n) ->  54.51%
     * Space:O(n*n) ->  10.44%
     */
    public boolean predictTheWinnerBottomUp(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        // Fill the diagonal values - base scenario start == end -> we can take nums[i] as the last move
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Change distance and iterate over subsets
        for (int distance = 1; distance < n; distance++) {
            // Move start and calculate max diff for each interval
            for (int start = 0; start < n - distance; start++) {

                // End is start + distance between them
                int end = start + distance;

                // We want maximum possible difference
                dp[start][end] = Math.max(
                        nums[start] - dp[start + 1][end],
                        nums[end] - dp[start][end - 1]
                );
            }
        }

        // Compare sum difference over full numbers length (start...end -> 0...n-1)
        return dp[0][n - 1] >= 0;
    }
}
