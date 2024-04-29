package us.slemjet.leetcode.medium.tasks_2951_3000;

/**
 * 2997. Minimum Number of Operations to Make Array XOR Equal to K
 */
public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  67.36%
     */
    public int minOperations(int[] nums, int k) {

        int result = 0;

        int xorEd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xorEd ^= nums[i];
        }

        while (xorEd != 0 || k != 0){
            if((1 & xorEd) != (1 & k)){
                // Bit does not match - would need to set
                result++;
            }
            xorEd = xorEd >> 1;
            k = k >> 1;
        }

        return result;
    }
}
