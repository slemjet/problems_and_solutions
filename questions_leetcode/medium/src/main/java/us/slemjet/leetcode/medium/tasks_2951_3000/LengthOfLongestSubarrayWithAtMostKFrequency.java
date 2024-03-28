package us.slemjet.leetcode.medium.tasks_2951_3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. Length of Longest Subarray With at Most K Frequency
 */
public class LengthOfLongestSubarrayWithAtMostKFrequency {

    /**
     * Time: O(n)   ->  85.37%
     * Space:O(n)   ->  73.55%
     */
    public int maxSubarrayLength(int[] nums, int k) {

        int result = 0;

        Map<Integer, Integer> countByNumber = new HashMap<>();
        int numWithCountBiggerK = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {

            // Move right pointer until maxCount reaches k
            while (right < nums.length) {
                int num = nums[right];
                int count = countByNumber.computeIfAbsent(num, (n) -> 0) + 1;
                countByNumber.put(num, count);
                right++;

                if (count > k) {
                    numWithCountBiggerK = num; // Remember which number is bigger than k
                    break;
                }
                result = Math.max(result, right - left);
            }

            // Move left pointer until num with max count is less than k
            while (left < right) {
                int num = nums[left];
                int count = countByNumber.computeIfAbsent(num, (n) -> 0) - 1;
                countByNumber.put(num, count);
                left++;

                if (num == numWithCountBiggerK) {
                    // We've decremented num with max count - counts are less than k again
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Time: O(n)   ->  59.47%
     * Space:O(n)   ->  22.14%
     */
    public int maxSubarrayLength2(int[] nums, int k) {

        int result = 0;

        Map<Integer, Integer> countByNumber = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int rightNum = nums[right]; // Num to increment count
            countByNumber.put(rightNum, countByNumber.getOrDefault(rightNum, 0) + 1);

            while (countByNumber.get(rightNum) > k) {
                // Move left to decrement counts
                int leftNum = nums[left];
                countByNumber.put(leftNum, countByNumber.get(leftNum) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
