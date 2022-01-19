package us.slemjet.leetcode.medium.tasks_251_300;

import java.util.TreeSet;

/**
 * 264. Ugly Number II
 */
public class UglyNumberII {

    /**
     * DP Bottom Up
     * <p>
     * Runtime: 57.29%
     * Memory Usage: 23.01%
     */
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        // Indices, pointing for current number used for 2, 3, 5
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[idx2] * 2, Math.min(dp[idx3] * 3, dp[idx5] * 5));
            // Increment indices, if number is divisible - since the number is used
            if (dp[i] % 2 == 0) idx2++;
            if (dp[i] % 3 == 0) idx3++;
            if (dp[i] % 5 == 0) idx5++;
        }

        return dp[dp.length - 1];
    }

    /**
     * Use PriorityQueue/ TreeSet
     *
     * Runtime: 6.16%
     * Memory Usage: 7.03%
     */
    public int nthUglyNumber2(int n) {

        TreeSet<Long> products = new TreeSet<>();
        products.add(1L);
        for (int i = 0; i < n - 1; ++i) {
            long first = products.pollFirst();
            products.add(first * 2);
            products.add(first * 3);
            products.add(first * 5);
        }
        return products.first().intValue();
    }
}
