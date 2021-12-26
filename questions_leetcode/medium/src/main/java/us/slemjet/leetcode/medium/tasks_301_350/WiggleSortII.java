package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II
 */
public class WiggleSortII {

    /**
     * Use median and quickselect for partitioning of elements around median
     *
     * Runtime: 5.12%
     * Memory Usage: 24.17%
     */
    public void wiggleSort(int[] nums) {

        int size = nums.length;
        int mid = (size + 1) / 2;
        int[] copy = Arrays.copyOf(nums, size);
        int median = findKthLargest(nums, mid);

        // Arrange all elements around median
        for (int lowIdx = 0, currIdx = 0, highIdx = size - 1; currIdx <= highIdx; ) {
            if (copy[currIdx] < median) {
                swap(copy, currIdx++, lowIdx++);
            } else if (copy[currIdx] > median) {
                swap(copy, currIdx, highIdx--);
            } else {
                currIdx++;
            }
        }

        int largerIdx = nums.length - 1;
        int smallerIdx = largerIdx / 2;
        int currIdx = 0;

        while (smallerIdx >= 0) {
            nums[currIdx++] = copy[smallerIdx--];
            if (currIdx < nums.length)
                nums[currIdx++] = copy[largerIdx--];
        }
    }

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

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * Naive approach - sort and split halves, populate alternatively one value from end and one from median
     * <p>
     * Runtime: 68.61%
     * Memory Usage: 90.14%
     */
    public void wiggleSortNaive(int[] nums) {

        Arrays.sort(nums);

        int[] result = new int[nums.length];

        int largerIdx = nums.length - 1;
        int smallerIdx = largerIdx / 2;
        int currIdx = 0;

        while (smallerIdx >= 0) {
            result[currIdx++] = nums[smallerIdx--];
            if (currIdx < result.length)
                result[currIdx++] = nums[largerIdx--];
        }

        System.arraycopy(result, 0, nums, 0, result.length);
    }
}
