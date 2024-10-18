package us.slemjet.leetcode.easy.tasks_2051_2100;

/**
 * 2068. Check Whether Two Strings are Almost Equivalent
 */
public class CheckWhetherTwoStringsAreAlmostEquivalent {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  73.59%
     */
    public boolean checkAlmostEquivalent(String word1, String word2) {

        int[] counts = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            counts[word1.charAt(i) - 'a']++;
            counts[word2.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (Math.abs(count) > 3) return false;
        }

        return true;
    }
}
