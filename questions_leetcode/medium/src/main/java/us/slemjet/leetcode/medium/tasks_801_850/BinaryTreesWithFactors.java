package us.slemjet.leetcode.medium.tasks_801_850;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 823. Binary Trees With Factors
 */
public class BinaryTreesWithFactors {

    /**
     * Runtime: 78.03%
     * Memory Usage: 46.24%
     */
    public int numFactoredBinaryTrees(int[] arr) {

        int modulo = (int) (1e9 + 7);

        // Sort
        Arrays.sort(arr);

        // Populate helper map to get index by element quickly
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indices.put(arr[i], i);
        }

        // DP - contains number of trees by numbers index
        long[] treeCount = new long[arr.length];
        Arrays.fill(treeCount, 1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] != 0) continue;

                int complementValue = arr[i] / arr[j];
                if (indices.containsKey(complementValue)) {
                    // If complementary number exists - sum its combination products
                    int complementIndex = indices.get(complementValue);
                    treeCount[i] = (treeCount[i] + treeCount[j] * treeCount[complementIndex]) % modulo;
                }
            }
        }

        long result = 0;

        for (long count : treeCount) {
            result += count;
        }

        return (int) (result % modulo);
    }
}
