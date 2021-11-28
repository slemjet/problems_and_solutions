package us.slemjet.leetcode.easy.from_201_to_250;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 */
public class ContainsDuplicate {

    /**
     * Runtime: 63.87%
     * Memory Usage: 44.19%
     */
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            if (numbers.contains(num))
                return true;
            else numbers.add(num);
        }
        return false;
    }
}
