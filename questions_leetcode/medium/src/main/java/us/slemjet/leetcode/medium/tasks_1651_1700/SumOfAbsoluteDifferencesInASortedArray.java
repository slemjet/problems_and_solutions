package us.slemjet.leetcode.medium.tasks_1651_1700;

/**
 * 1685. Sum of Absolute Differences in a Sorted Array
 */
public class SumOfAbsoluteDifferencesInASortedArray {

    /**
     * Time: O(n) -> 62.31%
     * Space: O(n) -> 66.86%
     */
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int size = nums.length;

        // 1. Create prefix sums array to easily get sum
        int[] prefixSum = new int[size];
        prefixSum[0] = nums[0];
        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int[] result = new int[size];

        // 2. go over each element and calculate sum of differences

        for (int i = 0; i < nums.length; i++) {

            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[size - 1] - prefixSum[i];

            int leftTotal = i * nums[i] - leftSum;
            int rightTotal = rightSum - (size - 1 - i) * nums[i];

            result[i] = leftTotal + rightTotal;
        }

        return result;
    }
}
