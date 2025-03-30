package us.slemjet.leetcode.medium.tasks_501_550;

import java.util.Random;

/**
 * 528. Random Pick with Weight
 */
public class RandomPickWithWeight {

    /**
     * Runtime:         O(nlogn ) ->    51.69%
     * Memory Usage:    O(n) ->         45.55%
     */
    static class Solution {

        Random random = new Random();
        int[] prefixSums;
        int totalSum;

        public Solution(int[] w) {
            prefixSums = new int[w.length];

            for (int i = 0; i < w.length; i++) {
                prefixSums[i] = w[i];
                totalSum += w[i];

                if (i > 0) {
                    prefixSums[i] += prefixSums[i - 1];
                }
            }
        }

        public int pickIndex() {

            // Generate random value within the limit
            double value = random.nextDouble(totalSum + 1);

            // Do binary search to find the index

            int left = 0;
            int right = prefixSums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (value > prefixSums[mid]) {
                    left = mid + 1; // We need rightmost value
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
