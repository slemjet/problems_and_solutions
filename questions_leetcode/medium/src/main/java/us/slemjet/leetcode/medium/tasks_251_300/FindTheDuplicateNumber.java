package us.slemjet.leetcode.medium.tasks_251_300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. Find the Duplicate Number
 */
public class FindTheDuplicateNumber {

    /**
     * Slow and Fast idx
     *
     * Runtime: 40.15%
     * Memory Usage: 6.01%
     */
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow]; // 1 step
            fast = nums[nums[fast]]; // 2 steps
        } while (slow != fast); // Until they meet

        // Reset slow to beginning
        slow = nums[0];

        while (slow != fast) { // They must meet at the loop entrance
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    /**
     * Bit count
     * <p>
     * Runtime: 5.15%
     * Memory Usage: 91.62%
     */
    public int findDuplicateBit(int[] nums) {

        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        int length = Math.max(Integer.toBinaryString(max).length(), nums.length) + 1;
        int[] bitSumExpected = new int[length];
        int[] bitSum = new int[length];

        int bit;
        int bitVal;

        for (int i = 0; i < nums.length; i++) {

            // Calculate bits sum for existing numbers vs bits sum of expected numbers
            bit = 0;
            bitVal = 1;
            while (bitVal <= i) {
                bitSumExpected[bitSum.length - bit - 1] += i & bitVal;
                bit++;
                bitVal = 1 << bit;
            }

            bit = 0;
            bitVal = 1;
            while (bitVal <= nums[i]) {
                bitSum[bitSum.length - bit - 1] += nums[i] & bitVal;
                bit++;
                bitVal = 1 << bit;
            }
        }

        int result = 0;
        for (int i = 0; i < bitSum.length; i++) {
            // If bits are greater - this is a bit for duplicate number
            int value = bitSumExpected[bitSumExpected.length - 1 - i] < bitSum[bitSum.length - 1 - i] ? 1 : 0;
            result += value << i;
        }

        return result;
    }

    /**
     * Use binary search
     * Runtime: 20.19%
     * Memory Usage: 23.08%
     */
    public int findDuplicateBinary(int[] nums) {

        // Use binary search to check count of values. count should be equal to value if there is no duplicate
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int med = low + (high - low) / 2;
            // Calculate occurrences for this med value
            int count = 0;
            for (int num : nums) if (num <= med) count++;
            if (count > med)
                high = med; // Duplicate
            else
                low = med + 1; // Duplicate is greater
        }

        return high;
    }


    /**
     * Mark negative
     * Runtime: 96.66%
     * Memory Usage: 77.84%
     */
    public int findDuplicateNegative(int[] nums) {

        int value = nums[0];
        while (true) {
            if (nums[value] < 0) return -nums[value];
            else {
                int tmp = nums[value];
                nums[value] = -value;
                value = tmp;
            }
        }
    }

    /**
     * HashSet
     * Runtime: 15.45%
     * Memory Usage: 5.01%
     */
    public int findDuplicateSet(int[] nums) {

        // Use hashSet -> if duplicate found - return it
        Set<Integer> values = new HashSet<>();

        for (int num : nums) {
            if (!values.add(num)) return num;
        }

        return 0;
    }

    /**
     * Sort
     * Runtime: 7.32%
     * Memory Usage: 14.86%
     */
    public int findDuplicateSort(int[] nums) {

        // Sort -> duplicates will be next to each other
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return nums[i];
        }

        return 0;
    }
}
