package us.slemjet.leetcode.hard.from_100_to_150;

/**
 * 132. Palindrome Partitioning II
 */
public class PalindromePartitioningII {

    /**
     * Time: O(n^2) -> 84.56%
     * Space: O(n^2) -> 72.93%
     */
    public int minCut(String s) {

        int length = s.length();

        // Min cuts for each index
        int[] cuts = new int[length];

        // DP array to quickly check if is palindrome
        boolean[][] isPalindrome = new boolean[length][length];

        for (int right = 1; right < length; right++) {

            // Initialize with max cuts - for every symbol
            cuts[right] = right;

            // Go from start and check if can re-partition with less cuts
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || isPalindrome[left + 1][right - 1])) {
                    // If is palindrome - try to reduce cuts
                    isPalindrome[left][right] = true;
                    if (left == 0) {
                        cuts[right] = 0;
                    } else {
                        cuts[right] = Math.min(cuts[right], cuts[left - 1] + 1); // Get cuts from where previous palindrome end + 1
                    }
                }
            }
        }

        return cuts[cuts.length - 1];
    }
}
