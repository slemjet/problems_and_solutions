package us.slemjet.leetcode.easy.tasks_2051_2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2094. Finding 3-Digit Even Numbers
 */
public class Finding3DigitEvenNumbers {

    /** Use recursion to get all combinations of numbers
     *
     * Runtime: 66.93%
     * Memory Usage: 33.84%
     */
    public int[] findEvenNumbersRec(int[] digits) {

        List<Integer> results = new ArrayList<>();
        Arrays.sort(digits);

        int[] indices = new int[3];
        Arrays.fill(indices, -1);
        findEvenNumbers(digits, results, indices, 0);

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findEvenNumbers(int[] digits, List<Integer> results, int[] indices, int idx) {

        if (idx == indices.length) { // Reached end - add result to combinations
            int result = 0;
            for (int index : indices) {
                result = result * 10 + digits[index];
            }
            results.add(result);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (idx == 0 && digits[i] == 0) continue; // Cannot start from 0
            if (idx > 0 && indices[0] == i) continue; // Already used
            if (idx > 1 && (indices[1] == i || digits[i] % 2 != 0)) continue; // Already used or is odd
            indices[idx] = i; // Can use this digit
            findEvenNumbers(digits, results, indices, idx + 1);
            while (i < digits.length - 1 && digits[i] == digits[i + 1]) i++; // Skip duplicates
            indices[idx] = -1; // Backtrack
        }
    }

    /**
     * Iterate through all even three digit integers and check if cen form it using current digits
     *
     * Runtime: 66.93%
     * Memory Usage: 32.43%
     */
    public int[] findEvenNumbersCheckAll(int[] digits) {
        if (digits == null || digits.length == 0) return new int[0];

        int[] occurrence = new int[10];
        for (int digit : digits) occurrence[digit]++;

        List<Integer> results = new ArrayList<>();

        // Check all even numbers
        for (int i = 100; i < 1000; i += 2) {
            int first = i / 100;
            int second = (i % 100) / 10;
            int third = i % 10;
            occurrence[first]--; occurrence[second]--; occurrence[third]--; // Use the digits

            if (occurrence[first] >= 0 && occurrence[second] >= 0 && occurrence[third] >= 0) {
                results.add(i); // Can add number
            }
            occurrence[first]++; occurrence[second]++; occurrence[third]++;
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
