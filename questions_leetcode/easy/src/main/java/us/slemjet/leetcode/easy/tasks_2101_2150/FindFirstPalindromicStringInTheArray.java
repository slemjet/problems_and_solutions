package us.slemjet.leetcode.easy.tasks_2101_2150;

/**
 * 2108. Find First Palindromic String in the Array
 */
public class FindFirstPalindromicStringInTheArray {

    /**
     * Time: O(n)   ->  49.73%
     * Space:O(1)    ->  91.24%
     */
    public String firstPalindrome(String[] words) {

        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String word) {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i <= wordChars.length / 2; i++) {
            if (wordChars[i] != wordChars[wordChars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
