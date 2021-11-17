package us.slemjet.leetcode.easy.from_201_to_250;

import java.util.Arrays;

public class CountPrimes {

    /**
     * Runtime: 13 ms, 57.20%
     * Memory Usage: 9.43%
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
