package us.slemjet.leetcode.hard.numbers;

import java.util.Arrays;

public class FirstMissingPositive {

    /**
     * Runtime: 37.76%
     * Memory Usage: 100.00%
     *
     * @param nums
     * @return
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
     *
     * We store elements to their index by value [3, 4, -1, 1] - > [1, 0, 3, 4, 0]
     * then traverse and check missing value
     *
     * @param nums
     * @return
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

}
