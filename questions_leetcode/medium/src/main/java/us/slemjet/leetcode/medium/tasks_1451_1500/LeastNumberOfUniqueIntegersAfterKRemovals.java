package us.slemjet.leetcode.medium.tasks_1451_1500;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1481. Least Number of Unique Integers after K Removals
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {

    /**
     * Time: O(nlogn)   ->  45.68%
     * Space:O(n)       ->  21.66%
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        // Calculate count by values
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, 1 + counts.getOrDefault(num, 0));
        }

        // Sort by count descending as we try to remove the minimum counts first - te remove maximum number of numbers
        List<Integer> sortedByCount = counts.values().stream().sorted().toList();

        for (int i = 0; i < sortedByCount.size(); i++) {
            Integer count = sortedByCount.get(i);

            if (count <= k) {
                k -= count;
            } else {
                return counts.size() - i; // No more numbers left - return rest
            }
        }

        return 0;
    }
}
