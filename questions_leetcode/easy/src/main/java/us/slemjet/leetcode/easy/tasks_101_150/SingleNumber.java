package us.slemjet.leetcode.easy.tasks_101_150;

/**
 * 136. Single Number
 */
public class SingleNumber {

    /**
     * Runtime: 95.42%
     * Memory Usage: 54.40%
     */
    public int singleNumber(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            // XOR twice gives 0 so only element appearing once remains
            sum = sum ^ num;
        }
        return sum;
    }
}
