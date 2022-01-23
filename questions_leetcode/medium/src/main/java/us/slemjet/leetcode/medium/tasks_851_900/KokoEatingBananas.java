package us.slemjet.leetcode.medium.tasks_851_900;

import java.util.stream.IntStream;

/**
 * 875. Koko Eating Bananas
 */
public class KokoEatingBananas {

    /**
     * Use Binary Search
     * min - 1, max = max(piles)
     * get mid and check if with that ratio (mid) can eat all within h hours
     * shift left or right to get closes to h and store min ratio value
     *
     * Runtime: 58.08%
     * Memory Usage: 71.57%
     */
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = IntStream.of(piles).max().orElse(Integer.MIN_VALUE);
        int result = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Calculate hours using current eat ratio (k)
            int currHours = 0;
            for (int pile : piles) {
                currHours += pile / mid; // Hours to eat pile with current rate
                if (pile % mid != 0) currHours++; // Need to eat the remainder also
            }
            if (currHours <= h) { // Acceptable condition - store min
                result = Math.min(result, mid);
            }
            // Shift ranges accordingly
            if (currHours > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

