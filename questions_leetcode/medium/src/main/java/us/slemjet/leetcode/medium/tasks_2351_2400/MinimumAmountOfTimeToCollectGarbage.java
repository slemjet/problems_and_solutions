package us.slemjet.leetcode.medium.tasks_2351_2400;

import java.util.HashMap;
import java.util.Map;

/**
 * 2391. Minimum Amount of Time to Collect Garbage
 */
public class MinimumAmountOfTimeToCollectGarbage {

    /**
     * Time O(garbage*travel) : -> 37.12%
     * Space: O(1) -> 43.50%
     *
     */
    public int garbageCollection(String[] garbage, int[] travel) {

        // 1. Accumulate prefix sums in travel array
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        // 2. Count number of garbage + mark last position
        Map<Character, Integer> lastIndex = new HashMap<>();
        int[] garbageTypes = new int[]{'M', 'P', 'G'};

        int result = 0;
        for (int i = 0; i < garbage.length; i++) {
            String currentGarbage = garbage[i];
            result += currentGarbage.length(); // All garbage needs to be collected

            for (char garbageType : currentGarbage.toCharArray()) {
                lastIndex.put(garbageType, i); // Add last position for each garbage
            }
        }

        // 3. Count all travel time for each garbage type
        for (int garbageType : garbageTypes) {
            Integer lastIndexOf = lastIndex.get((char) garbageType);
            if (lastIndexOf != null && lastIndexOf > 0) {
                result += travel[lastIndexOf - 1]; // Accumulate all travels
            }
        }

        return result;
    }
}
