package us.slemjet.leetcode.medium.tasks_1851_1900;

import java.util.Arrays;

/**
 * 1885. Count Pairs in Two Arrays
 */
public class CountPairsInTwoArrays {

    /**
     * Time: O(nlogn)   ->  30.98%
     * Space:O(n)       ->  22.05%
     */
    public long countPairs(int[] nums1, int[] nums2) {

        long result = 0L;

        // nums1[i] + nums1[j] > nums2[i] + nums2[j]
        // nums1[i] - nums2[i] > nums2[j] - nums1[j] -> diff[i] > -diff[j]

        int[] diff = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = nums1[i] - nums2[i];
        }

        Arrays.sort(diff);

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > 0) {
                // All to the left are valid pairs because diff[i] > -diff[j] always in sorted asc array
                result += diff.length - i - 1;
            } else {
                // Do a binary search to find the leftmost valid pair
                int pairIdx = binarySearch(i, diff);
                result += diff.length - pairIdx;
            }
        }

        return result;
    }

    private static int binarySearch(int i, int[] diff) {
        int left = i + 1;
        int right = diff.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (diff[i] > -diff[mid]) {
                // Valid pair - keep searching for leftmost value
                right = mid - 1;
            } else {
                // Invalid pair - search in the right half
                left = mid + 1;
            }
        }
        return left;
    }
}
