package us.slemjet.leetcode.hard.tasks_851_900;

import java.util.Arrays;

/**
 * 899. Orderly Queue
 */
public class OrderlyQueue {

    /**
     * Runtime: 15.84%
     * Memory Usage: 26.73%
     *
     * Space: O(1) ... O(n)
     * Time: O(n)
     */
    public String orderlyQueue(String s, int k) {

        if (s.length() < 2) return s;

        if (k == 1) {
            // Can only rotate
            String current = s;
            String min = current;
            for (int i = 0; i < s.length(); i++) {
                current = current.substring(1) + current.charAt(0);
                min = min.compareTo(current) > 0 ? current : min;
            }
            return min;
        } else {
            // Can switch any chars within k (bubble sort)
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
