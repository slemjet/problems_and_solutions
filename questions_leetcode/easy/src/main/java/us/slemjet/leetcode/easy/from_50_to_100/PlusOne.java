package us.slemjet.leetcode.easy.from_50_to_100;

public class PlusOne {

    /**
     * Runtime: 100.00%
     * Memory Usage: 54.16%
     */
    public int[] plusOne(int[] digits) {

        int idx = digits.length - 1;
        digits[idx]++;

        while (digits[idx] >= 10) {

            digits[idx] -= 10;
            if (idx == 0) {
                int[] extendedDigits = new int[digits.length + 1];
                System.arraycopy(digits, 0, extendedDigits, 1, digits.length - 1 + 1);
                digits = extendedDigits;
                idx++;
            }
            digits[--idx]++;
        }

        return digits;
    }
}
