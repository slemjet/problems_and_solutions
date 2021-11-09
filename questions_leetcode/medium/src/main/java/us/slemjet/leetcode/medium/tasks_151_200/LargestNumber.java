package us.slemjet.leetcode.medium.tasks_151_200;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 179. Largest Number
 */
public class LargestNumber {

    /**
     * Runtime: 30.57%
     * Memory Usage: 77.43%
     */
    public String largestNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                break;
            }
            if (i == nums.length - 1) {
                return "0";
            }
        }

        return IntStream.of(nums).mapToObj(String::valueOf)
                .sorted((o1, o2) -> -Long.compare(Long.parseLong(o1 + o2), Long.parseLong(o2 + o1)))
                .collect(Collectors.joining());
    }
}
