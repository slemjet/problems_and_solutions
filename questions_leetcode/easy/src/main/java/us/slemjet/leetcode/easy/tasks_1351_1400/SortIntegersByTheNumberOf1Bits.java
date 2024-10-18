package us.slemjet.leetcode.easy.tasks_1351_1400;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1356. Sort Integers by The Number of 1 Bits
 */
public class SortIntegersByTheNumberOf1Bits {

    /**
     * Time: O(nlogn)    -> 23.88%
     * Space:O(n)        -> 14.09%
     */
    public int[] sortByBits(int[] arr) {

        return Arrays.stream(arr).boxed()
                .sorted(Comparator.comparingInt(Integer::bitCount)
                        .thenComparing(Comparator.naturalOrder()))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
