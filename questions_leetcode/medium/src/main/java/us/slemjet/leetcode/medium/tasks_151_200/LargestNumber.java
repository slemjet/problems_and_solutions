package us.slemjet.leetcode.medium.tasks_151_200;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 179. Largest Number
 */
public class LargestNumber {

    /**
     * Runtime: 47.64%
     * Memory Usage: 77.43%
     */
    public String largestNumber(int[] nums) {

        // Compare combinations of values = 9 and 91 -> 991 > 919
        String result = IntStream.of(nums).mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());
        // Handle edge case with 0 only
        return result.charAt(0) == '0' ? "0" : result;
    }
}
