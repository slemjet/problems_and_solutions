package us.slemjet.leetcode.medium.tasks_1901_1950;

import java.util.HashMap;
import java.util.Map;

/**
 * 1915. Number of Wonderful Substrings
 */
public class NumberOfWonderfulSubstrings {

    /**
     * Time: O(n)   ->  30.19%
     * Space:O(n)   ->  72.64%
     */
    public long wonderfulSubstrings(String word) {

        long result = 0L;

        Map<Integer, Integer> countByBitmask = new HashMap<>();
        countByBitmask.put(0, 1);

        // Represent even odd characters count in the prefix by bitmask
        int bitmask = 0;

        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            bitmask ^= (1 << num); // Toggle parity of the prefix

            // Get existing result for prefix mask
            Integer countForMask = countByBitmask.getOrDefault(bitmask, 0);
            result += countForMask;
            // Increment count for current mask
            countByBitmask.put(bitmask, 1 + countForMask);

            // For every letter - change one count bit and add if result exists for it - add
            for (int otherNum = 0; otherNum < 10; otherNum++) {
                int candidateBitMask = bitmask ^ (1 << otherNum);

                result += countByBitmask.getOrDefault(candidateBitMask, 0);
            }
        }

        return result;
    }
}
