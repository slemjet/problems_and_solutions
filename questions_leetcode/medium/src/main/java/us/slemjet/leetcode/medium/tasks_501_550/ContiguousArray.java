package us.slemjet.leetcode.medium.tasks_501_550;

/**
 * 525. Contiguous Array
 */
public class ContiguousArray {

    /**
     * Runtime: 35 ms, faster than 30.85%
     * Memory Usage: 98.2 MB, less than 5.02%
     */
    public int findMaxLength(int[] nums) {

        int maxLength = 0;
        int startIdx = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] || i == nums.length - 1) {
                if ((i - startIdx + 1) % 2 == 0) {
                    maxLength = Math.max(maxLength, i - startIdx + 1);
                } else {
                    maxLength = Math.max(maxLength, i - startIdx);
                }

                startIdx = i;
            }
        }

        return maxLength;
    }


    /**
     * Runtime: 5 ms, faster than 99.39%
     * Memory Usage: 48.6 MB, less than 90.97%
     */
    public int findMaxLengthArr(int[] nums) {

        int maxLength = 0;
        int sum = nums.length;

        // Contains sums by index - we can use them to check length between same sums (so delta sum is 0 - array is contiguous)
        int[] countByIdx = new int[nums.length * 2 + 2];
        // Set start conditions
        countByIdx[nums.length] = 1;

        for (int i = 0; i < nums.length; i++) {

            int val = nums[i];

            if (val == 0) {
                sum--;
            } else {
                sum++;
            }

            if (countByIdx[sum] > 0) {
                // index already visited - relative sum between is 0
                maxLength = Math.max(maxLength, i + 2 - countByIdx[sum]);
            } else {
                countByIdx[sum] = i + 2;
            }
        }

        return maxLength;
    }
}
