package us.slemjet.leetcode.easy.from_251_to_300;

/**
 * 263. Ugly Number
 */
public class UglyNumber {

    /**
     * Runtime: 100.00%
     * Memory Usage: 93.53%
     */
    public boolean isUgly(int n) {

        if (n <= 0) return false; // Must be positive
        if (n == 1) return true;
        if (n % 2 == 0) return isUgly(n / 2);
        if (n % 3 == 0) return isUgly(n / 3);
        if (n % 5 == 0) return isUgly(n / 5);
        return false;
    }
}
