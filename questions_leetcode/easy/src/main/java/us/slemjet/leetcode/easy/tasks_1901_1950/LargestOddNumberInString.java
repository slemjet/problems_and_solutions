package us.slemjet.leetcode.easy.tasks_1901_1950;

/**
 * 1903. Largest Odd Number in String
 */
public class LargestOddNumberInString {

    /**
     * Time: O(1) -> 100.00%
     * Space: O(1) -> 17.34%
     */
    public String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {
            char charAt = num.charAt(i);
            if (charAt == '1' || charAt == '3' || charAt == '5' || charAt == '7' || charAt == '9') {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
