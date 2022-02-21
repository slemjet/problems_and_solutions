package us.slemjet.leetcode.easy.from_151_to_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 */
public class MajorityElement {

    /**
     * Moore voting algorithm
     * <p>
     * Runtime:  99.84% - O(n)
     * Memory Usage: 55.57% - O(1)
     */
    public int majorityElement(int[] nums) {
        int majorCandidate = nums[0]; // Take first element as candidate
        int count = 1;
        int threshold = nums.length / 2; // If count exceeds this threshold - that means that candidate is an actual major element

        for (int i = 1; i < nums.length; i++) {
            if (majorCandidate == nums[i]) {
                count++;

                if (count > threshold) {
                    return majorCandidate;
                }
            } else {
                count--; // Decrement (alternatively incrementing for real candidate)

                if (count == 0) { // Switch candidate to current element
                    majorCandidate = nums[i];
                    count = 1;
                }
            }
        }

        return majorCandidate;
    }

    /**
     * Use Bit manipulation
     *
     * Runtime: 35.07%
     * Memory Usage: 5.16%
     */
    public int majorityElementBit(int[] nums) {
        int[] bit = new int[32];
        // Calculate sums of bits
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] += (nums[i] >> j) & 1;
            }
        }
        int majority = 0;
        for (int j = 0; j < 32; j++) {
            // If #bits is >= majority - we include it
            bit[j] = bit[j] > (nums.length / 2)? 1 : 0;
            majority += bit[j] << j;
        }
        return majority;
    }

    /**
     * Runtime:  9.95% - O(n)
     * Memory Usage: 5.05% - O(n)
     */
    public int majorityElementHashTable(int[] nums) {

        Map<Integer, Integer> occurrences = new HashMap<>();

        int threshold = nums.length / 2;

        for (int num : nums) {
            Integer count = occurrences.get(num);
            if (count == null)
                count = 0;

            count++;

            occurrences.put(num, count);

            if (count > threshold)
                return num;
        }

        return 0;
    }
}
