package us.slemjet.leetcode.easy.tasks_451_500;

/**
 * 476. Number Complement
 */
public class NumberComplement {

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 36.1 MB, less than 56.51%
     */
    public int findComplement(int num) {

        // To flip byte we XOR current value with all bits of current values set to 1
        // so 1 ^ 1 will become 1 and 1 ^ 0 will become 1 as expected

        int highestOne = Integer.highestOneBit(num) << 1;
        int allOnes = highestOne - 1;
        return num ^ allOnes;
    }
}
