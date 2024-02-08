package us.slemjet.leetcode.easy.tasks_101_150;

/**
 * 125. Valid Palindrome
 */
public class ValidPalindrome {

    /**
     * Runtime: 97.72%
     * Memory Usage: 89.01%
     */
    public boolean isPalindrome(String s) {

        int leftIdx = 0;
        int rightIdx = s.length() - 1;

        while (leftIdx < rightIdx) {
            char leftChar = s.charAt(leftIdx);
            while (!Character.isLetterOrDigit(leftChar) && leftIdx < s.length() - 1) {
                leftIdx++;
                leftChar = s.charAt(leftIdx);
            }

            char rightChar = s.charAt(rightIdx);
            while (!Character.isLetterOrDigit(rightChar) && 0 < rightIdx) {
                rightIdx--;
                rightChar = s.charAt(rightIdx);
            }

            if (leftIdx > rightIdx)
                return true;

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
                return false;

            rightIdx--;
            leftIdx++;
        }

        return true;
    }
}
