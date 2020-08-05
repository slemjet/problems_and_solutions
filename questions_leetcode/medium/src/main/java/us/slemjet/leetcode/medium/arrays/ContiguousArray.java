package us.slemjet.leetcode.medium.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    /**
     * Runtime: 35 ms, faster than 30.85%
     * Memory Usage: 98.2 MB, less than 5.02%
     */
    public int findMaxLength(int[] nums) {

        int maxLength = 0;
        int sum = 0;

        Map<Integer, Integer> countByIdx = new HashMap<>();
        // set start conditions
        countByIdx.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            int val = nums[i];

            if (val == 0) {
                sum--;
            } else {
                sum++;
            }

            if (countByIdx.containsKey(sum)) {
                // index already visited - relative sum between is 0
                maxLength = Math.max(maxLength, i - countByIdx.get(sum));
            } else {
                countByIdx.put(sum, i);
            }
        }

        return maxLength;
    }


    /**
     * Runtime: 5 ms, faster than 99.39%
     * Memory Usage: 48.6 MB, less than 90.97%
     */
    public int findMaxLengthArr(int[] nums) {

        int maxLength = 0;
        int sum = nums.length;

        int[] countByIdx = new int[nums.length * 2 + 2];
        // set start conditions
        countByIdx[nums.length] = 1;

        for (int i = 0; i < nums.length; i++) {

            int val = nums[i];

            if (val == 0) {
                sum--;
            } else {
                sum++;
            }

            if (countByIdx[sum] > 0) {
                // index already visited - relative sum between is 0
                maxLength = Math.max(maxLength, i + 2 - countByIdx[sum]);
            } else {
                countByIdx[sum] = i + 2;
            }
        }

        return maxLength;
    }
}
