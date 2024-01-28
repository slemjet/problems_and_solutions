package us.slemjet.leetcode.hard.tasks_1051_1100.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. Number of Submatrices That Sum to Target
 */
public class NumberOfSubmatricesThatSumToTarget {

    /**
     * Time: O()    ->  73.99%
     * Space:O()    ->  22.54%
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        // Build 2D prefix sum
        int[][] prefixSum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                prefixSum[i][j] = matrix[i][j];
                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }

        // Fix rows and calculate sums between the rows
        int count = 0;
        Map<Integer, Integer> countBySum = new HashMap<>();

        for (int r1 = 0; r1 < matrix.length; r1++) {
            for (int r2 = r1; r2 < matrix.length; r2++) {

                countBySum.clear();
                countBySum.put(0, 1);

                for (int col = 0; col < matrix[0].length; col++) {
                    int currSum = prefixSum[r2][col];
                    if (r1 > 0) {
                        currSum -= prefixSum[r1 - 1][col];
                    }

                    int diff = currSum - target;
                    if (countBySum.containsKey(diff)) {
                        count += countBySum.get(diff);
                    }

                    countBySum.put(currSum, 1 + countBySum.getOrDefault(currSum, 0));
                }
            }
        }

        return count;
    }
}
