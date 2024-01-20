package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.HashMap;

/**
 * 397. Integer Replacement
 */
public class IntegerReplacement {

    /**
     * Time: O(n)   ->  100.00%
     * Space: O(n)  ->  15.18%
     */
    public int integerReplacement(int n) {

        return integerReplacement(n, new HashMap<>());
    }

    private int integerReplacement(int n, HashMap<Integer, Integer> memo) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2, memo);
        }

        int count;
        if (n == Integer.MAX_VALUE) {
            // Cannot exceed max int
            count = integerReplacement(n - 1, memo);
        } else {
            count = 1 + Math.min(integerReplacement(n - 1, memo), integerReplacement(n + 1, memo));
        }
        memo.put(n, count);

        return count;
    }
}
