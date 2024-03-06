package us.slemjet.leetcode.medium.tasks_2551_2600.tasks;

/**
 * 2571. Minimum Operations to Reduce an Integer to 0
 */
public class MinimumOperationsToReduceAnIntegerTo0 {

    /**
     * Go from the least significant bit to most significant bit
     * Check set bits. If isolated bit is set - just unset it
     * If series of bits are set - unset them as a group by adding 1 to smallest set bit and then unsetting result bit
     * 1000111100 -> + 100 -> 1001000000
     *
     *  Time:O(n)   ->  100.00%
     *  Space:O(1)  ->  91.92%
     */
    public int minOperations(int n) {

        int currentBit = 0;
        int bits = 0; // Number of bits set so far
        int result = 0;

        while (n != 0 || bits != 0) {

            if ((n & (1 << currentBit)) == 0) { // If bit is 0
                if (bits > 1) {
                    // We need to set current bit since we used shorthand operation
                    n ^= (1 << currentBit); // Toggle bit - set bit
                }
                if (bits > 0) {
                    result++;
                    bits = 0;
                }
            }

            if ((n & (1 << currentBit)) != 0) { // If bit is 1
                n ^= (1 << currentBit); // Toggle bit - Unset bit
                bits++;
            }
            currentBit++;
        }

        return result;
    }
}
