package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.Arrays;

/**
 * 931. Minimum Falling Path Sum
 */
public class MinimumFallingPathSum {


    /**
     * Inline modification
     * Time: O(n*m) ->  54.05%
     * Space:O(1)   ->  62.77%
     */
    public int minFallingPathSum(int[][] matrix) {

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                // Get min from the 3 above
                matrix[i][j] += Math.min(
                        j > 0 ? matrix[i - 1][j - 1] : Integer.MAX_VALUE,
                        Math.min(
                                j < matrix[i].length - 1 ? matrix[i - 1][j + 1] : Integer.MAX_VALUE,
                                matrix[i - 1][j]));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : matrix[matrix.length - 1]) {
            min = Math.min(min, num);
        }

        return min;
    }

    /**
     * DP Bottom Up
     * <p>
     * Runtime: 92.58%
     * Memory Usage: 5.08%
     */
    public int minFallingPathSum2(int[][] matrix) {

        Integer[][] sums = new Integer[matrix.length][matrix.length];

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < sums[0].length; i++) {
            sums[0][i] = calculateSums(matrix, sums, 0, i);
            result = Math.min(result, sums[0][i]);
        }

        return result;
    }

    private int calculateSums(int[][] matrix, Integer[][] sums, int j, int i) {
        if (j >= matrix.length) return 0;
        if (i < 0 || i >= matrix[j].length) return Integer.MAX_VALUE;
        if (sums[j][i] != null) return sums[j][i];

        sums[j][i] = matrix[j][i] + Math.min(calculateSums(matrix, sums, j + 1, i),
                Math.min(calculateSums(matrix, sums, j + 1, i - 1),
                        calculateSums(matrix, sums, j + 1, i + 1)));

        return sums[j][i];
    }

    /**
     * Memory optimized - use only one extra array sums
     * <p>
     * Runtime: 28.86%
     * Memory Usage: 39.10%
     */
    public int minFallingPathSum3(int[][] matrix) {
        int result = Integer.MAX_VALUE;

        int[] sums = Arrays.copyOf(matrix[matrix.length - 1], matrix[0].length);

        for (int j = matrix.length - 1; j >= 0; j--) {
            // Calculate for each level
            int prev = Integer.MAX_VALUE; // Previous value to the left
            int tmp;
            for (int i = 0; i < matrix[0].length; i++) {
                // Calculate current level
                if (j != matrix.length - 1) {
                    tmp = sums[i];
                    sums[i] = matrix[j][i] + Math.min(sums[i],
                            Math.min(prev, i < matrix[0].length - 1 ? sums[i + 1] : Integer.MAX_VALUE));
                    prev = tmp;
                }

                if (j == 0) {
                    // First level - find min sum
                    result = Math.min(result, sums[i]);
                }
            }
        }
        return result;
    }
}
