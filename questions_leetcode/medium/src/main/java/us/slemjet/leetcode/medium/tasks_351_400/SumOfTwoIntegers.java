package us.slemjet.leetcode.medium.tasks_351_400;

/**
 * 371. Sum of Two Integers
 */
public class SumOfTwoIntegers {

    /**
     * Runtime: 100.00%
     * Memory Usage: 13.12%
     */
    public int getSum(int a, int b) {
        if (a == 0) return b;
        else if (b == 0) return a;

        int carry = (a & b) << 1; // Both bits are 1 -> we need to carry higher bit
        int nextCarry = 0;
        int result = a ^ b;

        while (carry != 0) {
            nextCarry = (carry & result) << 1;
            result = carry ^ result; // Both 1 -> we carry over, if one 1 - do not carry
            carry = nextCarry;
        }
        return result;
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 19.95%
     */
    public int getSum2(int a, int b) {

        int result = 0;
        boolean carry = false;

        for (int i = 0; i < 32; i++) {
            int rank = 1 << i;

            int aRank = a & rank;
            int bRank = b & rank;

            if (aRank != 0 && bRank != 0) {
                if (carry) {
                    result |= rank;
                }
                carry = true;
            } else if (carry && aRank != 0 || carry && bRank != 0) {
                carry = true;
            } else {
                if (aRank != 0 || bRank != 0 || carry) {
                    result |= rank;
                }
                carry = false;
            }
        }

        return result;
    }
}
