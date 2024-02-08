package us.slemjet.leetcode.easy.tasks_251_300;

/**
 * 283. Move Zeroes
 */
public class MoveZeroes {

    /**
     * Shift non-zero values as far forward as possible
     * Fill remaining space with zeros
     *
     * Runtime: 100.00%
     * Memory Usage: 52.50%
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    /** 2 pointer
     * Runtime: 46.48%
     * Memory Usage: 52.50%
     */
    public void moveZeroes2Pointer(int[] nums) {

        // Use 2 pointers - for zero and non-zero, move to next values and swap
        int zeroIdx = 0; // Track next 0
        while (zeroIdx < nums.length && nums[zeroIdx] != 0) zeroIdx++;

        int valueIdx = zeroIdx + 1; // Track next non-0
        while (valueIdx < nums.length && nums[valueIdx] == 0) valueIdx++;

        while (valueIdx < nums.length && zeroIdx < nums.length){
            // Swap values
            nums[zeroIdx] = nums[valueIdx];
            nums[valueIdx] = 0;
            valueIdx++;
            zeroIdx++;
            while (zeroIdx < nums.length && nums[zeroIdx] != 0) zeroIdx++;
            while (valueIdx < nums.length && nums[valueIdx] == 0) valueIdx++;
        }
    }
}
