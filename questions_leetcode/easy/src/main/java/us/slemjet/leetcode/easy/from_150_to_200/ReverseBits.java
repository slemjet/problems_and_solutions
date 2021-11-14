package us.slemjet.leetcode.easy.from_150_to_200;

/**
 * 190. Reverse Bits
 */
public class ReverseBits {

    /**
     * Runtime: 99.06%
     * Memory Usage: 63.06%
     */
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | n & 1;
            n = n >> 1;
        }

        return result;
    }
}
