package us.slemjet.leetcode.easy.tasks_601_650;

/**
 * 645. Set Mismatch
 */
public class SetMismatch {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  31.90%
     */
    public int[] findErrorNums(int[] nums) {

        int[] counts = new int[nums.length + 1];

        for (int num : nums) {
            counts[num]++;
        }

        int[] result = new int[2];

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 1) {
                result[0] = i;
            }
            if (counts[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}
