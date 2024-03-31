package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * 340. Longest Substring with At Most K Distinct Characters
     * Time: O(n)   ->  53.28%
     * Space:O(n)   ->  48.12%
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int result = 0;
        char[] chars = s.toCharArray();

        Map<Character, Integer> countByNum = new HashMap<>();
        int left = 0;

        for (int right = 0; right < chars.length; right++) {
            char rightChar = chars[right];
            countByNum.put(rightChar, countByNum.getOrDefault(rightChar, 0) + 1);

            while (countByNum.keySet().size() > k) {
                char leftChar = chars[left];
                countByNum.put(leftChar, countByNum.get(leftChar) - 1);
                if (countByNum.get(leftChar) == 0) {
                    countByNum.remove(leftChar);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
