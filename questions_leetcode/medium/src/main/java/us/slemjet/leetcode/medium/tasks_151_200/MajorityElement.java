package us.slemjet.leetcode.medium.tasks_151_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 */
public class MajorityElement {

    /**
     * Runtime:  99.84% - O(n)
     * Memory Usage: 55.57% - O(1)
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        int threshold = nums.length / 2;

        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;

                if (count > threshold) {
                    return major;
                }
            } else {
                count--;

                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }

        return major;
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
