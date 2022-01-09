package us.slemjet.leetcode.easy.from_501_to_550;

/**
 * 509. Fibonacci Number
 */
public class FibonacciNumber {

    /**
     * Bottom Up
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 8.65%
     */
    public int fib(int n) {

        if (n < 2) return n;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }

        return memo[n];
    }

    /**
     * Top down approach
     * <p>
     * Runtime: 5.29%
     * Memory Usage: 8.65%
     */
    public int fibMemo(int n) {
        if (n < 2) return n;
        int[] memo = new int[n + 1];
        return fibMemo(memo, n);
    }

    private int fibMemo(int[] memo, int n) {
        if (n < 2) return n;
        else if (memo[n] != 0) return memo[n];
        else return fibMemo(memo, n - 2) + fibMemo(memo, n - 1);
    }

    /**
     * Runtime: 100.00
     * Memory Usage: 14.17%
     */
    public int fibIter(int n) {
        if (n < 2) return n;

        int a = 0;
        int b = 1;

        while (n >= 2){
            int sum = a + b;
            a = b;
            b = sum;
            n--;
        }

        return b;
    }
}
