package us.slemjet.leetcode.easy.tasks_1651_1700;

/**
 * 1662. Check If Two String Arrays are Equivalent
 */
public class CheckIfTwoStringArraysAreEquivalent {

    /**
     * Time: O(n) ->  12.08%
     * Space: O(1) -> 43.24%
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        // Point to current word2 and char2
        int currWord2Idx = 0;
        int currChar2Idx = 0;
        boolean noMoreWord2 = false;
        for (String currWord1 : word1) {
            for (char currChar1 : currWord1.toCharArray()) {
                if (noMoreWord2) {
                    return false;
                }
                if (currChar1 != word2[currWord2Idx].charAt(currChar2Idx)) {
                    return false;
                }
                // Get next char2
                if (currChar2Idx < word2[currWord2Idx].length() - 1) {
                    // There is still char
                    currChar2Idx++;
                } else if (currWord2Idx < word2.length - 1) {
                    // There is still word
                    currChar2Idx = 0;
                    currWord2Idx++;
                } else {
                    noMoreWord2 = true;
                }
            }
        }

        return noMoreWord2;
    }
}
