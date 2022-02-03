package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 945. Minimum Increment to Make Array Unique
 */
public class MinimumIncrementToMakeArrayUnique {

    /**
     * Sort and count increments
     * <p>
     * Runtime: 50.00%
     * Memory Usage: 51.55%
     */
    public int minIncrementForUnique(int[] nums) {

        int result = 0;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int delta = nums[i - 1] - nums[i] + 1;
                nums[i] += delta;
                result += delta;
            }
        }

        return result;
    }

    /**
     * Use buckets for each number -> move to next bucket if > 1
     *
     * Runtime: 87.47%
     * Memory Usage: 52.45%
     */
    public int minIncrementForUniqueBuckets(int[] nums) {

        int max = IntStream.of(nums).max().orElse(0);
        int result = 0;

        int[] buckets = new int[max + 1]; // Buckets containing numbers
        for (int num : nums) buckets[num]++;

        for (int i = 0; i < buckets.length - 1; i++) {
            if(buckets[i] <= 1) continue; // Count is ok
            int delta = buckets[i] - 1; // Need to increment all extra numbers -> move them to next bucket
            buckets[i + 1] += delta;
            result += delta;
        }

        while (buckets[buckets.length - 1] >= 1){ // Process tail -> all remaining values need to shift also if > 1
            buckets[buckets.length - 1]--;
            result += buckets[buckets.length - 1];
        }

        return result;
    }
}
