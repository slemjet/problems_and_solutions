package us.slemjet.leetcode.medium.tasks_1001_1050;

/**
 * 1014. Best Sightseeing Pair
 */
public class BestSightseeingPair {

    /**
     * Keep track of left part with max sum
     *
     * Runtime: 99.83%
     * Memory Usage: 93.62%
     */
    public int maxScoreSightseeingPair(int[] values) {

        int maxI = 0;
        int result = values[maxI] + maxI;
        int currSum;

        for (int j = 1; j < values.length; j++) {
            currSum = values[maxI] + values[j] + maxI - j;
            result = Math.max(result, currSum); // Update new max sum

            if (values[maxI] + maxI < values[j] + j) { // Check if need to set new max left side
                maxI = j;
            }
        }

        return result;
    }

    /**
     * Keep track of current max sum (left) ending at
     * <p>
     * Runtime: 18.92%
     * Memory Usage: 21.65%
     */
    public int maxScoreSightseeingPair2(int[] values) {

        int result = 0;
        int currMax = Integer.MIN_VALUE;

        for (int i = 1; i < values.length; i++) {
            // Current previous max ending at i
            currMax = Math.max(currMax, values[i - 1] + i - 1);
            // Current result - sum with current max sum
            result = Math.max(result, values[i] + currMax - i);
        }

        return result;
    }

    /**
     * Generic Bottom up DP approach
     * <p>
     * Runtime: 7.86%
     * Memory Usage: 26.84%
     */
    public int maxScoreSightseeingPair3(int[] values) {

        int result = 0;
        int currSum = 0;

        for (int i = 1; i < values.length; i++) {
            currSum = values[i] + Math.max(values[i - 1], currSum - values[i - 1]) - 1;
            result = Math.max(result, currSum);
        }

        return result;
    }
}
