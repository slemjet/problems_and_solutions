package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 */
public class KthLargestElementInAnArray {

    /**
     * Use Priority queue
     * Runtime: 44.35%
     * Memory Usage: 97.55%
     */
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int nextVal : nums) {
            // Remove last value that is less than
            if (!queue.isEmpty() && queue.peek() < nextVal && queue.size() >= k) {
                queue.poll();
            }
            // Add new node in ascending order
            if (queue.isEmpty() || queue.peek() < nextVal || queue.size() < k) {
                queue.add(nextVal);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
