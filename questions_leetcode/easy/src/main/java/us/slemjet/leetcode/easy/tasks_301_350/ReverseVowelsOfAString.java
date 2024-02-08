package us.slemjet.leetcode.easy.tasks_301_350;

import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 */
public class ReverseVowelsOfAString {

    /**
     * Runtime: 86.05%
     * Memory Usage: 91.78%
     *
     * Space: O(1)
     * Time: O(n)
     */
    public String reverseVowels(String s) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] chars = s.toCharArray();

        // Use 2 pointers
        int left = 0;
        int right = chars.length - 1;

        while (left <= right) {

            // Shift left until find vowel or reach end
            while (left < chars.length && !vowels.contains(chars[left])) left++;
            if (left >= chars.length) break;

            // Shift right until find vowel or reach start
            while (right >= 0 && !vowels.contains(chars[right])) right--;
            if (right < 0) break;

            if(left >= right) break;

            // Swap
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
