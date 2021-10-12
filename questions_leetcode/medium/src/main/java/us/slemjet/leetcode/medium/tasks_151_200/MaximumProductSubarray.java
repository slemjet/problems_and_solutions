package us.slemjet.leetcode.medium.tasks_151_200;

/**
 * 152. Maximum Product Subarray
 */
public class MaximumProductSubarray {

    /**
     * Runtime: 45.65%
     * Memory Usage: 21.01%
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, product = 1;

        // Either scanning from left or from right will revel max sum (with negative numbers)
        // 1,2,3,-4,5,6
        // >> 1, 2, 6 >> -24, -.... -> max is 6 from left to right
        // -.... << -120 << 30, 6 -> max is 30 from right to left (revere search)
        // 0 is a delimiter, resetting product to 1

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        return max;
    }

    /**
     * Runtime: 26.86%
     * Memory Usage: 8.52%
     */
    public int maxProduct1(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) { // swap max and min as they will change after negative value multiplication
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            max = Math.max(max, currMax);
        }

        return max;
    }

    /**
     * Runtime: 45.65%
     * Memory Usage: 8.52%
     */

    public int maxProduct2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int current = nums[0];
        int max = current;
        int idx = 1;
        int subIdx;

        while (idx < nums.length) {
            int prevProduct = nums[idx - 1];
            current = nums[idx];
            nums[idx] = prevProduct == 0 ? current : prevProduct * current;
            max = Math.max(max, Math.max(nums[idx], current));

            if (nums[idx] == 0 || idx == nums.length - 1) {
                if (nums[idx] != 0) {
                    idx++;
                }
                subIdx = idx - 2;
                while (subIdx >= 0 && nums[idx - 1] != 0 && nums[subIdx] != 0) {
                    int subProduct = nums[idx - 1] / nums[subIdx];
                    max = Math.max(max, subProduct);
                    subIdx--;
                }
            }
            idx++;
        }

        return max;
    }
}
