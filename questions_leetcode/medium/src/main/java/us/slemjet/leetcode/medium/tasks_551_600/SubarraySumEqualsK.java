package us.slemjet.leetcode.medium.tasks_551_600;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 */
public class SubarraySumEqualsK {


    /**
     * Use map to store sum. If sum - k already occurred - that means
     * that between those numbers we have that sum
     * <p>
     * Runtime: 34.67%
     * Memory Usage: 11.89%
     */
    public int subarraySum(int[] nums, int k) {

        int result = 0;

        Map<Integer, Integer> sums = new HashMap<>();

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum == k) result++; // Current sum is the result
            if (sums.containsKey(sum - k)) {
                result += sums.get(sum - k); // Contains sum between 2 elements == k
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    /**
     * Use prefix sums to quickly calculate sum
     * <p>
     * Runtime: 8.18%
     * Memory Usage: 50.68%
     */
    public int subarraySumPrefix(int[] nums, int k) {

        int result = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = nums[start];
            if (sum == k) result++; // Sum of single number sequence
            for (int end = start + 1; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) result++; // If all the number between start and end give us +k sum
            }
        }
        return result;
    }
}
