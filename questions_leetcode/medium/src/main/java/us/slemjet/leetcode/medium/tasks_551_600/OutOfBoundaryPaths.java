package us.slemjet.leetcode.medium.tasks_551_600;

/**
 * 576. Out of Boundary Paths
 */
public class OutOfBoundaryPaths {

    /**
     * Time:    ->  59.60%
     * Space:   ->  22.00%
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};
        int modulo = (int) (Math.pow(10, 9) + 7);
        Integer[][][] memo = new Integer[m][n][maxMove + 1];

        return findPaths(m, n, maxMove, startRow, startColumn, directions, modulo, memo);
    }

    private int findPaths(int m, int n, int moves, int row, int col, int[][] directions, int modulo, Integer[][][] memo) {

        if (row < 0 || row == m || col < 0 || col == n) {
            // Crossed grid - add combination
            return 1;
        }

        if (moves <= row && moves <= col && moves + row < m && moves + col < n) {
            // not possible to reach any border
            return 0;
        }

        if (memo[row][col][moves] != null) {
            return memo[row][col][moves];
        }

        memo[row][col][moves] = 0;

        for (int[] dir : directions) {
            // Get sum of every direction
            int dirSum = findPaths(m, n, moves - 1, row + dir[0], col + dir[1], directions, modulo, memo);
            memo[row][col][moves] = ((memo[row][col][moves] + dirSum) % modulo);
        }

        return memo[row][col][moves];
    }
}
