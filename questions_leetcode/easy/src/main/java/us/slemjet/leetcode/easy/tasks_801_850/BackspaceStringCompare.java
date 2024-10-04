package us.slemjet.leetcode.easy.tasks_801_850;

/**
 * 844. Backspace String Compare
 */
public class BackspaceStringCompare {

    /**
     * Time: O(max(n,m))    ->  100%
     * Space:O(1)           ->  40.5%
     */
    public boolean backspaceCompare(String s, String t) {
        int sIdx = s.length() - 1;
        int tIdx = t.length() - 1;

        while (sIdx >= 0 || tIdx >= 0) {
            sIdx = processBackspaces(s, sIdx);
            tIdx = processBackspaces(t, tIdx);

            if (sIdx < 0 || tIdx < 0) {
                return sIdx < 0 && tIdx < 0; // Both must be less than 0
            } else if (s.charAt(sIdx) != t.charAt(tIdx)) {
                return false;
            }
            sIdx--;
            tIdx--;
        }
        return true;
    }

    private int processBackspaces(String str, int index) {
        int numHashes = 0;
        while (index >= 0 && (str.charAt(index) == '#' || numHashes > 0)) {
            if (str.charAt(index) == '#') {
                numHashes++;
            } else {
                numHashes--;
            }
            index--;
        }
        return index;
    }
}
