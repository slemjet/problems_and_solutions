package us.slemjet.leetcode.medium.tasks_1301_1350;

/**
 * 1328. Break a Palindrome
 */
public class BreakAPalindrome {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  56.13%
     */
    public String breakPalindrome(String palindrome) {

        char[] chars = palindrome.toCharArray(); // Chars array is faster
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        if (chars.length > 1) {
            chars[chars.length - 1] = 'b';
            return new String(chars);
        }

        return "";
    }
}
