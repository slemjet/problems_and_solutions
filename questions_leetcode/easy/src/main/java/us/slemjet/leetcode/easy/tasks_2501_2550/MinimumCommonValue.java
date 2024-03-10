package us.slemjet.leetcode.easy.tasks_2501_2550;

/**
 * 2540. Minimum Common Value
 */
public class MinimumCommonValue {

    /**
     * Time: O(n)   ->  81.56%
     * Space:O(1)   ->  69.04%
     */
    public int getCommon(int[] nums1, int[] nums2) {

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                return nums1[idx1];
            }
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return -1;
    }
}
