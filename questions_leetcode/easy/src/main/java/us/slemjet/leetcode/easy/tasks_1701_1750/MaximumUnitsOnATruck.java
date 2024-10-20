package us.slemjet.leetcode.easy.tasks_1701_1750;

import java.util.Arrays;

/**
 * 1710. Maximum Units on a Truck
 */
public class MaximumUnitsOnATruck {

    /**
     * Time:    O(nlogn)    ->  94.68%
     * Space:   O(1)        ->  15.62%
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int result = 0;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        for (int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            result += boxType[1] * boxCount;
            truckSize -= boxCount;
        }

        return result;
    }
}
