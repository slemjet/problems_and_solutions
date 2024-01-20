package us.slemjet.leetcode.medium.tasks_351_400;

/**
 * 396. Rotate Function
 */
public class RotateFunction {

    /**
     * Time: O(n)   -> 81.54%
     * Space:O(1)   -> 71.28%
     */
    public int maxRotateFunction(int[] nums) {

        int max = 0;

        // Count F(0)
        int sumDigits = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sumDigits += num;
            max += i * num;
        }

        // Calculate all F(n)
        // Recurrence relation: F(n) = F(n - 1) + sumDigits - nums[last i] * totalDigits
        // Each function we increment all counts by 1 and set number with larges counts to 0
        int currSum = max;
        for (int i = 1; i < nums.length; i++) {
            int numSetToZero = nums[nums.length - i];
            currSum = currSum + sumDigits - numSetToZero * nums.length;
            max = Math.max(max, currSum);
        }

        return max;
    }
}
