package us.slemjet.leetcode.medium.tasks_351_400;

/**
 * 357. Count Numbers with Unique Digits
 */
public class CountNumbersWithUniqueDigits {

    /**
     * Time: O(1)   ->  100.00%
     * Space:O(1)   ->
     */
    public int countNumbersWithUniqueDigits(int n) {

        // n = 0 -> 1
        // n = 1 -> 10
        // n = 2 -> 10 + 9 * 9
        // n = 3 -> 10 + 9 * 9 * 8
        // n = 4 -> 10 + 9 * 9 * 8 * 7

        int[] dp = new int[9];
        dp[0] = 1;
        dp[1] = 10;

        int product = 9;

        for (int i = 2; i <= n; i++) {

            product *= (11 - i);
            dp[i] = dp[i - 1] + product;
        }

        return dp[n];
    }

    /**
     * Time: O(?)   ->  6.59%
     * Space:O(?)   ->  27.6
     */
    public int countNumbersWithUniqueDigitsBacktrack(int n) {

        if (n > 10) {
            // If there are more than 10 digits - it is not possible to create a number without duplicates
            return countNumbersWithUniqueDigitsBacktrack(10);
        }

        boolean[] isDigitUsed = new boolean[10];

        int maxNumber = (int) Math.pow(10, n);
        return countCombinations(0, maxNumber, isDigitUsed);
    }

    private int countCombinations(int current, int maxNumber, boolean[] isDigitUsed) {

        if (current >= maxNumber) {
            return 0;
        }

        int count = 1;
        // Start counting combinations

        for (int i = 0; i <= 9; i++) {
            if (current == 0 && i == 0) {
                continue; // skip leading zeroes
            }

            if (!isDigitUsed[i]) {
                isDigitUsed[i] = true; // Try all the combination if take this number
                count += countCombinations(current * 10 + i, maxNumber, isDigitUsed);
                isDigitUsed[i] = false;
            }
        }
        return count;
    }
}
