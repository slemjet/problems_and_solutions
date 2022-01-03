package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 */
public class TopKFrequentElements {

    /**
     * Use BucketSort
     *
     * Runtime: 49.47%
     * Memory Usage: 78.80%
     */
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;

        // Create counts map
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            maxCount = Math.max(maxCount, count);
            counts.put(num, count);
        }

        // Buckets [count] = value
        List<Integer>[] buckets = new List[maxCount + 1];
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (buckets[entry.getValue()] == null) buckets[entry.getValue()] = new ArrayList<>();
            buckets[entry.getValue()].add(entry.getKey());
        }

        // Copy k max bucket values to result
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k ; i--) {
            if(buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Use PriorityQueue
     *
     * Runtime: 12.37%
     * Memory Usage: 8.20%
     */
    public int[] topKFrequentPriorityQueue(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        counts.entrySet().forEach(queue::add);

        int[] result = new int[k];
        for (int i = result.length - 1; i >= 0; i--) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            result[i] = poll.getKey();
        }

        return result;
    }

    /**
     * Use Quickselect
     * <p>
     * Runtime: 32.85%
     * Memory Usage: 15.27%
     */
    public int[] topKFrequentQSelect(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int[][] pairs = new int[counts.size()][2];
        int i = 0;
        for (int num : counts.keySet())
            pairs[i++] = new int[]{num, counts.get(num)};

        i = findKthLargestIdx(pairs, k);

        int[] result = new int[pairs.length - i];
        for (int j = i, m = 0; m < result.length; j++, m++) {
            result[m] = pairs[j][0];
        }

        return result;
    }

    public int findKthLargestIdx(int[][] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[][] nums, int low, int high, int k) {
        int left = low; // All the elements less than pivot start from this position
        int pivot = high; // Pivot is the last one (random)
        // Move all elements less than pivot to the left and all that greater - to the right
        for (int i = low; i < high; i++) {
            if (nums[i][1] <= nums[pivot][1]) {
                swap(nums, left++, i);
            }
        }
        swap(nums, left, pivot); // Move pivot to the right border of the lesser partition

        int count = high - left + 1;

        if (count == k) return left; // Solution found

        if (count <= k) // Partition left part
            return partition(nums, low, left - 1, k - count);
        else // Partition right part
            return partition(nums, left + 1, high, k);
    }

    private void swap(int[][] nums, int i, int j) {
        int[] t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
