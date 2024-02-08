package us.slemjet.leetcode.easy.tasks_1101_1150;

/**
 * 1137. N-th Tribonacci Number
 */
public class NthTribonacciNumber {

    /**
     * Iterative
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 72.67%
     */
    public int tribonacci(int n) {

        if (n == 0) return 0;
        if (n <= 2) return 1;

        int a = 0;
        int b = 1;
        int c = 1;

        while (n >= 3) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
            n--;
        }

        return c;
    }

    /**
     * Top Down Approach
     *
     * Runtime: 100.00%
     * Memory Usage: 27.53%
     */
    public int tribonacciMemo(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        return tribonacciMemo(new int[n + 1], n);
    }

    private int tribonacciMemo(int[] memo, int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        if (memo[n] != 0) return memo[n];
        memo[n] = tribonacciMemo(memo, n - 3) + tribonacciMemo(memo, n - 2) + tribonacciMemo(memo, n - 1);
        return memo[n];
    }

    /**
     * Bottom Up Approach
     * <p>
     * Runtime: 100.00%
     * Memory Usage: 12.68%
     */
    public int tribonacciBottomUp(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 3] + result[i - 2] + result[i - 1];
        }

        return result[n];
    }
}
