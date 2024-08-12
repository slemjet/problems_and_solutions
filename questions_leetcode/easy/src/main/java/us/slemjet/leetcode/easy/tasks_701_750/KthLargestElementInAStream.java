package us.slemjet.leetcode.easy.tasks_701_750;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 703. Kth Largest Element in a Stream
 */
public class KthLargestElementInAStream {

    /**
     * Time: 28.03% O(nlogk)
     * Space: 87.97% O(1)
     */
    static class KthLargest {

        PriorityQueue<Integer> queue;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;

            queue = new PriorityQueue<>(Comparator.naturalOrder());
            IntStream.of(nums).boxed().forEach(integer -> {
                queue.offer(integer);
                // We need only k largest
                if (queue.size() > k) {
                    queue.remove();
                }
            });
        }

        public int add(int val) {
            queue.offer(val);

            if (queue.size() > k) {
                queue.remove();
            }
            return queue.peek();
        }
    }
}
