package us.slemjet.leetcode.medium.tasks_151_200;

import java.util.Arrays;

/**
 * 151. Reverse Words in a String
 */
public class ReverseWordsInAString {

    /**
     * Runtime: 96.84%
     * Memory Usage: 74.66%
     *
     * Space: O(1)
     * Time: O(n)
     */
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        // 1. Shift chars for 1+ spaces
        int i = 0, j = 0;

        while (j < chars.length) {
            if (chars[j] == ' ') {
                if (j == 0 || chars[j - 1] == ' ') {
                    j++;
                    continue;
                }
            }
            chars[i++] = chars[j++];
        }

        if (chars[i - 1] == ' ') i--; // Trim last char
        chars = Arrays.copyOf(chars, i);

        // 2. Reverse all chars
        reverse(chars, 0, chars.length - 1);

        // 3. Reverse each word
        i = 0;
        j = 0;
        while (i < chars.length) {
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            i = ++j;
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int from, int to) {
        char tmp;
        while (from < to) {
            tmp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = tmp;
        }
    }
}
