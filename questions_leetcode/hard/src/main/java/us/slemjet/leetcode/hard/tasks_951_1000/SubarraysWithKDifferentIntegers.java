package us.slemjet.leetcode.hard.tasks_951_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 992. Subarrays with K Different Integers
 */
public class SubarraysWithKDifferentIntegers {

    /**
     * Time: O(n)   ->  32.39%
     * Space:O(n)   ->  34.74%
     */
    public int subarraysWithKDistinct(int[] nums, int k) {

        return subarraysLessThan(nums, k) - subarraysLessThan(nums, k - 1); // Its easier to keep track of count less than k
    }

    private int subarraysLessThan(int[] nums, int k) {

        int count = 0;
        Map<Integer, Integer> countByNum = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int numRight = nums[right];
            countByNum.put(numRight, countByNum.getOrDefault(numRight, 0) + 1);

            while (countByNum.keySet().size() > k) {
                // Shrink array
                int leftNum = nums[left];
                countByNum.put(leftNum, countByNum.getOrDefault(leftNum, 0) - 1);
                if (countByNum.get(leftNum) == 0) {
                    countByNum.remove(leftNum);
                }
                left++;
            }
            count += (right - left + 1);
        }

        return count;
    }
}
