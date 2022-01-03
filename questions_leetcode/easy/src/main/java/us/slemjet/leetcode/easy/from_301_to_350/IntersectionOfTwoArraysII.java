package us.slemjet.leetcode.easy.from_301_to_350;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 */
public class IntersectionOfTwoArraysII {

    /**
     * Use HashMap with counts
     *
     * Runtime: 6.20%
     * Memory Usage: 15.66%
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            Integer count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);
        }

        List<Integer> common = new ArrayList<>();
        for (int num : nums2) {
            Integer count = counts.get(num);
            if (count != null && count > 0) {
                common.add(num);
                count--;
                if (count > 0) counts.put(num, count);
                else counts.remove(num);
            }
        }

        return common.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 2 Sort
     * <p>
     * Runtime: 11.20%
     * Memory Usage: 17.47%
     */
    public int[] intersect2Sort(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        List<Integer> common = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 == num2) {
                common.add(num1);
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }
        return common.stream().mapToInt(Integer::intValue).toArray();
    }

}
