package us.slemjet.leetcode.medium.tasks_301_350;

/**
 * 338. Counting Bits
 */
public class CountingBits {

    /**
     * Runtime: 99.75%
     * Memory Usage: 60.03%
     */
    public int[] countBits(int num) {

        int[] result = new int[num + 1];

        result[0] = 0;

        for (int i = 1; i <= num; i++) {
            // for optimisation previous values are reused to avoid re-calculation
            // result contains from prev result (without last bit) + odd/even remainder
            int remainder = i & 1; // i % 2

            int prevCount = result[i >>> 1]; // result[i / 2]

            result[i] = prevCount + remainder;
        }

        return result;
    }

}
