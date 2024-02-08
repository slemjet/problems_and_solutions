package us.slemjet.leetcode.hard.tasks_1651_1700;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 1675. Minimize Deviation in Array
 */
public class MinimizeDeviationInArray {

    /**
     * Runtime: 45.31%
     * Memory Usage: 53.13%
     */
    public int minimumDeviation(int[] nums) {

        int result = Integer.MAX_VALUE;

        // Min will become min of all the even values - so it is maximum min we can get
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) nums[i] *= 2;
            min = Math.min(min, nums[i]);
            queue.offer(nums[i]);
        }

        // While max value is even so we can divide it
        while (!queue.isEmpty() && queue.peek() % 2 == 0) {
            Integer max = queue.remove();
            result = Math.min(result, max - min);
            min = Math.min(min, max / 2);
            queue.offer(max / 2);
        }

        return Math.min(result, queue.peek() - min);
    }

    /**
     * Runtime: 65.63%
     * Memory Usage: 64.06%
     */
    public int minimumDeviationTreeSet(int[] nums) {

        int result = Integer.MAX_VALUE;

        TreeSet<Integer> ordered = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Make all values even and add to treeset (ordered)
            if (nums[i] % 2 == 1) nums[i] *= 2;
            ordered.add(nums[i]);
        }

        while (true) {
            int min = ordered.first();
            int max = ordered.last();

            result = Math.min(result, max - min);

            if (max % 2 == 0) {
                // Max can be decreased
                ordered.remove(max);
                ordered.add(max / 2);
            } else {
                // Can no longer decrease max
                return result;
            }
        }
    }
}
