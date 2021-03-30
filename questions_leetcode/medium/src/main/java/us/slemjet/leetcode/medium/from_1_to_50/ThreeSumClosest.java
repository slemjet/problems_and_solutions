package us.slemjet.leetcode.medium.from_1_to_50;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - currSum);
                if(diff == 0)
                    return currSum;

                if (diff < Math.abs(target - closestSum))
                    closestSum = currSum;

                if (target - currSum > 0)
                    j++;
                else
                    k--;
            }
        }
        return closestSum;
    }
}
