package us.slemjet.leetcode.easy.from_1851_to_1900;

/**
 * 1897. Redistribute Characters to Make All Strings Equal
 */
public class RedistributeCharactersToMakeAllStringsEqual {

    /**
     * Time: O(n) -> 43.02%
     * Space: O(1) -> 20.75%
     */
    public boolean makeEqual(String[] words) {

        int[] counts = new int[26];

        for (String word : words) {
            for (char aChar : word.toCharArray()) {
                counts[aChar - 'a']++;
            }
        }

        for (int count : counts) {
            if (count > 0 && count % words.length != 0) {
                // If char count is not equally distributed for every word
                return false;
            }
        }

        return true;
    }
}
