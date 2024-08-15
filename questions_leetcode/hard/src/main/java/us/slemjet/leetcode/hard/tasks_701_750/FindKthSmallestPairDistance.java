package us.slemjet.leetcode.hard.tasks_701_750;

import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance
 */
public class FindKthSmallestPairDistance {

    /**
     * Use Binary search + 2 pointers
     * <p>
     * Time:    O(nlogn)   ->  96.24%
     * Space:   O(1)       ->  52.29%
     */
    public int smallestDistancePair2Pointer(int[] nums, int k) {

        Arrays.sort(nums);

        int maxDistance = nums[nums.length - 1] - nums[0];

        return binarySearch(nums, 0, maxDistance, k);
    }

    private int binarySearch(int[] nums, int min, int max, int k) {

        while (min < max) {
            int mid = (min + max) / 2;

            int midCount = countDistances(nums, mid);

            if (midCount < k) {
                min = mid + 1; // need to increase distance
            } else {
                max = mid; // need to decrease distance
            }
        }
        return min;
    }

    // Count all pairs <= distances

    private int countDistances(int[] nums, int distance) {

        int count = 0;

        for (int right = 0, left = 0; right < nums.length; right++) {

            // move left pointer so window is <= distance
            while (nums[right] - nums[left] > distance) {
                left++;
            }

            // add all combinations
            count += right - left;
        }

        return count;
    }
    /**
     * Use bucket sort [0, max - min]
     * <p>
     * Time:    O(n^2)  ->  18.88%
     * Space:   O(k)    ->  13.95%
     */
    public int smallestDistancePairBucket(int[] nums, int k) {

        Arrays.sort(nums);

        int[] buckets = new int[nums[nums.length - 1] - nums[0] + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                buckets[nums[j] - nums[i]]++; // Increment distance for bucket
            }
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != 0) {
                k -= buckets[i];
            }
            if (k <= 0) {
                return i;
            }
        }

        return -1;
    }
}
