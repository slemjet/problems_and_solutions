package us.slemjet.leetcode.medium.from_1_to_50;

import java.util.HashMap;

public class TwoSum {
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
