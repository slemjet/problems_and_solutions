package us.slemjet.leetcode.easy.from_100_to_150;

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
            sum = sum ^ num;
        }
        return sum;
    }
}
