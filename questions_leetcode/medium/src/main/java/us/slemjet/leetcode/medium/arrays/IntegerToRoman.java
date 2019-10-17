package us.slemjet.leetcode.medium.arrays;

public class IntegerToRoman {

    public String intToRoman(int num) {

        if (num < 1)
            return "";

        StringBuilder result = new StringBuilder();

        int[] digits = new int[4];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }

        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];
            if (digit == 0) continue;

            if (digit == 9) {
                result.append(getPrefix(i, false))
                        .append(intToRoman(nextDigit(digit + 1, digits.length - 1 - i)));
            } else if (digit == 4) {
                result.append(getPrefix(i, false))
                        .append(intToRoman(nextDigit(digit + 1, digits.length - 1 - i)));
            } else if (digit < 4) {
                result.append(getPrefix(i, false))
                        .append(intToRoman(nextDigit(digit - 1, digits.length - 1 - i)));
            } else {
                result.append(getPrefix(i, true))
                        .append(intToRoman(nextDigit(digit - 5, digits.length - 1 - i)));
            }
        }
        return result.toString();
    }

    private int nextDigit(int nextNumber, int nextDigit) {
        return (int) (nextNumber * Math.pow(10, nextDigit));
    }

    private String getPrefix(int i, boolean isForFive) {
        switch (i) {
            case 0:
                return isForFive ? "C" : "M";
            case 1:
                return isForFive ? "D" : "C";
            case 2:
                return isForFive ? "L" : "X";
            case 3:
                return isForFive ? "V" : "I";
        }
        return getPrefix(i, true);
    }


    public String intToRoman2(int num) {
        int[] arabic = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arabic.length; i++) {
            while (num - arabic[i] >= 0) {
                result.append(roman[i]);
                num = num - arabic[i];
            }
        }
        return result.toString();
    }
}
