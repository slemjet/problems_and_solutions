package us.slemjet.leetcode.hard.tasks_1_50;

import java.util.Arrays;

/**
 * 41. First Missing Positive
 */
public class FirstMissingPositive {

    /**
     * Runtime: 37.76%
     * Memory Usage: 100.00%
     */
    public int firstMissingPositive(int[] nums) {

        int result = 1;
        if (nums.length == 0) return result;

        Arrays.sort(nums);

        int index = 0;
        while (index < nums.length && nums[index] <= 0) index++; // skipping non-positives

        while (index < nums.length) {
            if (index == 0 || nums[index] != nums[index - 1]) {
                if (nums[index] != result)
                    return result;
                result++;
            }
            index++;
        }

        return result == nums[nums.length - 1] ? ++result : result;
    }

    /**
     * Runtime: 100.00%
     * Memory 100.00%
     * <p>
     * We store elements to their index by value [3, 4, -1, 1] - > [1, 0, 3, 4, 0]
     * then traverse and check missing value
     */
    public int firstMissingPositiveIndexByValueAndSwap(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            // we swap until value is within range (0, nums.length) and it is not correctly positioned
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
        }

        // traverse and check if at any index value is incorrect (nums[i] != i + 1)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        nums[idx1] = nums[idx1] ^ nums[idx2];
        nums[idx2] = nums[idx1] ^ nums[idx2];
        nums[idx1] = nums[idx1] ^ nums[idx2];
    }

    /**
     * Time: O(n)   ->  98.00%
     * Space:O(1)   ->  83.26%
     */
    public int firstMissingPositive3(int[] nums) {

        boolean hasOne = false;

        // We dont need negatives
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
            if (nums[i] == 1) {
                hasOne = true;
            }
        }

        // Mark included indices by '-' Use special handling for 1
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length && num > 0) {
                if (nums[num - 1] > 0) {
                    nums[num - 1] *= -1;
                }
                if (nums[num - 1] == 0) {
                    nums[num - 1] = -1;
                }
            }
        }

        // Check for first non-negative index
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0){
                return i + 1;
            }
            if(nums[i] < 0 && i == 0 && !hasOne){
                return 1;
            }
        }

        return nums.length + 1;

    }


}
