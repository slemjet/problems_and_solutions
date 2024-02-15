package us.slemjet.leetcode.medium.tasks_2951_3000;

import java.util.Arrays;

/**
 * 2971. Find Polygon With the Largest Perimeter
 */
public class FindPolygonWithTheLargestPerimeter {

    /**
     * Time: O(nlogn)   ->  30.37%
     * Space:O(n)       ->  92.93%
     */
    public long largestPerimeter(int[] nums) {

        long result = -1;
        long sumSoFar;

        Arrays.sort(nums);
        sumSoFar = nums[0] + nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (sumSoFar > nums[i]) {
                result = sumSoFar + nums[i];
            }
            sumSoFar += nums[i];
        }
        return result;
    }
}
