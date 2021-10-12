package us.slemjet.leetcode.medium.tasks_1_50;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;

        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        // remove sign of operands
        long dividendL = dividend;
        dividendL = dividendL < 0 ? -dividendL : dividendL;
        long divisorL = divisor;
        divisorL = divisorL < 0 ? -divisorL : divisorL;

        if (dividendL == divisorL) return sign;

        long result = 0;
        // the idea is to find number, which multiplied divisor by certain amount of powers of 2 makes closest to divided
        while (dividendL >= divisorL) {
            int shift = 0;
            while (dividendL >= (divisorL << shift)) // find the shift so divisor becomes closest divided
                shift++;

            result += (long) 1 << (shift - 1);
            dividendL -= divisorL << (shift - 1);
        }

        result *= sign;

        // Consider Integer boundaries
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }
}
