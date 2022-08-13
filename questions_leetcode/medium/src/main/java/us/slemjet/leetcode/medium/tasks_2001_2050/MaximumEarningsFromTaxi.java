package us.slemjet.leetcode.medium.tasks_2001_2050;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2008. Maximum Earnings From Taxi
 */
public class MaximumEarningsFromTaxi {

    /**
     * Runtime: 83.99%
     * Memory Usage: 73.46%
     */
    public long maxTaxiEarningsDp(int n, int[][] rides) {

        Arrays.sort(rides, Comparator.comparingInt(value -> value[1]));

        long[] dp = new long[n + 1]; // Contains max sum at current point

        int k = 0; // Index of the current ride
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];

            while (k < rides.length && i == rides[k][1]) {
                // Check ride ending on this index

                int[] endingRide = rides[k];
                k++;

                // Get max of current sum and sum at the moment this ride began + ride sum
                dp[i] = Math.max(dp[i], dp[endingRide[0]] + endingRide[1] - endingRide[0] + endingRide[2]);
            }
        }

        return dp[dp.length - 1];
    }
}
