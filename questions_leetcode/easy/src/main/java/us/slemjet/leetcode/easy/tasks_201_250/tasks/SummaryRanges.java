package us.slemjet.leetcode.easy.tasks_201_250.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 */
public class SummaryRanges {

    /**
     * Runtime: 88.00%
     * Memory Usage: 17.29%
     */
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        int prevIdx = 0;

        for (int i = 1; i < nums.length; i++) {

            int deltaValue = nums[i] - nums[prevIdx];
            int deltaIdx = i - prevIdx;
            if (deltaValue == deltaIdx) continue;

            if (prevIdx == i - 1) result.add(String.valueOf(nums[prevIdx]));
            else result.add(String.format("%s->%s", nums[prevIdx], nums[i - 1]));
            prevIdx = i;
        }

        if (nums == null || nums.length == 0) return result;
        else if (prevIdx == nums.length - 1) result.add(String.valueOf(nums[prevIdx]));
        else result.add(String.format("%s->%s", nums[prevIdx], nums[nums.length - 1]));

        return result;
    }

    /**
     * Runtime: 87.65%
     * Memory Usage: 30.42%
     */
    public List<String> summaryRangesShort(int[] nums) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) i++;

            if (start == nums[i]) result.add(String.valueOf(nums[i]));
            else result.add(String.format("%s->%s", start, nums[i]));
        }

        return result;
    }
}
