package us.slemjet.leetcode.easy.tasks_351_400;

/**
 * 389. Find the Difference
 */
public class FindTheDifference {

    /**
     * Get the occurrences of first (shorter) and remove with occurrences of second (longer)
     * The one <0 is the answer
     * <p>
     * Runtime: 40.98%
     * Memory Usage: 14.79%
     */
    public char findTheDifference(String s, String t) {

        int[] counts = new int[26]; // Stores all chars counts

        for (char aChar : s.toCharArray()) {
            counts[aChar - 'a']++;
        }

        for (char aChar : t.toCharArray()) {
            counts[aChar - 'a']--;
            if (counts[aChar - 'a'] < 0) return aChar; // Less chars than in original -> extra char
        }

        return 0;
    }

    /**
     * Count sums of all chars of string 1 - sum of all chars in string 2
     * Difference is the searched character
     *
     * Runtime: 54.13%
     * Memory Usage: 13.92%
     */
    public char findTheDifferenceSums(String s, String t) {

        int diffChar = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            diffChar += t.charAt(i) - s.charAt(i);
        }

        return (char) diffChar;
    }
}
