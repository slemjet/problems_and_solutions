package us.slemjet.leetcode.medium.tasks_901_950;

/**
 * 930. Binary Subarrays With Sum
 */
public class BinarySubarraysWithSum {

    /**
     * Use Prefix sums to keep track of the count of elements with a specific sum
     * Time: O(n)   ->  83.28%
     * Space:O(n)   ->  41.43%
     */
    public int numSubarraysWithSum(int[] nums, int goal) {

        int result = 0;
        int[] countBySum = new int[nums.length + 1];
        int currSum = 0;

        for (int num : nums) {
            currSum += num;

            // Increment if sum match
            if (currSum == goal) {
                result++;
            }
            // Check how many counts are for currSum that will sum with currSum up to goal
            if (currSum - goal >= 0) {
                result += countBySum[currSum - goal];
            }
            // Add new count
            countBySum[currSum]++;
        }

        return result;
    }
}
