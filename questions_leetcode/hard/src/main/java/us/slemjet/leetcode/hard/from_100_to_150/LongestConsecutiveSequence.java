package us.slemjet.leetcode.hard.from_100_to_150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {

    /**
     * Runtime: 30.51%
     * Memory Usage: 46.42%
     */
    public int longestConsecutive(int[] nums) {

        int result = 0;

        HashMap<Integer, Integer> boundaries = new HashMap<>();

        for (int value : nums) {
            if (!boundaries.containsKey(value)) { // else is duplicate
                // check adjustment values
                int leftLength = boundaries.getOrDefault(value - 1, 0);
                int rightLength = boundaries.getOrDefault(value + 1, 0);

                int newLength = leftLength + rightLength + 1;
                boundaries.put(value, newLength);

                result = Math.max(newLength, result);

                // extend boundaries if intersects
                boundaries.put(value - leftLength, newLength);
                boundaries.put(value + rightLength, newLength);
            }
        }
        return result;
    }

    /**
     * Runtime: 58.62%
     * Memory Usage: 29.08%
     */
    public int longestConsecutiveHash(int[] nums) {

        int result = 0;

        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }

        for (int value : numbers) {
            // Skip as it will be included in a different sequence
            if (!numbers.contains(value - 1)) {
                int localMax = 1;
                while (numbers.contains(++value)) {
                    localMax++;
                }
                result = Math.max(result, localMax);
            }
        }
        return result;
    }
}
