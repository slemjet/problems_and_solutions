package us.slemjet.leetcode.medium.tasks_2551_2600;

import java.util.Arrays;

/**
 * 2563. Count the Number of Fair Pairs
 */
public class CountTheNumberOfFairPairs {

    /**
     * Time: O(n log n)     ->  59.34%
     * Space: O(1)          ->  23.83%
     */
    public long countFairPairs2Pointers(int[] nums, int lower, int upper) {

        long result = 0L;
        Arrays.sort(nums);

        long lessThanLowerCount = countLessThan(nums, lower);
        long lessOrEqualThanUpperCount = countLessThan(nums, upper + 1);

        result += lessOrEqualThanUpperCount - lessThanLowerCount;

        return result;
    }

    private long countLessThan(int[] nums, int bound) {
        int left = 0;
        int right = nums.length - 1;

        long count = 0L;
        while (left < right) {
            int currSum = nums[left] + nums[right];
            if (currSum < bound) {
                count += right - left;
                left++; // next index
            } else {
                right--; // need to reduce sum
            }
        }

        return count;
    }


    /**
     * Time: O(n log n) ->  5.58%
     * Space: O(1)      ->  50.11%
     */
    public long countFairPairsBinarySearch(int[] nums, int lower, int upper) {

        long result = 0L;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int lowerBound = lower - num; // < lower
            int upperBound = upper - num + 1; // <= upper

            int lessThanLower = getLowerBound(nums, i + 1, nums.length - 1, lowerBound);
            int lessOrEqualThanUpper = getLowerBound(nums, i + 1, nums.length - 1, upperBound);

            int currCount = lessOrEqualThanUpper - lessThanLower;
            result += currCount;

        }

        return result;
    }

    private static int getLowerBound(int[] nums, int left, int right, int boundValue) {

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] < boundValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
