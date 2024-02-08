package us.slemjet.leetcode.easy.tasks_201_250;

import java.util.Arrays;

/**
 * 204. Count Primes
 */
public class CountPrimes {

    /**
     * Runtime: 46.05%
     * Memory Usage: 71.02%
     */
    public int countPrimes(int n) {
        int result = 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                result++;
                for (int j = 2; i * j < n; j++) { // Exclude all multiplications of j and i
                    isPrime[i * j] = false;
                }
            }
        }
        return result;
    }
}
