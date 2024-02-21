package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.Arrays;

/**
 * 201. Bitwise AND of Numbers Range
 */
public class BitwiseANDOfNumbersRange {

    /**
     * Time:  O(1)  -> 100.00%
     * Space: O(1)  -> 88.61%
     */
    public int rangeBitwiseAnd(int left, int right) {

        // We shift number to common bit prefix
        // The different bits will be turned into '0' by AND operation

        int shiftBits = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shiftBits++;
        }

        // Now we sift right back so all the changing lower bits will become '0'
        return right << shiftBits;
    }

    /**
     * Time: O(n)   ->  15.06%
     * Space:O(n)   ->  88.61%
     */
    public int rangeBitwiseAndWithStrings(int left, int right) {

        String rightBinary = Integer.toBinaryString(right);
        String leftBinary = Integer.toBinaryString(left);

        if (rightBinary.length() == leftBinary.length()) {

            char[] result = new char[rightBinary.length()];
            Arrays.fill(result, '0');

            // Move from the highest bit to the lowest while they match. The rest bits have changed so AND will turn them into '0'
            for (int i = 0; i < rightBinary.length(); i++) {
                if (rightBinary.charAt(i) == leftBinary.charAt(i)) {
                    result[i] = rightBinary.charAt(i);
                } else {
                    break;
                }
            }
            return Integer.parseInt(new String(result), 2);
        }
        return 0;
    }
}
