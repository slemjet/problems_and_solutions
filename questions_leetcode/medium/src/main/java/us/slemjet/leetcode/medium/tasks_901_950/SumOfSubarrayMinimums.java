package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.Stack;

/**
 * 907. Sum of Subarray Minimums
 */
public class SumOfSubarrayMinimums {

    /**
     * Monotonic stack
     * Calculate contribution of each element to the range sum
     * It is number value * number of subarrays where it is minimum
     */
    public int sumSubarrayMins(int[] arr) {

        int modulo = (int) (Math.pow(10, 9) + 7); // We use modulo to handle super large numbers

        Stack<Integer> stack = new Stack<>();
        long sumOfMinimums = 0;

        // building monotonically increasing stack
        for (int i = 0; i <= arr.length; i++) {

            // when i reaches the array length, it is an indication that
            // all the elements have been processed, and the remaining
            // elements in the stack should now be popped out.

            while (!stack.empty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {

                // Notice the sign ">=", This ensures that no contribution
                // is counted twice. rightBoundary takes equal or smaller
                // elements into account while leftBoundary takes only the
                // strictly smaller elements into account

                int mid = stack.pop();
                int leftBoundary = stack.empty() ? -1 : stack.peek(); // Previous lesser item
                int rightBoundary = i; // Since remove item current is smaller so it s index is boundary

                // count of subarrays where mid is the minimum element
                long count = (mid - leftBoundary) * (rightBoundary - mid) % modulo;

                sumOfMinimums += (count * arr[mid]) % modulo;
                sumOfMinimums %= modulo;
            }
            stack.push(i);
        }

        return (int) (sumOfMinimums);
    }

    /**
     * Use Monotonic stack + DP combination
     *
     */
    public int sumSubarrayMinsDp(int[] arr) {

        int modulo = (int) (Math.pow(10, 9) + 7); // We use modulo to handle super large numbers

        Stack<Integer> stack = new Stack<>();

        // make a dp array of the same size as the input array `arr`
        int[] dp = new int[arr.length];

        // making a monotonic increasing stack
        for (int i = 0; i < arr.length; i++) {
            // pop the stack until it is empty or
            // the top of the stack is greater than or equal to
            // the current element
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            // either the previousSmaller element exists
            if (stack.size() > 0) {
                int previousSmaller = stack.peek();
                dp[i] = dp[previousSmaller] + (i - previousSmaller) * arr[i];
            } else {
                // or it doesn't exist, in this case the current element
                // contributes with all subarrays ending at i
                dp[i] = (i + 1) * arr[i];
            }
            // push the current index
            stack.push(i);
        }

        // Add all elements of the dp to get the answer
        long sumOfMinimums = 0;
        for (int count : dp) {
            sumOfMinimums += count;
            sumOfMinimums %= modulo;
        }

        return (int) sumOfMinimums;
    }
}
