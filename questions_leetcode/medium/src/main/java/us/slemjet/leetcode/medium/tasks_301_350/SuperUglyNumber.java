package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 313. Super Ugly Number
 */
public class SuperUglyNumber {

    /**
     * Time: O(n*p) ->  67.91%
     * Space:O(n*p) ->  86.57%
     */
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] indices = new int[primes.length];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < primes.length; j++) {
                // Iterate for each prime value looking for candidate
                // Next possible candidate - look for minimum
                // Use long to counter int overflow which will result in negative value
                long candidate = (long) dp[indices[j]] * primes[j];
                dp[i] = (int) Math.min(dp[i], candidate);
            }

            // Increment index for prime that was updated
            for (int j = 0; j < primes.length; j++) {
                // Increment index for divisible values - so we wont duplicate it
                if (primes[j] * dp[indices[j]] <= dp[i]) {
                    indices[j]++;
                }
            }
        }

        return dp[n - 1];
    }

    public int nthSuperUglyNumberI(int n, int[] primes) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int prime : primes) {
            q.add(new int[]{prime, 1, prime});
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ) {
            int[] cur = q.poll();
            if (dp[i - 1] != cur[2]) {
                dp[i] = cur[2];
                i++;
            }

            q.add(new int[]{cur[0], cur[1] + 1, cur[0] * dp[cur[1] + 1]});
        }

        return dp[n];
    }
}
