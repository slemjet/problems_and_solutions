package us.slemjet.leetcode.medium.from_50_to_100;

public class SortColors {

    /**
     * Runtime: 100.00%
     * Memory Usage: 74.11%
     */
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twos = 0;

        // Collect all numbers occurrences
        for (int val : nums) {
            switch (val) {
                case 0: {
                    zeroes++;
                    break;
                }
                case 1: {
                    ones++;
                    break;
                }
                case 2: {
                    twos++;
                    break;
                }
            }
        }
        //  Populate according to occurrences
        for (int i = 0; i < nums.length; i++) {
            nums[i] = zeroes-- > 0 ? 0 : ones-- > 0 ? 1 : twos-- > 0 ? 2 : -1;
        }
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 89.90%
     */
    public void sortColors2(int[] nums) {
        int zeroIdx = -1;
        int oneIdx = -1;
        int twoIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0: {
                    // All move - zero is set last
                    nums[++twoIdx] = 2;
                    nums[++oneIdx] = 1;
                    nums[++zeroIdx] = 0;
                    break;
                }
                case 1: {
                    // All move - one is set last
                    nums[++twoIdx] = 2;
                    nums[++oneIdx] = 1;
                    break;
                }
                case 2: {
                    // 2 move and set last
                    nums[++twoIdx] = 2;
                    break;
                }
            }
        }
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 80.35%
     */
    public void sortColors3(int[] nums) {
        int[] buckets = new int[3];
        for (int num : nums) buckets[num]++;
        for (int p = 0, val = 0; val < 3; val++) {
            for (int count = 0; count < buckets[val]; count++) {
                nums[p++] = val;
            }
        }
    }
}
