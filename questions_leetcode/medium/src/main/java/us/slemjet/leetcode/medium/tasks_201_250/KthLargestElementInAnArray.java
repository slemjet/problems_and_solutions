package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 */
public class KthLargestElementInAnArray {

    /**
     * Runtime: 10.29%
     * Memory Usage: 34.85%
     */
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int low, int high, int k) {
        int left = low; // All the elements less than pivot start from this position
        int pivot = high; // Pivot is the last one (random)
        // Move all elements less than pivot to the left and all that greater - to the right
        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[pivot]) {
                swap(nums, left++, i);
            }
        }
        swap(nums, left, pivot); // Move pivot to the right border of the lesser partition

        int count = high - left + 1;

        if (count == k) return nums[left]; // Solution found

        if (count <= k) // Partition left part
            return partition(nums, low, left - 1, k - count);
        else // Partition right part
            return partition(nums, left + 1, high, k);
    }

    private void swap(int[] nums, int first, int second) {
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }


    /**
     * Use Priority queue
     * Runtime: 44.35%
     * Memory Usage: 97.55%
     */
    public int findKthLargestQueue(int[] nums, int k) {

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
