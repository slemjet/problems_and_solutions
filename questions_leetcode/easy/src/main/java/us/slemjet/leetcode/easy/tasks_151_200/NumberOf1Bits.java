package us.slemjet.leetcode.easy.tasks_151_200;

/**
 * 191. Number of 1 Bits
 */
public class NumberOf1Bits {

    /**
     * Runtime: 100.00%
     * Memory Usage: 50.64%
     */
    public int hammingWeight(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result += n & 1; // Check if current rank is "1"
            n = n >> 1; // Shift to next rank
        }

        return result;
    }
}
