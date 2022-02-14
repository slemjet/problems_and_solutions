package us.slemjet.leetcode.medium.tasks_201_250;

/**
 * 209. Minimum Size Subarray Sum
 */
public class MinimumSizeSubarraySum {

    /**
     * Use 2 pointers move right if sum < target
     * move left if sum >= target + check for min length
     * <p>
     * Runtime: 99.96%
     * Memory Usage: 32.16%
     */
    public int minSubArrayLen2Pointers(int target, int[] nums) {

        int result = Integer.MAX_VALUE;
        boolean hasSolution = false;

        int left = 0, right = 1, currSum = nums[0];

        while (right < nums.length) {

            while (right < nums.length && currSum < target) {
                currSum += nums[right];
                right++;
            }

            while (left <= right && currSum >= target) {
                hasSolution = true;
                result = Math.min(result, right - left); // Got candidate - check if is shortest

                currSum -= nums[left];
                left++;
            }
        }

        return hasSolution ? result : 0;
    }

    /**
     * Calculate prefix sums
     * For each value search for complement so its sum with target is >=
     * Use binary search since prefix sums array is sorted
     *
     * Runtime: 12.87%
     * Memory Usage: 5.59%
     */
    public int minSubArrayLenSort(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        boolean hasSolution = false;

        // Populate with prefix sums
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        // For each value use binary search to find complement with target
        for (int i = 0; i < nums.length; i++) {
            int complement = target;
            if (i > 0) complement += nums[i - 1];
            if (nums[nums.length - 1] < complement) continue; // No complement exists

            int complementIdx = binarySearch(nums, i, nums.length - 1, complement);
            result = Math.min(result, complementIdx - i + 1);
            hasSolution = true;
        }

        return hasSolution ? result : 0;
    }

    private int binarySearch(int[] nums, int left, int right, int value) {

        if (left == right) return left;
        int mid = left + (right - left) / 2;

        if (nums[mid] < value) {
            return binarySearch(nums, mid + 1, right, value);
        } else {
            return binarySearch(nums, left, mid, value);
        }
    }
}
