package us.slemjet.leetcode.easy.tasks_2851_2900;

/**
 * 2864. Maximum Odd Binary Number
 */
public class MaximumOddBinaryNumber {

    /**
     * Use 2 pointers
     *
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  98.64%
     */
    public String maximumOddBinaryNumber(String s) {

        char[] chars = s.toCharArray();

        int left = chars.length - 2;
        int right = chars.length - 1;
        if (chars[chars.length - 1] != '1') {
            // Need make odd first - set last '1'
            while (left < right && chars[right] != '1') {
                if (chars[left] == '1') {
                    chars[right] = '1';
                    chars[left] = '0';
                    break;
                }
                left--;
            }
        }

        // Maximize number - move all '1' to the left
        left = 0;
        right = chars.length - 2;

        while (left < right) {
            while (left < chars.length && chars[left] != '0') {
                left++;
            }
            while (right >= 0 && chars[right] != '1') {
                right--;
            }
            if (left < right) {
                chars[left] = '1';
                chars[right] = '0';
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
