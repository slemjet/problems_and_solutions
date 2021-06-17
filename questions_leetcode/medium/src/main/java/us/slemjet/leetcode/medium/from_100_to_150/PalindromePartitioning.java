package us.slemjet.leetcode.medium.from_100_to_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class PalindromePartitioning {

    /**
     * Runtime: 99.36%
     * Memory Usage: 84.72%
     */
    public List<List<String>> partitionDp(String s) {

        int length = s.length();
        boolean[][] palindromes = new boolean[length][length];
        List<List<String>> partitions = new ArrayList<>();
        dfsDp(0, s, partitions, new ArrayList<>(), palindromes);
        return partitions;
    }

    private void dfsDp(int start, String s, List<List<String>> partitions, List<String> current, boolean[][] palindromes) {
        if (start >= s.length()) {
            // Reached end of string
            partitions.add(new ArrayList<>(current));
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindromeDp(s, start, end, palindromes)) {
                // Add current
                palindromes[start][end] = true;
                current.add(s.substring(start, end + 1));
                dfsDp(end + 1, s, partitions, current, palindromes);
                // Remove current - backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindromeDp(String s, int start, int end, boolean[][] palindromes) {

        if (start == end) return true;

        char startChar = s.charAt(start);
        char endChar = s.charAt(end);
        if (startChar == endChar) {
            return end - start <= 2 || palindromes[start + 1][end - 1];
        }

        return false;
    }

    /**
     * Runtime: 77.00%
     * Memory Usage: 92.40%
     */
    public List<List<String>> partitionBfs(String s) {

        List<List<String>> partitions = new ArrayList<>();
        dfs(0, s, partitions, new ArrayList<>());
        return partitions;
    }

    private void dfs(int curr, String s, List<List<String>> partitions, List<String> current) {
        if (curr >= s.length()) {
            // Reached end of string
            partitions.add(new ArrayList<>(current));
        }

        for (int i = curr; i < s.length(); i++) {
            if (isPalindrome(s, curr, i)) {
                // Add current
                current.add(s.substring(curr, i + 1));
                dfs(i + 1, s, partitions, current);
                // Remove current - backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
