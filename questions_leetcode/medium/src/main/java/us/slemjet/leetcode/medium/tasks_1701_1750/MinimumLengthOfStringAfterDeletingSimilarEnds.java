package us.slemjet.leetcode.medium.tasks_1701_1750;

/**
 * 1750. Minimum Length of String After Deleting Similar Ends
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    /**
     * Time: O(n)   ->  80.63%
     * Space:O(1)   ->  28.57%
     */
    public int minimumLength(String s) {

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right && chars[left] == chars[right]) {
            char sameChar = chars[left];
            while (left <= right && sameChar == chars[left]) {
                left++;
            }
            while (left <= right && sameChar == chars[right]) {
                right--;
            }
        }

        return right - left + 1;
    }
}
