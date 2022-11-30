package us.slemjet.leetcode.easy.from_1201_to_1250;

import java.util.*;

/**
 * 1207. Unique Number of Occurrences
 */
public class UniqueNumberOfOccurrences {

    /**
     * Runtime: 67.10%
     * Memory Usage: 8.81%
     */
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : arr) {
            Integer count = counts.getOrDefault(number, 0) + 1;
            counts.put(number, count);
        }

        Set<Integer> countSet = new HashSet<>();
        for (Integer count : counts.values()) {
            if (!countSet.add(count)) return false;
        }

        return true;
    }
}
