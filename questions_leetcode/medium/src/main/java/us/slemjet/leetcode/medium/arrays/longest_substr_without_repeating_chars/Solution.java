package us.slemjet.leetcode.medium.arrays.longest_substr_without_repeating_chars;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int length = 0;
        Map<String, Integer> existingCharacters = new HashMap<>();
        String[] strings = s.split("");
        int start = 0, end = 0;
        while (end < strings.length) {
            String string = strings[end];
            if (!existingCharacters.containsKey(string)) {
                existingCharacters.put(string, end++);
                length = Math.max(length, end - start);
            } else {
                String storedValue = strings[start];
                existingCharacters.remove(storedValue);
                start++;
            }
        }
        return length;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int biggestLength = 0;
        Map<String, Integer> existingCharacters = new HashMap<>();
        int length = 0;

        String[] characters = s.split("");
        for (int i = 0; i < characters.length; i++) {
            String character = characters[i];
            if (existingCharacters.containsKey(character)) {
                biggestLength = Math.max(length, biggestLength);

                i = existingCharacters.get(character);
                existingCharacters = new HashMap<>();
                length = 0;
            } else {
                existingCharacters.put(character, i);
                length++;
            }
        }

        return Math.max(length, biggestLength);
    }
}
