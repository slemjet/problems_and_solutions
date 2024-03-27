package us.slemjet.leetcode.medium.tasks_701_750;

/**
 * 713. Subarray Product Less Than K
 */
public class SubarrayProductLessThanK {

    /**
     * Use sliding window.
     * Keep product inside window < k - valid
     * Add number of combinations that can be formed with new (rightmost) element
     * + 1 (element itself)
     * + 1 for each other number in the sequence as it can form a new combination with it
     * <p>
     * Time: O(n) 100.00%
     * Space:O(n): 95.04%
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;

        int start = 0, end = 0, product = 1;

        while (end < nums.length) {
            product *= nums[end];

            while (product >= k && start < end) { // Product is too big - need to decrease
                product /= nums[start];
                start++;
            }

            if (product < k) {
                count += end - start + 1; // We add combinations number: 1 for current number + 1 for each number in the sequence
            }

            end++;
        }

        return count;
    }


}
