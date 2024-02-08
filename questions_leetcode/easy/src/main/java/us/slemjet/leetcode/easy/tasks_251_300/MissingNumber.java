package us.slemjet.leetcode.easy.tasks_251_300;

/**
 * 268. Missing Number
 */
public class MissingNumber {

    /**
     * Runtime: 100.00%
     * Memory Usage: 49.36%
     */
    public int missingNumber(int[] nums) {

        int result = 0;

        for (int i = 1; i <= nums.length; i++) {
            result = result ^ i;
        }

        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

}
