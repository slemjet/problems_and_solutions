package us.slemjet.leetcode.medium.tasks_2101_2050;

import java.util.Stack;

/**
 * 2104. Sum of Subarray Ranges
 */
public class SumOfSubarrayRanges {

    /**
     * Time: O(n)   ->  68.85%
     * Space:O(n)   ->  19.31%
     */
    public long subArrayRanges(int[] nums) {

        long result = 0L;

        Stack<Integer> stack = new Stack<>();

        // Process minimum contributions
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() &&
                    (i == nums.length || nums[stack.peek()] >= nums[i])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                result -= (long) nums[mid] * (i - mid) * (mid - left);
            }
            stack.push(i);
        }

        // Reset stack for maximum processing
        stack.clear();

        // Process maximum contributions
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() &&
                    (i == nums.length || nums[stack.peek()] <= nums[i])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                result += (long) nums[mid] * (i - mid) * (mid - left);
            }
            stack.push(i);
        }

        return result;
    }
}
