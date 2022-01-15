package us.slemjet.leetcode.medium.tasks_1551_1600;

/**
 * 1567. Maximum Length of Subarray With Positive Product
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {

    /**
     * Dry run
     * Track negative and positive count and swap them in case of negative
     *
     * Runtime: 43.23%
     * Memory Usage: 32.83%
     */
    public int getMaxLenBottom(int[] nums) {
        int result = 0;
        int posCount = 0, negCount = 0;

        for (int num : nums) {
            if (num == 0) {
                // Reset counters
                posCount = negCount = 0;
            } else {
                posCount++;
                negCount += negCount == 0 ? 0 : 1; // Increment negative only if it was already != 0 (swapped from positive)
                if (num < 0) { // Swap positive and negative
                    int tmp = posCount;
                    posCount = negCount;
                    negCount = tmp;
                }
            }
            result = Math.max(result, posCount);
        }

        return result;
    }

    /**
     * Use Top to Bottom DP
     * <p>
     * Runtime: 7.25%
     * Memory Usage: 5.61%
     */
    public int getMaxLenBottomUp(int[] nums) {
        int result = 0;
        int currCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int sign = Integer.compare(nums[i], 0);
            int increment = Integer.compare(currCount, 0);
            if (i == 0 || nums[i - 1] == 0) {
                increment = 1;
            }
            currCount = sign * (currCount + increment);
            result = Math.max(result, currCount);
        }

        currCount = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int sign = Integer.compare(nums[i], 0);
            int increment = Integer.compare(currCount, 0);
            if (i == nums.length - 1 || nums[i + 1] == 0) {
                increment = 1;
            }
            currCount = sign * (currCount + increment);
            result = Math.max(result, currCount);
        }

        return result;
    }

    /**
     * Runtime: 12.34%
     * Memory Usage: 16.44%
     */
    public int getMaxLenIdx(int[] nums) {

        int result = 0;
        int zeroIdx = -1;
        int negIdx = zeroIdx;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                if (negIdx != zeroIdx) { // There was negative previously
                    negIdx = zeroIdx;
                } else { // First negative
                    result = Math.max(result, i - zeroIdx - 1);
                    negIdx = i;
                }
            } else if (num == 0) {
                if (zeroIdx != negIdx) {
                    result = Math.max(result, i - negIdx - 1); // Last was negative
                } else {
                    result = Math.max(result, i - zeroIdx - 1); // Last was zero
                }
                zeroIdx = i;
                negIdx = i;
            }
            if (i == nums.length - 1) {
                result = Math.max(result, nums.length - 1 - Math.max(zeroIdx, negIdx));
            }
        }

        negIdx = zeroIdx = nums.length;

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num < 0) {
                if (negIdx != zeroIdx) { // There was negative previously
                    negIdx = zeroIdx;
                } else { // First negative
                    result = Math.max(result, zeroIdx - 1 - i);
                    negIdx = i;
                }
            } else if (num == 0) {
                if (zeroIdx != negIdx) {
                    result = Math.max(result, negIdx - 1 - i); // Last was negative
                } else {
                    result = Math.max(result, zeroIdx - 1 - i); // Last was zero
                }
                zeroIdx = i;
                negIdx = i;
            }
            if (i == 0) {
                result = Math.max(result, Math.min(zeroIdx, negIdx));
            }
        }

        return result;
    }
}
