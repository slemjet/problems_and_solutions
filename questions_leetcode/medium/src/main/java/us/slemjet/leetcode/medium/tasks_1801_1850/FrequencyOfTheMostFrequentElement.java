package us.slemjet.leetcode.medium.tasks_1801_1850;

import java.util.Arrays;

/**
 * 1838. Frequency of the Most Frequent Element
 */
public class FrequencyOfTheMostFrequentElement {

    /**
     * Use sliding window
     * Time: O(nlogn) 76.07%
     * Space: O(n) 16.34%
     */
    public int maxFrequency(int[] nums, int k) {

        // Sort array
        Arrays.sort(nums);
        int result = 0;

        int currentSum = 0, currentCount = 0, currentValue = 0;

        int right = nums.length - 1;
        int left = right - 1;
        currentCount++;
        currentValue = nums[right];

        while (left <= right && left >= 0) {

            currentSum += (currentValue - nums[left]);
            currentCount++;

            if (currentSum <= k) {
                result = Math.max(result, currentCount);
            } else {
                // Sum too big - move left
                while (left <= right && currentSum > k) {
                    right--;
                    currentCount--;
                    currentSum -= currentCount * (currentValue - nums[right]);
                    currentValue = nums[right];
                }
            }
            left--;
        }

        return Math.max(result, currentCount);
    }

    /**
     * binarySearch + preifxSums
     *
     * Time: O(nlogn) -> 6.68%
     * Space: O(n) -> 16.34%
     */
    public int maxFrequencyBinarySearch(int[] nums, int k) {

        int result = 0;

        Arrays.sort(nums);

        // Prefix sums array to count sum quickly
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            // Get index closes to the left (with max count)
            int minIdx = getMinIdx(i, nums, prefixSum, k);
            int maxCountCandidate = i - minIdx + 1;
            result = Math.max(result, maxCountCandidate);
        }

        return result;
    }

    private int getMinIdx(int idx, int[] nums, long[] prefixSum, int k) {

        int targetValue = nums[idx]; // Common target value for all elements
        int left = 0;
        int right = idx;
        int bestIdx = idx;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = idx - mid + 1; // Count elements to be incremented to common value
            long targetSum = count * targetValue; // Total target sum after all increments
            long currentSum = prefixSum[idx] - prefixSum[mid] + nums[mid]; // Current sum
            long increments = targetSum - currentSum; // How many increments needed

            if (increments <= k) {
                // Found one candidate
                bestIdx = mid;
                // Try to increase number of elements
                right = mid - 1;
            } else {
                // Too many elements - cannot increment all
                left = mid + 1;
            }
        }
        return bestIdx;
    }
}
