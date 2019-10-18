package us.slemjet.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSumBrute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // sort to remove duplicates later

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; // remove already processed value as duplicate
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumHash(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // sort to remove duplicates later

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; // remove already processed value as duplicate

            // now it is reduced to list of 2Sums tasks
            HashMap<Integer, Integer> complementsByIndex = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (complementsByIndex.containsKey(nums[j])) {
                    Integer complementIndex = complementsByIndex.get(nums[j]);
                    result.add(Arrays.asList(nums[i], nums[j], nums[complementIndex]));
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++; // to skip duplicates
                } else
                    complementsByIndex.put(-nums[i] - nums[j], j);
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2Pointers(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // sort to remove duplicates later
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; // remove already processed value as duplicate
            // set 2 pointers from opposite sides
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    // solution found
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j + 1 < nums.length && nums[j] == nums[j - 1]) j++; // to skip duplicates
                } else if (nums[i] + nums[j] + nums[k] < 0)
                    j++; // too small with this index i
                else
                    k--; // too big with this index i
            }
        }
        return result;
    }
}
