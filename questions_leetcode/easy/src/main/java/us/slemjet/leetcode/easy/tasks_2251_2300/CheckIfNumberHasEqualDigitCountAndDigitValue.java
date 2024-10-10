package us.slemjet.leetcode.easy.tasks_2251_2300;

/**
 * 2283. Check if Number Has Equal Digit Count and Digit Value
 */
public class CheckIfNumberHasEqualDigitCountAndDigitValue {

    /**
     *
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  70.89%
     */
    public boolean digitCount(String num) {

        int matches = 0;
        int[] digits = new int[10];

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';

            boolean match = digits[i] == 0;
            digits[i] -= digit;
            digits[digit]++;
            if (digits[i] == 0 && !match) {
                matches++; // Starts to match
            } else if (digits[i] != 0 && match) {
                matches--; // No longer match
            }

        }
        return matches == 0;
    }
}
