package us.slemjet.leetcode.medium.tasks_1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) // remove duplicates
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) // remove duplicates
                    continue;

                int k = j + 1, l = nums.length - 1; // 2 pointers from opposite sides
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) k++; // remove duplicates
                    }

                    if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return result;
    }
}
