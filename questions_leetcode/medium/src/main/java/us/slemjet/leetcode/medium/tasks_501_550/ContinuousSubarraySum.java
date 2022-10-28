package us.slemjet.leetcode.medium.tasks_501_550;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 */
public class ContinuousSubarraySum {

    /**
     * Runtime: 68.44%
     * Memory Usage: 71.67%
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k == 0) return false;

        // Keep indices of modulos
        Map<Integer, Integer> modulos = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int modulo = sum % k;

            if (i > 0 && modulo == 0) return true;
            if (modulos.containsKey(modulo)) {
                // modulo(n + k) = modulo(n) but needs to be at least 2 chars length
                if (modulos.get(modulo) + 1 < i) return true;
            } else {
                modulos.put(modulo, i);
            }
        }
        return false;
    }
}
