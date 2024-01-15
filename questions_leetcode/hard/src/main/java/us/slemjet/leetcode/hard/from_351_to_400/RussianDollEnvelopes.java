package us.slemjet.leetcode.hard.from_351_to_400;

import java.util.Arrays;
import java.util.Objects;

/**
 * 354. Russian Doll Envelopes
 */
public class RussianDollEnvelopes {

    /**
     * Time: O(nlogn)   ->  19.86%
     * Space:O(n)       ->  89.92%
     */
    public int maxEnvelopes(int[][] envelopes) {

        // Use LIS (longest Increasing Subsequence) -> see #300 LongestIncreasingSubsequence for reference
        // We need to prepare data for LIS since we have 2 dimensions
        // We order increasing by one dimension (width) and decreasing in other (height) -
        // this is needed to exclude cases when we have multiple envelopes with same width - we still cannot put them
        // in one another, but we need the one with the smallest other dimension.
        // Thus, we need heights in decreasing order, so latest we take will be just one - smallest height

        Arrays.sort(envelopes, (o1, o2) -> {
            if (Objects.equals(o1[0], o2[0])) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int[] envelopeHeights = new int[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            envelopeHeights[i] = envelopes[i][1];
        }

        return lengthOfLIS(envelopeHeights);
    }

    /**
     * @see LongestIncreasingSubsequence
     */
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length]; // Smallest last value of all the sequences of this size
        int size = 0;

        // Search for sequence ending with > this value - they will be in increasing order so use binary search
        // Ex: for [10, 9, 2, 5, 3, 7, 101, 18] -> resulting array: [2, 3, 7, 18]
        for (int num : nums) {
            int idx = Arrays.binarySearch(dp, 0, size, num);
            if (idx < 0) {
                idx = -idx - 1; // No direct match - need to convert
            }
            if (idx == size) {
                size++; // Added new value to the biggest existing sequence - we need to extend the range that we check
            }
            dp[idx] = num; // Set new largest value of the sequence
        }

        return size;
    }
}
