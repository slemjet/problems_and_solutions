package us.slemjet.leetcode.medium.tasks_1151_1200;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1167. Minimum Cost to Connect Sticks
 */
public class MinimumCostToConnectSticks {

    /**
     * Time: O(nlogn)   ->  5.34%
     * Space:O(n)       ->  76.72%
     */
    public int connectSticks(int[] sticks) {

        int result = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int stick : sticks)
            queue.add(stick);

        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            result += sum;
            queue.add(sum);
        }

        return result;
    }
}
