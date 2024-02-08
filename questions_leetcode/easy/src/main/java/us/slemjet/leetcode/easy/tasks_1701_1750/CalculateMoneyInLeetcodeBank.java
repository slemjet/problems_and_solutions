package us.slemjet.leetcode.easy.tasks_1701_1750;

/**
 * 1716. Calculate Money in Leetcode Bank
 */
public class CalculateMoneyInLeetcodeBank {

    /**
     * Time: O(1) -> 100.00%
     * Space: O(1) -> 19.76%
     */
    public int totalMoney(int n) {

        int result = 0;

        // week 1: 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
        // week 2: 2 + 3 + ... + 8 = 28 + 35 (28 + 7)
        // week 3: 3 + 4 + ... + 9 = 28 + 35 (28 + 7) + 42 (28 + 7 + 7)
        // week 4: 4 + 5 + ... + 10 = 28 + 35 (28 + 7) + 42 (28 + 7 + 7) + 49 (28 + 7 + 7 + 7)

        int weeks = n / 7;
        int days = n % 7;

        result += weeks * 28; // Each week base
        result += getElementsSum(1, weeks - 1) * 7; // Each week increment
        result += getElementsSum(weeks + 1, days); // Remaining days of current week

        return result;
    }

    private static int getElementsSum(int start, int count) {

        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += start;
            start++;
        }
        return sum;
    }
}
