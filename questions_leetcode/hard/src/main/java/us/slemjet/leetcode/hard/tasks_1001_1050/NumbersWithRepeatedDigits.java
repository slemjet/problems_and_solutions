package us.slemjet.leetcode.hard.tasks_1001_1050;

import java.util.*;

/**
 * 1012. Numbers With Repeated Digits
 */
public class NumbersWithRepeatedDigits {

    /**
     * Time: O(n)   -> 85.71%
     * Space:O(1)   -> 58.16%
     */
    public int numDupDigitsAtMostN(int n) {
        int unique = countUnique(n);
        return n - unique;
    }

    private int countUnique(int n) {
        List<Integer> digits = new ArrayList<>();
        n++;
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }

        Collections.reverse(digits);
        int m = digits.size();
        int unique = 0;

        // Step 1: Count numbers with value less than m
        for (int i = 1; i < m; i++) {
            unique += 9 * permutation(9, i - 1);
        }

        // Step 2: Count numbers with the same value
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int digit = digits.get(i);
            for (int j = (i == 0 ? 1 : 0); j < digit; j++) {
                if (!seen.contains(j)) {
                    unique += permutation(9 - i, m - i - 1);
                }
            }
            if (seen.contains(digit)) break;
            seen.add(digit);
        }

        return unique;
    }

    private int permutation(int m, int n) {
        if (n == 0) return 1;
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= (m - i);
        }
        return result;
    }
}
