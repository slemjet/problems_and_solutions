package us.slemjet.leetcode.medium.strings;

public class MultiplyStrings {

    /**
     * Runtime: 25.85%
     * Memory Usage: 100.00%
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length()]; // max possible size
        for (int i = num1.length() - 1; i >= 0; i--) {
            // multiply each number of first sequence
            for (int j = num2.length() - 1; j >= 0; j--) {
                int firstShift = num1.length() - 1 - i; // shift from the first sequence digit
                int secondShift = num2.length() - 1 - j; // shift from the second sequence digit
                int index = firstShift + secondShift; // total shift where to start putting results
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int product = a * b;
                while (product > 0) { // populate results array
                    product += digits[index];
                    digits[index] = product % 10;
                    product /= 10;
                    index++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--)
            if (!(result.length() == 0 && digits[i] == 0)) // trim leading zeroes
                result.append(digits[i]);

        return result.length() == 0 ? "0" : result.toString();
    }
}
