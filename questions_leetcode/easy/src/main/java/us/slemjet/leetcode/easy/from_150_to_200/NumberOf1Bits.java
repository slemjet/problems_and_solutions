package us.slemjet.leetcode.easy.from_150_to_200;

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
            result += n & 1;
            n = n >> 1;
        }

        return result;
    }
}
