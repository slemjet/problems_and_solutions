package us.slemjet.leetcode.medium.tasks_451_500;

import java.util.HashMap;

/**
 * 454. 4Sum II
 */
public class FourSumII {

    /**
     * Runtime: 14.22%
     * Memory Usage: 5.10%
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int sum = 0;
        HashMap<Integer, Integer> complementsSum34Count = new HashMap<>();

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum34 = num3 + num4;
                if (!complementsSum34Count.containsKey(-sum34)) complementsSum34Count.put(-sum34, 0);
                complementsSum34Count.put(-sum34, complementsSum34Count.get(-sum34) + 1);
            }
        }

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum12 = num1 + num2;
                if (complementsSum34Count.containsKey(sum12))
                    sum += complementsSum34Count.get(sum12);
            }
        }

        return sum;
    }

    /**
     * Time limit exceeded
     */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int sum = 0;

        HashMap<Integer, Integer> complementsNums4Count = new HashMap<>();
        for (int num4 : nums4) {
            if (!complementsNums4Count.containsKey(-num4)) complementsNums4Count.put(-num4, 0);
            complementsNums4Count.put(-num4, complementsNums4Count.get(-num4) + 1);
        }
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                for (int num3 : nums3) {
                    int sum3 = num1 + num2 + num3;
                    if (complementsNums4Count.containsKey(sum3)) {
                        sum += complementsNums4Count.get(sum3);
                    }
                }
            }
        }

        return sum;
    }

    /**
     * Time limit exceeded
     */
    public int fourSumCountBrute(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int sum = 0;

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                for (int num3 : nums3) {
                    for (int num4 : nums4) {
                        if (num1 + num2 + num3 + num4 == 0) sum++;
                    }
                }
            }
        }

        return sum;
    }

}
