package us.slemjet.leetcode.easy.from_1701_to_1750;

import java.util.Set;

/**
 * 1704. Determine if String Halves Are Alike
 */
public class DetermineIfStringHalvesAreAlike {

    /**
     * Runtime: 56.44%
     * Memory Usage: 28.04%
     */
    public boolean halvesAreAlike(String s) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count = 0;

        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (vowels.contains(s.charAt(start++))) {
                count++;
            }

            if (vowels.contains(s.charAt(end--))) {
                count--;
            }
        }

        return count == 0;
    }
}
