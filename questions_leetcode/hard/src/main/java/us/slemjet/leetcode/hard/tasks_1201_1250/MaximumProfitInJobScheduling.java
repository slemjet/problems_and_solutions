package us.slemjet.leetcode.hard.tasks_1201_1250;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 1235. Maximum Profit in Job Scheduling
 */
public class MaximumProfitInJobScheduling {

    /**
     * Runtime: 19.18%
     * Memory Usage: 30.84%
     */
    public int jobSchedulingTree(int[] startTime, int[] endTime, int[] profit) {
        int length = startTime.length;
        int[][] jobs = new int[length][3];
        for (int i = 0; i < length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }

    /**
     * Runtime: 93.29%
     * Memory Usage: 94.71%
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int length = startTime.length;
        int[][] jobs = new int[length][];
        for (int i = 0; i < length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt((int[] job) -> job[1]));
        int dp[] = new int[length + 1];
        for (int i = 0; i < length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            int low = 0;
            int high = i;

            while (low < high - 1) {
                int med = low + (high - low) / 2;

                if (jobs[med][1] <= jobs[i][0]) {
                    low = med;
                } else {
                    high = med;
                }
            }
            dp[i + 1] = Math.max(dp[i + 1], ((jobs[low][1] <= jobs[i][0]) ? dp[low + 1] : 0) + jobs[i][2]);
        }
        return dp[length];
    }
}
