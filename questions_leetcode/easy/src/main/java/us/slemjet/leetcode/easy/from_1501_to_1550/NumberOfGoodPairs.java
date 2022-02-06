package us.slemjet.leetcode.easy.from_1501_to_1550;

/**
 * 1512. Number of Good Pairs
 */
public class NumberOfGoodPairs {

    /**
     * Runtime: 100.00%
     * Memory Usage: 14.34%
     */
    public int numIdenticalPairs(int[] nums) {

        int result = 0;
        int maxNumber = 100; // Can be max number of nums
        int[] counts = new int[maxNumber + 1];

        for (int num : nums) {
            counts[num]++;
            result += counts[num] - 1;
        }
        return result;
    }

    /**
     * Use formula to count combinations from count number
     *          n * (n - 1)
     * count = -------------
     *              2
     * Runtime: 100.00%
     * Memory Usage: 14.71%
     */
    public int numIdenticalPairsMath(int[] nums) {

        int result = 0;
        int[] counts = new int[100 + 1];

        for (int num : nums) {
            counts[num]++;
        }

        for (int count : counts) {
            result += count * (count - 1) / 2; // Count combinations that can be made from count
        }

        return result;
    }
}
