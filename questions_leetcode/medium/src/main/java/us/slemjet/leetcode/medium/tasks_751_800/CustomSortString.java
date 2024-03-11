package us.slemjet.leetcode.medium.tasks_751_800;

/**
 * 791. Custom Sort String
 */
public class CustomSortString {

    /**
     * Time: O(n)   ->  75.87%
     * Space:O(n)   ->  85.81%
     */
    public String customSortString(String order, String s) {

        // For each char set its position in order
        Integer[] positions = new Integer[26];
        for (int i = 0; i < order.length(); i++) {
            positions[order.charAt(i) - 'a'] = i;
        }

        // Count how many chars that are in order are in s
        int[] counts = new int[order.length()];
        // If char is not on order - just add it to rest
        StringBuilder rest = new StringBuilder();

        for (char sChar : s.toCharArray()) {
            if (positions[sChar - 'a'] != null) {
                counts[positions[sChar - 'a']]++;
            } else {
                rest.append(sChar);
            }
        }

        StringBuilder result = new StringBuilder();

        // Populate all the chars from s that are in order accoring to their counts
        for (int i = 0; i < counts.length; i++) {
            result.append(String.valueOf(order.charAt(i)).repeat(Math.max(0, counts[i])));
        }

        // Append rest chars
        result.append(rest);

        return result.toString();
    }
}
