package us.slemjet.leetcode.hard.tasks_1301_1350;

/**
 * 1335. Minimum Difficulty of a Job Schedule
 */
public class MinimumDifficultyOfAJobSchedule {

    /**
     * Runtime: 15.68%
     * Memory Usage: 28.77%
     */
    public int minDifficultyTopDown(int[] jobDifficulty, int d) {

        if (jobDifficulty.length < d) return -1;

        Integer[][] memo = new Integer[d][jobDifficulty.length];
        return dfs(jobDifficulty, d - 1, 0, memo);
    }

    private int dfs(int[] jobDifficulty, int d, int pos, Integer[][] memo) {

        if (d == 0) {
            // Last day -> return max of remaining
            int max = jobDifficulty[pos];
            for (int i = pos + 1; i < jobDifficulty.length; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }

        if (memo[d][pos] != null) return memo[d][pos];

        int minSum = Integer.MAX_VALUE;
        int maxSubset = Integer.MIN_VALUE;

        for (int i = pos; i < jobDifficulty.length - d; i++) {
            // Get maximum f current subset
            maxSubset = Math.max(maxSubset, jobDifficulty[i]);
            int minRemainingSubset = dfs(jobDifficulty, d - 1, i + 1, memo);
            // Get minimum of all max per remaining subsets
            minSum = Math.min(minSum, maxSubset + minRemainingSubset);
        }

        return memo[d][pos] = minSum;
    }

    /**
     * Runtime: 59.10%
     * Memory Usage: 42.88%
     */
    public int minDifficultyBottomUp(int[] jobDifficulty, int d) {

        if (jobDifficulty.length < d) return -1;

        Integer[][] dp = new Integer[d][jobDifficulty.length];
        // Pre populate starting state
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < jobDifficulty.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        }

        for (int day = 1; day < d; day++) {
            // Each day
            for (int len = day; len < jobDifficulty.length; len++) {
                // Each schedule
                int localMax = jobDifficulty[len];

                dp[day][len] = Integer.MAX_VALUE;
                for (int sched = len; sched >= day; sched--) {
                    // Get max of subset
                    localMax = Math.max(localMax, jobDifficulty[sched]);
                    dp[day][len] = Math.min(dp[day][len], localMax + dp[day - 1][sched - 1]);
                }
            }
        }

        return dp[d - 1][jobDifficulty.length - 1];
    }
}
