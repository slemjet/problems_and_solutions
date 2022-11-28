package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.HashMap;
import java.util.Map;

/**
 * 446. Arithmetic Slices II - Subsequence
 */
public class ArithmeticSlicesIISubsequence {

    /**
     * Runtime: 89.63%
     * Memory Usage: 88.41%
     *
     * Space: O(n^2)
     * Time: O(n^2)
     */
    public int numberOfArithmeticSlices(int[] nums) {

        int result = 0;
        Map<Integer, Integer>[] slices = new Map[nums.length];

        for (int i = 0; i < nums.length; i++) {
            slices[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diffLong = (long)nums[i] - nums[j];
                if(diffLong <= Integer.MIN_VALUE || diffLong > Integer.MAX_VALUE) continue;

                int diff = (int) diffLong;
                int slicesInI = slices[i].getOrDefault(diff, 0);
                int slicesInJ = slices[j].getOrDefault(diff, 0);

                result += slicesInJ; // Add new slices
                slices[i].put(diff, slicesInI + slicesInJ + 1);
            }
        }

        return result;
    }
}
