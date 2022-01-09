package us.slemjet.leetcode.easy.from_351_to_400;

public class RansomNote {

    /**
     * Runtime: 2 ms, faster than 98.09%
     * Memory Usage: 39.8 MB, less than 59.51%
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] letters = new int[26];

        for (char letter : magazine.toCharArray()) {
            int index = letter - 'a';
            letters[index]++;
        }

        for (char letter : ransomNote.toCharArray()) {
            int index = letter - 'a';
            letters[index]--;
            if (letters[index] < 0) {
                return false;
            }
        }

        return true;
    }
}
