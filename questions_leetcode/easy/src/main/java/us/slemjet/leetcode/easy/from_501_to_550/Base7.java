package us.slemjet.leetcode.easy.from_501_to_550;

/**
 * 504. Base 7
 */
public class Base7 {

    /**
     * Runtime: 92.89%
     * Memory Usage: 5.27%
     */
    public String convertToBase7(int num) {

        StringBuilder result = new StringBuilder();

        // Calculate divisor
        int divisor = 1;
        while (divisor <= Math.abs(num) / 7) divisor *= 7;
        // Swap negative number, assign sign
        if (num < 0) {
            result.append("-");
            num = -num;
        }
        // Populate all numbers except last one
        while (divisor > 1) {
            result.append(num / divisor);
            num = num % divisor;
            divisor /= 7;
        }
        // Process last number
        result.append(num % 7);

        return result.toString();
    }

    /**
     * Runtime: 5.14%
     * Memory Usage: 6.59%
     */
    public String convertToBase7Short(int num) {

        if (num < 0) return "-" + convertToBase7Short(-num);
        else if (num < 7) return Integer.toString(num);
        else return convertToBase7Short(num / 7) + num % 7;
    }

    /**
     * Runtime: 92.89%
     * Memory Usage: 7.90%
     */
    public String convertToBase7VeryShort(int num) {
        return Integer.toString(num, 7);
    }
}
