package us.slemjet.leetcode.medium.numbers;

public class PowXN {

    /**
     * Runtime: 100.00%
     * Memory Usage: 31.81%
     */
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE && x > 1) {
                // handle overflow
                return 0;
            }
            n = -n;
            x = 1 / x;
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    /**
     * Runtime: 61.94%
     * Memory Usage: 5.01%
     */
    public double myPow2(double x, int n) {

        double result = 1;

        //N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
        //
        //x^9 = x^(2^3) * x^(2^0)

        long absN = Math.abs((long) n);

        while (absN > 0) {
            if (absN % 2 != 0) {
                // we multiply result only if current bit is set
                result *= x;
            }
            // shift to next bit and calculate next value to add
            absN /= 2;
            x *= x;
        }

        return n < 0 ? 1 / result : result;
    }

    /**
     * Runtime: 5.03%
     * Memory Usage: 5.01%
     */
    public double myPow3(double x, int n) {

        if (x == 1) {
            return x;
        } else if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        } else if (n == 0) {
            return 1;
        }
        double result = n > 0 ? x : 1 / x;

        while (n > 1) {
            result *= x;
            n--;
        }

        while (n < -1) {
            result /= x;
            n++;

            if (result < 0.00001)
                return 0;
        }

        return result;
    }

}
