package us.slemjet.leetcode.medium.arrays.longest_palindromic_substr;

public class Solution {

    public String longestPalindrome(String s) {

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
