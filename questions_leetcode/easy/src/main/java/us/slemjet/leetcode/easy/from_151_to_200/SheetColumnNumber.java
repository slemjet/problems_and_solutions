package us.slemjet.leetcode.easy.from_151_to_200;

/**
 * 171. Excel Sheet Column Number
 */
public class SheetColumnNumber {

    /**
     * Runtime: 100.00%
     * Memory Usage: 98.61%%
     */
    public int titleToNumber(String columnTitle) {

        int result = 0;
        int scale = 0;
        char[] chars = columnTitle.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int number = chars[i] - 'A' + 1;
            // 26 is the base for calculation like 10 fore decimal and 16 for hex
            number = (int) (number * Math.pow(26, scale++));
            result += number;
        }

        return result;
    }
}
