package us.slemjet.leetcode.medium.tasks_251_300;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 */
public class PerfectSquares {

    /**
     * Dynamic programming
     * Runtime: 82.08%
     * Memory Usage: 73.62%
     */
    public int numSquares(int n) {

        int[] squares = new int[n + 1]; // Contains number of squares needed to calculate this value

        Arrays.fill(squares, Integer.MAX_VALUE);
        squares[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; i >= j * j; j++) {
                int current = squares[i];
                int potential = squares[i - j * j] + 1; // Previous square value + 1
                squares[i] = Math.min(current, potential);
            }
        }

        return squares[n];
    }


    /**
     * Legendre 3 squares theorem
     * Any natural number can be represented as the sum of three squares of integers
     * n = x*x + y*y + z*z
     * Except for case when n = 8b + 7
     *
     * Runtime: 99.74%
     * Memory Usage: 99.71%
     */
    public int numSquaresLeg(int n) {
        // Answers can be from 1 to 4 only. ->  Legendre's three-square theorem
        //case 1 when answer will be 1
        int sqrt = (int)Math.sqrt(n);

        if (sqrt * sqrt == n)
            return 1;

        //case 2 when answer will be 2
        for (int i = 1; i <= sqrt; i++) {
            int x = n - i * i;
            int sqrtX = (int) Math.sqrt(x);
            if (sqrtX * sqrtX == x)
                return 2;
        }

        //case 3 when answer will be 4
        while (n % 4 == 0)
            n = n / 4;
        if (n % 8 == 7)
            return 4;

        //case 4 when answer will be 3
        return 3;
    }
}