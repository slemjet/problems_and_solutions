package us.slemjet.leetcode.easy.from_201_to_250;

/**
 * 242. Valid Anagram
 */
public class ValidAnagram {

    /**
     * Runtime: 79.89%
     * Memory Usage: 94.70%
     */
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length
                ()) return false;
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            letters[idx]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            letters[idx]--;
            if (letters[idx] < 0) {
                return false;
            }
        }

        return true;
    }
}
