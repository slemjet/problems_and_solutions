package us.slemjet.leetcode.two_sum;

import java.util.HashMap;

class Solution {
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