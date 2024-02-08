package us.slemjet.leetcode.easy.tasks_51_100;

/**
 * 58. Length of Last Word
 */
public class LengthOfLastWord {

    /**
     * Time: O(l) -> 100.00%
     * Space: O(1) -> 61.27%
     */
    public int lengthOfLastWord(String s) {

        int result = 0;

        int idx = s.length() - 1;

        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }

        while (idx >= 0 && s.charAt(idx) != ' ') {
            result++;
            idx--;
        }

        return result;
    }
}
