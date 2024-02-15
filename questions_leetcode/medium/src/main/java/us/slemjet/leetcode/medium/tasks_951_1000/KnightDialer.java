package us.slemjet.leetcode.medium.tasks_951_1000;

/**
 * 935. Knight Dialer
 */
public class KnightDialer {

    /**
     * Top To Bottom - Memoization
     *
     * Time: O()    ->  21.01%
     * Space:O()    ->  9.84%
     */
    public int knightDialer(int n) {

        int modulo = (int) (Math.pow(10, 9) + 7);

        int[][] moves = new int[][]{
                new int[]{2, 1}, new int[]{2, -1}, new int[]{-2, 1}, new int[]{-2, -1},
                new int[]{1, 2}, new int[]{1, -2}, new int[]{-1, 2}, new int[]{-1, -2}};

        Integer[][][] memo = new Integer[4][3][n];


        int result = knightDialer(3, 1, n - 1, moves, memo, modulo) % modulo;

        for (int i = 1; i < 10; i++) {
            result = (result + knightDialer((i - 1) / 3, (i - 1) % 3, n - 1, moves, memo, modulo)) % modulo;
        }

        return result;
    }

    private int knightDialer(int row, int col, int remining, int[][] moves, Integer[][][] memo, int modulo) {

        if (row < 0 || row >= 4 || col < 0 || col >= 3 ||
                (row == 3 && col == 0) || (row == 3 && col == 2)) {
            return 0; // Out of bounds - cannot continue
        }

        if (remining == 0) {
            return 1; // Combination found
        }

        if (memo[row][col][remining] == null) {
            int count = 0;
            for (int[] move : moves) {
                count = (count + knightDialer(row + move[0], col + move[1], remining - 1, moves, memo, modulo)) % modulo;
            }
            memo[row][col][remining] = count;
        }

        return memo[row][col][remining];
    }
}
