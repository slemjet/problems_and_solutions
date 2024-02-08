package us.slemjet.leetcode.easy.tasks_1401_1450;

/**
 * 1422. Maximum Score After Splitting a String
 */
public class MaximumScoreAfterSplittingAString {

    /**
     * Time: O(n) -> 97.78%
     * Space: O(1) -> 32.44%
     */
    public int maxScore(String s) {

        int ones = 0;

        for (char bitChar : s.toCharArray()) {
            if (bitChar == '1') {
                ones++;
            }
        }

        int result = 0;
        int zeroes = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--; // Remove one count from the right
            } else {
                zeroes++; // Add new zero to the left
            }
            result = Math.max(result, zeroes + ones);
        }

        return result;
    }

    public int maxScoreOnePass(String s) {

        int ones = 0;
        int zeroes = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeroes++;
            }
            result = Math.max(result, zeroes - ones);
        }

        // Count last one
        if(s.charAt(s.length() - 1) == '1'){
            ones++;
        }

        return result + ones;
    }
}
