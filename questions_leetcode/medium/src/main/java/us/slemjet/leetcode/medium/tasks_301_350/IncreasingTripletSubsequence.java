package us.slemjet.leetcode.medium.tasks_301_350;

/**
 * 334. Increasing Triplet Subsequence
 */
public class IncreasingTripletSubsequence {

    /**
     * Runtime: 18.36%
     * Memory Usage: 7.82%
     */
    public boolean increasingTriplet(int[] nums) {

        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= left) left = num; // Leftmost should be smallest
            else if (num <= middle) middle = num; // Middle should be next smallest
            else if (num > middle) return true; // current > middle > left -> solution found
        }
        return false;
    }
}
