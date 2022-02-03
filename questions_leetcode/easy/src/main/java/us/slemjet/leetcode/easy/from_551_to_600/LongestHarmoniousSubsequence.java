package us.slemjet.leetcode.easy.from_551_to_600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 */
public class LongestHarmoniousSubsequence {

    /**
     * Store numbers counts in hashmap, iterate over numbers checking counts with adjacent numbers
     * <p>
     * Runtime: 21.15%
     * Memory Usage: 12.05%
     */
    public int findLHS(int[] nums) {

        int maxQty = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.computeIfAbsent(num, integer -> 0) + 1);
        }

        for (int num : counts.keySet()) {
            if (counts.containsKey(num - 1)) maxQty = Math.max(maxQty, counts.get(num) + counts.get(num - 1));
            if (counts.containsKey(num + 1)) maxQty = Math.max(maxQty, counts.get(num) + counts.get(num + 1));
        }

        return maxQty;
    }

    /**
     * Use sliding window
     *
     * Runtime: 73.59%
     * Memory Usage: 51.03%
     */
    public int findLHSSlidingWindow(int[] nums) {

        int maxQty = 0;

        Arrays.sort(nums); // Sort so we can iterate over array sequentially

        int left = 0, right = 1;

        while (right < nums.length) {
            while (nums[right] - nums[left] > 1) {
                left++; // Move left until we gt appropriate result
            }

            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right++; // Move right till we have appropriate result
            }

            if (nums[right] - nums[left] == 1) {
                maxQty = Math.max(maxQty, right - left + 1); // Can form harmonic subsequence
            }
            right++;
        }

        return maxQty;
    }


    /**
     * Sort and check if can form subsequence - count max
     * <p>
     * Runtime: 81.03%
     * Memory Usage: 49.74%
     */
    public int findLHSSort(int[] nums) {

        int maxQty = 0;

        Arrays.sort(nums); // Sort so we can iterate over array sequentially
        int currNum = nums[0], currCount = 1;
        Integer prevNum = null, prevCount = null;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currCount++;
                continue;
            }

            // Can form harmonic subsequence
            if (prevNum != null && currNum - prevNum == 1) maxQty = Math.max(maxQty, prevCount + currCount);

            prevCount = currCount;
            currCount = 1;
            prevNum = currNum;
            currNum = nums[i];
        }

        if (prevNum != null && currNum - prevNum == 1) maxQty = Math.max(maxQty, prevCount + currCount);

        return maxQty;
    }
}
