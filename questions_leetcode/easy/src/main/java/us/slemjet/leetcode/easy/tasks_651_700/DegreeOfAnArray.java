package us.slemjet.leetcode.easy.tasks_651_700;

/**
 * 697. Degree of an Array
 */
public class DegreeOfAnArray {

    /**
     * Time: O(n)   ->  97.55%
     * Space:O(n)   ->  16.70%
     */
    public int findShortestSubArray(int[] nums) {

        int result = Integer.MAX_VALUE;

        // Save counts to calculate degree
        int[] counts = new int[50000];
        // Save first indexes to calculate length
        Integer[] firstIdx = new Integer[50000];
        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            counts[num]++;
            if (firstIdx[num] == null) {
                firstIdx[num] = i;
            }

            if (counts[num] > degree) {
                // new degree - update min length unconditionally
                degree = counts[num]; // -> update degree
                result = i - firstIdx[num] + 1;
            } else if (counts[num] == degree) {
                // same degree - check if min length is smaller
                result = Math.min(result, i - firstIdx[num] + 1);
            }
        }

        return result;
    }
}
