package us.slemjet.leetcode.medium.tasks_2851_2900.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * 2870. Minimum Number of Operations to Make Array Empty
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {

    /**
     * Time: O(nlogn)   ->  73.58%
     * Space:O(n)       ->  7.92%
     */
    public int minOperations(int[] nums) {

        int minCount = 0;

        Map<Integer, Integer> countByNumber = new HashMap<>();

        for (int num : nums) {
            countByNumber.put(num, countByNumber.getOrDefault(num, 0) + 1);
        }

        for (int counts : countByNumber.values()) {

            if (counts == 1) {
                // Cant solve if there is only one element
                return -1;
            }
            minCount += counts / 3; // Try to delete by all the 3's
            if (counts % 3 != 0) {
                // Need another operation to delete by 2 instead of by 3
                // This covers remainder 2 - just delete by 2 and 1 - need to delete by 4 (2*2) instead of 3
                minCount++;
            }
        }

        return minCount;
    }

}
