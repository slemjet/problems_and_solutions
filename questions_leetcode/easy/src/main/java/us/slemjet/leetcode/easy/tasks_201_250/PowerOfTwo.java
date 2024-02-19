package us.slemjet.leetcode.easy.tasks_201_250;

/**
 * 231. Power of Two
 */
public class PowerOfTwo {

    /**
     * Power of 2 will have only one bit set - use inverted number that will have all ones except for biggest
     * Time: O(1)   -> 49.23%
     * Space:O(1)   -> 98.10%
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return n == (n & -n);
    }

    /**
     * Power of 2 will have only one bit set - use bitcount
     * Time: O(logn)   -> 49.23%
     * Space:O(1)   -> 56.93%
     */
    public boolean isPowerOfTwoBitCount(int n) {
        if (n <= 0) {
            return false;
        }

        return Integer.bitCount(n) == 1;
    }

    /**
     * Recursion
     * Time: O(logn)   ->  49.23%
     * Space:O(1)   ->  22.68%
     */
    public boolean isPowerOfTwoRecursion(int n) {

        if (n == 1 || n == 2) {
            return true;
        }
        if (n == 0 || n % 2 == 1) {
            return false;
        }
        return isPowerOfTwoRecursion(n / 2);
    }

    /**
     * Iterative
     * Time: O(logn)   ->  100.00%
     * Space:O(1)   ->  32.10%
     */
    public boolean isPowerOfTwoIterative(int n) {

        while (n > 2) {
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }

        return n > 0;
    }
}
