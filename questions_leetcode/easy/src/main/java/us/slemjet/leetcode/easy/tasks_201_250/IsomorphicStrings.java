package us.slemjet.leetcode.easy.tasks_201_250;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. Isomorphic Strings
 */
public class IsomorphicStrings {

    /**
     * Time: O(n)   ->  58.83%
     * Space:O(n)   ->  79.50%
     */
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMapping = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!charMapping.containsKey(sChar)) {
                // Need to add new mapping
                // Check if target char is not mapped to another source char
                if (mappedChars.contains(tChar)) {
                    return false;
                } else {
                    // Add new source to target chars mapping
                    charMapping.put(sChar, tChar);
                    mappedChars.add(tChar);
                }
            }

            char expectedTChar = charMapping.get(sChar);
            if (expectedTChar != tChar) {
                // Chars do not match
                return false;
            }

        }

        return true;
    }
}
