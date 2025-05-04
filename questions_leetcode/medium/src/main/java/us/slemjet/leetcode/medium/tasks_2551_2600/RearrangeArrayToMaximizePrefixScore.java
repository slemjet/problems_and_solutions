package us.slemjet.leetcode.medium.tasks_2551_2600;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 2587. Rearrange Array to Maximize Prefix Score
 */
public class RearrangeArrayToMaximizePrefixScore {

    /**
     * Sort and count until sum is positive
     * Time:    O(nlogn):   10%
     * Space:   O(1)    :   93.27%
     */
    public int maxScoreSort(int[] nums) {

        int result = 0;

        // Sort to get highest numbers first to maximize sum
        Integer[] sorted = IntStream.of(nums).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);

        long prefix = 0L;

        for (Integer integer : sorted) {
            prefix += integer;
            if (prefix <= 0) {
                break;
            }
            result++;
        }

        return result;
    }
}
