package us.slemjet.leetcode.easy.tasks_2401_2450;

import java.util.HashSet;
import java.util.Set;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {

    /**
     * Time: O(n)   ->  35.86%
     * Space:O(n)   ->  83.24%
     */
    public int findMaxK(int[] nums) {

        int result = -1;

        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
            if (numsSet.contains(-num)) {
                result = Math.max(result, Math.abs(num));
            }
        }

        return result;
    }
}
