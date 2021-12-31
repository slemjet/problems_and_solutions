package us.slemjet.leetcode.easy.from_301_to_350;

/**
 * 326. Power of Three
 */
public class PowerOfThree {

    /**
     * Naive approach
     * <p>
     * Runtime: 99.95%
     * Memory Usage: 83.78%
     */
    public boolean isPowerOfThree(int n) {

        while (n > 2 && n % 3 == 0)
            n /= 3;

        return n == 1;
    }

    /**
     * Use log formula log3(n) = lg(n)/lg(3)
     * Check if can be divided without remainder - than it can be divided - so it cn be power of 3
     *
     * Runtime: 63.79%
     * Memory Usage: 91.27%
     */
    public boolean isPowerOfThreeLog(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /**
     * Cheat approach - use maximum power of 3 -> 3^19 = 1162261467
     * if 1162261467 can be divided by n without remainder - it is power of 3 too
     * <p>
     * Runtime: 63.79%
     * Memory Usage: 72.61%
     */
    public boolean isPowerOfThreeCheat(int n) {

        int maxPow3 = (int) (Math.log(Integer.MAX_VALUE) / Math.log(3));

        int maxBase3Val = (int) Math.pow(3, maxPow3);

        return n > 0 && maxBase3Val % n == 0;
    }
}
