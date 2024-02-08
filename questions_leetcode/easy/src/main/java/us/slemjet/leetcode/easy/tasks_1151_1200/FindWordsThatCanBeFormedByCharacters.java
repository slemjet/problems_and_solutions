package us.slemjet.leetcode.easy.tasks_1151_1200;

/**
 * 1160. Find Words That Can Be Formed by Characters
 */
public class FindWordsThatCanBeFormedByCharacters {

    /**
     * Time: O(n) -> 85.21%
     * Space: O(n) -> 95.86%
     */
    public int countCharacters(String[] words, String chars) {

        int result = 0;

        int[] charCount = new int[26];

        for (char aChar : chars.toCharArray()) {
            charCount[aChar - 'a']++;
        }

        for (String aWord : words) {
            if (canAddWord(aWord, charCount)) {
                result += aWord.length();
            }
        }

        return result;
    }

    private static boolean canAddWord(String aWord, int[] charCount) {

        int[] charCountCopy = new int[26];
        System.arraycopy(charCount, 0, charCountCopy, 0, 26);

        for (char aChar : aWord.toCharArray()) {
            charCountCopy[aChar - 'a']--;
            if (charCountCopy[aChar - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
