package us.slemjet.leetcode.medium.tasks_1_50;

import java.util.HashMap;

/**
 * 1. Two Sum
 */
public class TwoSum {

    /**
     * Runtime: 57.11%
     * Memory Usage: 7.06%
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complementsByIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (complementsByIndex.containsKey(nums[i])) {
                Integer complementIndex = complementsByIndex.get(nums[i]);
                return new int[]{complementIndex, i};
            } else
                complementsByIndex.put(target - nums[i], i);
        }

        return new int[]{};
    }
}
