package us.slemjet.leetcode.medium.tasks_1001_1050;

/**
 * 1004. Max Consecutive Ones III
 */
public class MaxConsecutiveOnesIII {

    /**
     * Time:    O(n)    ->  87.63%
     * Space:   O(1)    ->  17.49%
     */
    public int longestOnesSliding(int[] nums, int k) {
        int left = 0, right = 0;
        int result = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            // Check if the number of zeros exceeds k - move left boundary
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}