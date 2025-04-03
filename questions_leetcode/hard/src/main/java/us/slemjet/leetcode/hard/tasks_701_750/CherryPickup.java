package us.slemjet.leetcode.hard.tasks_701_750;

import java.util.Arrays;

/**
 * 741. Cherry Pickup
 */
public class CherryPickup {

    /**
     * Optimization - derive one coordinate from others
     * Time:    O(N^3)  ->  87.09%
     * Space:   O(N^3)  ->  31.82%
     */
    public int cherryPickup3N(int[][] grid) {
        int n = grid.length;

        // Memoization table for DP
        int[][][] memo = new int[n][n][n];
        for (int[][] m1 : memo) {
            for (int[] m2 : m1) {
                Arrays.fill(m2, Integer.MIN_VALUE);
            }
        }

        // Send 2 probes and start both paths at (0, 0)
        return Math.max(0, dp3N(grid, memo, 0, 0, 0));
    }

    private int dp3N(int[][] grid, int[][][] memo, int row1, int col1, int row2) {

        // Derive  col2 from other coordinates
        int col2 = row1 + col1 - row2;

        int n = grid.length;

        // Out-of-bounds or obstacle checks
        if (row1 >= n || col1 >= n || row2 >= n || col2 >= n || grid[row1][col1] == -1 || grid[row2][col2] == -1) {
            return Integer.MIN_VALUE;
        }

        // If both paths reach the bottom-right corner - end of path
        if (row1 == n - 1 && col1 == n - 1) {
            return grid[row1][col1];
        }

        // Check memoized result
        if (memo[row1][col1][row2] != Integer.MIN_VALUE) {
            return memo[row1][col1][row2];
        }

        // Cherries picked at current positions
        int cherries = grid[row1][col1]; // First probe
        if (row1 != row2 || col1 != col2) { // Avoid double-counting for the same cell
            cherries += grid[row2][col2]; // Second probe
        }

        // Move to the next step (4 possible moves)
        int nextCherries = Math.max(
                Math.max(dp3N(grid, memo, row1 + 1, col1, row2 + 1), dp3N(grid, memo, row1 + 1, col1, row2)), // Down-Down or Down-Right
                Math.max(dp3N(grid, memo, row1, col1 + 1, row2 + 1), dp3N(grid, memo, row1, col1 + 1, row2))  // Right-Down or Right-Right
        );

        cherries += nextCherries;

        // Memoize and return result
        memo[row1][col1][row2] = cherries;
        return cherries;
    }

    /**
     * Time:    O(N^4)  ->  7.09%
     * Space:   O(N^4)  ->  10.73%
     */
    public int cherryPickup4N(int[][] grid) {
        int n = grid.length;

        // Memoization table for DP
        int[][][][] memo = new int[n][n][n][n];
        for (int[][][] m1 : memo) {
            for (int[][] m2 : m1) {
                for (int[] m3 : m2) {
                    Arrays.fill(m3, Integer.MIN_VALUE);
                }
            }
        }

        // Send 2 probes and start both paths at (0, 0)
        return Math.max(0, dp4N(grid, memo, 0, 0, 0, 0));
    }

    private int dp4N(int[][] grid, int[][][][] memo, int row1, int col1, int row2, int col2) {

        int n = grid.length;

        // Out-of-bounds or obstacle checks
        if (row1 >= n || col1 >= n || row2 >= n || col2 >= n || grid[row1][col1] == -1 || grid[row2][col2] == -1) {
            return Integer.MIN_VALUE;
        }

        // If both paths reach the bottom-right corner - end of path
        if (row1 == n - 1 && col1 == n - 1) {
            return grid[row1][col1];
        }

        // Check memoized result
        if (memo[row1][col1][row2][col2] != Integer.MIN_VALUE) {
            return memo[row1][col1][row2][col2];
        }

        // Cherries picked at current positions
        int cherries = grid[row1][col1]; // First probe
        if (row1 != row2 || col1 != col2) { // Avoid double-counting for the same cell
            cherries += grid[row2][col2]; // Second probe
        }

        // Move to the next step (4 possible moves)
        int nextCherries = Math.max(
                Math.max(dp4N(grid, memo, row1 + 1, col1, row2 + 1, col2), dp4N(grid, memo, row1 + 1, col1, row2, col2 + 1)), // Down-Down or Down-Right
                Math.max(dp4N(grid, memo, row1, col1 + 1, row2 + 1, col2), dp4N(grid, memo, row1, col1 + 1, row2, col2 + 1))  // Right-Down or Right-Right
        );

        cherries += nextCherries;

        // Memoize and return result
        memo[row1][col1][row2][col2] = cherries;
        return cherries;
    }
}