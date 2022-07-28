package us.slemjet.leetcode.medium.tasks_101_150;

/**
 * 137. Single Number II
 */
public class SingleNumberII {

    /**
     * Magical solution
     * Runtime: 94.58%
     * Memory Usage: 27.98%
     */
    public int singleNumber(int[] nums) {

        int one = 0;
        int two = 0;

        for (int num : nums) {
            one = one ^ num;
            one = one & ~two;

            two = two ^ num;
            two = two & ~one;
        }

        return one;
    }

    /**
     * Count bits that are not divisible by 3
     *
     * Runtime: 34.92%
     * Memory Usage: 59.73%
     */
    public int singleNumberCountBits(int[] nums) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int num : nums) {
                if ((num >> i & 1) == 1) { // Check if value set the bit
                    sum++;
                    sum = sum % 3; // We need only bits that are not x3
                }
            }
            if (sum != 0) {
                result = result | sum << i; // Set flag for result
            }
        }

        return result;
    }
}
