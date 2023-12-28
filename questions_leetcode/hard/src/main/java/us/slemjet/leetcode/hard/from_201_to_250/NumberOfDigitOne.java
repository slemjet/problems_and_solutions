package us.slemjet.leetcode.hard.from_201_to_250;

/**
 * 233. Number of Digit One
 */
public class NumberOfDigitOne {

    /**
     * 100.00%
     * 5.82%
     */
    public int countDigitOne(int n) {

        if (n <= 0) return 0;
        int result = 0;
        for (long i = 1; i <= n; i *= 10) {
            long a = n / i, b = n % i;
            if (a % 10 > 1) {
                result += (int) ((a / 10 + 1) * i);
            }
            if (a % 10 == 1) {
                result += (int) ((a / 10) * i + b + 1);
            }
            if (a % 10 == 0) {
                result += (int) ((a / 10) * i);
            }
        }
        return result;
    }

    /**
     * 100.00%
     * 5.82%
     */
    public int countDigitOne2(int n) {

        int ans = 0;
        for (long pow10 = 1; pow10 <= n; pow10 *= 10) {
            final long divisor = pow10 * 10;
            final int quotient = (int) (n / divisor);
            final int remainder = (int) (n % divisor);
            if (quotient > 0)
                ans += (int) (quotient * pow10);
            if (remainder >= pow10)
                ans += (int) Math.min(remainder - pow10 + 1, pow10);
        }
        return ans;
    }
}
