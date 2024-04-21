package us.slemjet.leetcode.hard.tasks_2701_2750;

import us.slemjet.leetcode.common.UnionFind;

/**
 * 2709. Greatest Common Divisor Traversal
 */
public class GreatestCommonDivisorTraversal {

    /**
     * Time: O()   ->  45.45%
     * Space:O()   ->  50.91%
     */
    public boolean canTraverseAllPairs(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        // Populate list of prime numbers up to max of nums
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        for (int num : nums) {
            maxNumber = Math.max(maxNumber, num);
            minNumber = Math.min(minNumber, num);
        }
        if (minNumber == 1) {
            return false;
        }

        UnionFind unionFind = new UnionFind(maxNumber + 1);
        for (int num : nums) {
            // Apply sieve of Eratosthenes to get all divisible numbers
            for (int i = 2; i * i <= maxNumber; i++) {
                if (num % i == 0 && num / i != 1) {
                    unionFind.unite(num, i); // Join with this i
                    unionFind.unite(num, num / i); // Join with division by this i
                }
            }
        }

        // Go through the union and check if first node is connected with every number
        for (int num : nums) {
            if (!unionFind.isConnected(nums[0], num)) {
                return false;
            }
        }

        return true;
    }
}
