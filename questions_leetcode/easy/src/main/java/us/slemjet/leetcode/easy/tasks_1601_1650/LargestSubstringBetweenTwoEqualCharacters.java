package us.slemjet.leetcode.easy.tasks_1601_1650;

import java.util.Arrays;

/**
 * 1624. Largest Substring Between Two Equal Characters
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    /**
     * Time: O(n)   ->  8.27%
     * Space: O(1)  ->  5.26%
     */
    public int maxLengthBetweenEqualCharacters(String s) {

        int result = -1;

        int[] firstPosition = new int[26];
        Arrays.fill(firstPosition, -1);

        for (int i = 0; i < s.toCharArray().length; i++) {
            int charNum = s.charAt(i) - 'a';
            if (firstPosition[charNum] == -1) {
                // Store index of first occurrence of character
                firstPosition[charNum] = i;
            } else {
                // Max length = current char idx - idx of first position of this char
                result = Math.max(result, (i - 1) - firstPosition[charNum]);
            }
        }

        return result;
    }
}
