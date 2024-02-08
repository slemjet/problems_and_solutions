package us.slemjet.leetcode.easy.tasks_501_550;

/**
 * 520. Detect Capital
 */
public class DetectCapital {

    /**
     * Runtime: 32.84%
     * Memory Usage: 6.48%
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;

        boolean allCapital = Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1));
        for (int i = 1; i < word.length(); i++) {
            boolean isCapital = Character.isUpperCase(word.charAt(i));
            if (isCapital && !allCapital || !isCapital && allCapital) return false;
        }
        return true;
    }

    /**
     * Runtime: 59.30%
     * Memory Usage: 65.22%
     */
    public boolean detectCapitalUse2(String word) {
        return word.equals(word.toUpperCase()) ||
                word.equals(word.toLowerCase()) ||
                Character.isUpperCase(word.charAt(0)) &&
                        word.substring(1).equals(word.substring(1).toLowerCase());
    }
}
