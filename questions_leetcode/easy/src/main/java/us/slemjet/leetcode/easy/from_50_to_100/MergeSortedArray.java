package us.slemjet.leetcode.easy.from_50_to_100;

/**
 * 88. Merge Sorted Array
 *
 * Runtime: 100.00%
 * Memory Usage: 20.26%
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // merge from the end
        int tail1 = m - 1;
        int tail2 = n - 1;
        int end = n + m - 1;

        while (tail1 >= 0 && tail2 >= 0){
            nums1[end--] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
        }

        // process the remaining tail
        while (tail2 >= 0){
            nums1[end--] = nums2[tail2--];
        }
    }

}
