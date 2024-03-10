package us.slemjet.leetcode.medium.tasks_2801_2850;

import java.util.ArrayList;
import java.util.List;

/**
 * 2850. Minimum Moves to Spread Stones Over Grid
 */
public class MinimumMovesToSpreadStonesOverGrid {

    /**
     * Time:    -> 56.19%
     * Space:   -> 18.66%
     */
    public int minimumMoves(int[][] grid) {

        List<int[]> stones = new ArrayList<>();
        int stoneCounts = 0;
        List<int[]> zeroes = new ArrayList<>();
        int zeroCounts = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    zeroes.add(new int[]{i, j});
                    zeroCounts = (zeroCounts << 1) + 1;
                }
                if (grid[i][j] > 1) {
                    int count = grid[i][j] - 1;
                    while (count > 0) {
                        stones.add(new int[]{i, j});
                        stoneCounts = (stoneCounts << 1) + 1;
                        count--;
                    }
                }
            }
        }

        Integer[][] memo = new Integer[stoneCounts + 1][zeroCounts + 1];
        return minimumMoves(stones, stoneCounts, zeroes, zeroCounts, memo);
    }

    private int minimumMoves(List<int[]> stones, int stoneCounts, List<int[]> zeroes, int zeroCounts, Integer[][] memo) {

        if (stoneCounts == 0 && zeroCounts == 0) {
            return 0;
        }

        if (memo[stoneCounts][zeroCounts] == null) {

            int result = Integer.MAX_VALUE;

            for (int i = 0; i < stones.size(); i++) {
                for (int j = 0; j < zeroes.size(); j++) {

                    boolean canUseStone = (stoneCounts & (1 << i)) != 0;
                    boolean needToFillZero = (zeroCounts & (1 << j)) != 0;
                    if (canUseStone && needToFillZero) {
                        int[] stone = stones.get(i);
                        int[] zero = zeroes.get(j);
                        int moves = Math.abs(stone[0] - zero[0]) + Math.abs(stone[1] - zero[1]);
                        stoneCounts ^= (1 << i);
                        zeroCounts ^= (1 << j);
                        int remainingMoves = minimumMoves(stones, stoneCounts, zeroes, zeroCounts, memo);
                        if (remainingMoves != Integer.MAX_VALUE) {
                            moves += remainingMoves;
                        }
                        result = Math.min(result, moves);
                        stoneCounts ^= (1 << i);
                        zeroCounts ^= (1 << j);
                    }
                }
            }

            memo[stoneCounts][zeroCounts] = result;
        }
        return memo[stoneCounts][zeroCounts];
    }

    public int minimumMoves2(int[][] grid) {

        boolean[] zeroes = new boolean[9];
        int[] stones = new int[9];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    zeroes[i * 3 + j] = true;
                }
                if (grid[i][j] > 1) {
                    stones[i * 3 + j] = grid[i][j] - 1;
                }
            }
        }

        return minimumMoves2(zeroes, stones);
    }

    private int minimumMoves2(boolean[] zeroes, int[] stones) {

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < zeroes.length; i++) {
            for (int j = 0; j < stones.length; j++) {
                if(zeroes[i] && stones[j] > 0){

                    int moves = Math.abs(i / 3 - j / 3) + Math.abs(i % 3 - j % 3);
                    zeroes[i] = false;
                    stones[j]--;
                    int remainingMoves = minimumMoves2(zeroes, stones);
                    if (remainingMoves != Integer.MAX_VALUE) {
                        moves += remainingMoves;
                    }
                    result = Math.min(result, moves);
                    zeroes[i] = true;
                    stones[j]++;
                }
            }
        }
        return result;
    }
}
