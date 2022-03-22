package us.slemjet.leetcode.medium.tasks_1601_1650;

import java.util.Arrays;

/**
 * 1663. Smallest String With A Given Numeric Value
 */
public class SmallestStringWithAGivenNumericValue {

    /**
     * Runtime: 65.08%
     * Memory Usage: 52.38%
     */
    public String getSmallestString(int n, int k) {

        char[] chars = new char[n];
        // Fill with 'a' - minimum possible values
        Arrays.fill(chars, 'a');
        k -= n;
        int currIdx = chars.length - 1;
        while (k > 0) {
            // Start adding value up to 'z' (+25) starting from right side
            chars[currIdx] += Math.min(25, k);
            // Remove added from sum
            k -= Math.min(25, k);
            currIdx--;
        }
        return new String(chars);
    }

    /**
     * Runtime: 30.16%
     * Memory Usage: 11.64%
     */
    public String getSmallestString2(int n, int k) {

        StringBuilder result = new StringBuilder();

        while (k > n) {
            if (k > 25 + n) {
                result.append('z');
                k -= 26;
            } else {
                result.append((char) ('a' + k - n));
                k = n - 1;
            }
            n--;
        }

        while (n-- > 0) result.append('a');

        return result.reverse().toString();
    }
}
