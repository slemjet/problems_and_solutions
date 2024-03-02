package us.slemjet.leetcode.easy.tasks_951_1000;

/**
 * 977. Squares of a Sorted Array
 */
public class SquaresOfASortedArray {

    /**
     *  Time: O(n)  ->  100.00%
     *  Space:O(n)  ->  18.17%
     */
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        // Max negative is on the left max positive is on the right
        // Compare and take max of two
        while (left <= right) {
            if (nums[left] < 0 && nums[left] * -1 > nums[right]) {
                result[right - left] = nums[left] * nums[left];
                left++;
            } else {
                result[right - left] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }
}
