package us.slemjet.leetcode.easy.tasks_301_350;

import java.util.*;

/**
 * 349. Intersection of Two Arrays
 */
public class IntersectionOfTwoArrays {

    /**
     * Use an auxiliary array to set all numbers from each array (once)
     * Return those that are set twice - meaning they were set from both arrays
     * <p>
     * Time: O(1)  ->  53.96%
     * Space:O(1)  ->  89.08%
     */
    public int[] intersectionDictionary(int[] nums1, int[] nums2) {

        int[] allNumbers = new int[1000];

        for (int num1 : nums1) {
            if (allNumbers[num1] == 0) {
                allNumbers[num1]++;
            }
        }

        for (int num2 : nums2) {
            if (allNumbers[num2] == 1) {
                allNumbers[num2]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < allNumbers.length; i++) {
            if (allNumbers[i] == 2) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    /**
     * Sort one array + binarySearch
     * Time: O(n1 + n2logn2)    ->  14.46%
     * Space:O(1)               ->  89.08%
     */
    public int[] intersectionSort(int[] nums1, int[] nums2) {

        Set<Integer> uniqueMatches = new HashSet<>();

        Arrays.sort(nums2);

        for (int num1 : nums1) {
            if (!uniqueMatches.contains(num1) && Arrays.binarySearch(nums2, num1) >= 0) {
                // Check if there is a match in nums2
                uniqueMatches.add(num1);
            }
        }

        return uniqueMatches.stream().mapToInt(Integer::intValue).toArray();
    }
}
