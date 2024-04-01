package us.slemjet.leetcode.medium.tasks_151_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /**
     * Time: O(n)   ->  46.65%
     * Space:O(n)   ->  69.35%
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int result = 0;

        Map<Character, Integer> countByChar = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;

        for (int right = 0; right < chars.length; right++) {
            char rightChar = chars[right];
            countByChar.put(rightChar, countByChar.getOrDefault(rightChar, 0) + 1);

            while (countByChar.keySet().size() > 2) {
                char leftChar = chars[left];
                countByChar.put(leftChar, countByChar.get(leftChar) - 1);
                if (countByChar.get(leftChar) == 0) {
                    countByChar.remove(leftChar);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
