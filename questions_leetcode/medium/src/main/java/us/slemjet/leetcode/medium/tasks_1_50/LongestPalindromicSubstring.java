package us.slemjet.leetcode.medium.tasks_1_50;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

    /**
     * Runtime: 20.81%
     * Memory Usage: 13.85%
     */
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()]; // Is palindrome between indices (start, end)

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)) continue; // Need to be equal
                if (j + 1 < i - 1 && !dp[j + 1][i - 1]) continue; // Inner part (subsequence) also need to be palindrome

                dp[j][i] = true; // Is palindrome
                if (i - j > end - start) { // Check if is bigger
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }


    /**
     * Runtime: 36.09%
     * Memory Usage: 40.64%
     */
    public String longestPalindrome2(String s) {

        String longestPalindrome = "";
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            // check every palindrome center
            StringBuilder palindrome = new StringBuilder(split[i]);
            int shift = 0, k = 1;
            // check if need to shift for same chars "daaaad" case
            while (i + shift >= 0 && i + shift < split.length - 1 && split[i].equals(split[i + shift + 1])) {
                shift++;
                palindrome.append(split[i + shift]);
            }

            while (i - k >= 0 && i + k + shift <= split.length - 1 && split[i - k].equals(split[i + k + shift])) {
                palindrome = new StringBuilder(split[i - k] + palindrome + split[i + k + shift]);
                k++;
            }
            if (longestPalindrome.length() < palindrome.length()) {
                longestPalindrome = palindrome.toString();
            }
        }
        return longestPalindrome;
    }
}
