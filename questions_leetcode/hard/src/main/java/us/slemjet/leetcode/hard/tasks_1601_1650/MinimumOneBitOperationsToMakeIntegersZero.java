package us.slemjet.leetcode.hard.tasks_1601_1650;

/**
 * 1611. Minimum One Bit Operations to Make Integers Zero
 */
public class MinimumOneBitOperationsToMakeIntegersZero {

    /**
     *
     */
    public int minimumOneBitOperations(int n) {

        if (n == 0) {
            return 0;
        }

        char[] bits = Integer.toBinaryString(n).toCharArray();
        // Generate number of operations, needed to change every bit
        int[] dp = new int[bits.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            if (i == dp.length - 1) {
                dp[i] = 1;
            } else {
                dp[i] = 2 * (2 << dp.length - (i + 2)) - 1;
            }
        }

        int result = dp[0];
        // We need to remove operation for every bit except for largest one
        // If there are more than one other bit than two '-' give '+'
        int flag = -1;
        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == '1') {
                result = result + flag * dp[i];
                flag *= -1;
            }
        }

        return result;
    }
}
