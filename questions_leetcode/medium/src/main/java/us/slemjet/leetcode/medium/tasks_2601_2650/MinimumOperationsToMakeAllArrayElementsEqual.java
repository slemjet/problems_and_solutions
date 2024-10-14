package us.slemjet.leetcode.medium.tasks_2601_2650;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2602. Minimum Operations to Make All Array Elements Equal
 */
public class MinimumOperationsToMakeAllArrayElementsEqual {

    /**
     * Time: O((q+n)logn)   ->  98.78%
     * Space:O(n)           ->  93.19%
     */
    public List<Long> minOperations(int[] nums, int[] queries) {

        List<Long> result = new ArrayList<>();

        // Sort to be able to use binary search to find element
        Arrays.sort(nums);

        int length = nums.length;
        // Shift index by 1 to avoid extra checks
        long[] prefixSums = new long[length + 1];
        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int query : queries) {
            long sum = 0L;

            int index = Arrays.binarySearch(nums, query);
            if (index < 0) {
                index = -(index + 1);
            }

            long leftSum = query * (long) index - prefixSums[index];
            long rightSum = prefixSums[length] - prefixSums[index] - query * (long) (length - index);
            sum += leftSum + rightSum;

            result.add(sum);

        }

        return result;
    }
}
