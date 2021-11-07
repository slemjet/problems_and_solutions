package us.slemjet.leetcode.medium.tasks_151_200;

/**
 * 172. Factorial Trailing Zeroes
 */
public class FactorialTrailingZeroes {

    /**
     * Runtime: 100.00%
     * Memory Usage: 43.29%
     */
    public int trailingZeroes(int n) {

        int result = 0 ;

        // We need to count occurrences of 5 since 10 is coming from 5 * 2
        // count = n/5 + n/25 + n/125 .....
        while(n != 0){
            result += n/5;
            n /= 5;
        }

        return result;
    }
}
