package us.slemjet.leetcode.medium.tasks_251_300;

/**
 * 289. Game of Life
 */
public class GameOfLife {

    /**
     * Runtime: 100.00%
     * Memory Usage: 70.62%
     */
    public void gameOfLife(int[][] board) {

        // Use 2 bits 01 -> first bit [1] -> before, second bit [0] -> after,
        // 00 (0) - > 0 -> 0
        // 01 (1) - > 1 -> 0
        // 10 (2) - > 0 -> 1
        // 11 (3) - > 1 -> 1

        // directions
        int[][] direction = new int[][]{{-1, -1}, {0, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, 1}, {-1, 1}, {1, -1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int sum = 0;
                for (int[] dir : direction) {
                    if (i + dir[0] < 0 || i + dir[0] >= board.length ||
                            j + dir[1] < 0 || j + dir[1] >= board[i].length)
                        continue; // Out of boundaries -> Skip

                    sum += board[i + dir[0]][j + dir[1]] & 1; // We need first bit (state before)
                }

                // Set values according to criteria
                int value = board[i][j] & 1;
                int newValue = value;
                // 1. sum > 3, val = 1 -> overpopulation (can skip this step as value is 01 already)
                if (value == 1 && sum > 3) newValue = 1;
                // 2. sum == 3 && val = 0 -> repopulation
                else if (value == 0 && sum == 3) newValue = 2;
                // 3. sum == 2 | 3, value = 1 -> stays 1
                else if (value == 1 && sum == 2 || sum == 3) newValue = 3;
                board[i][j] = newValue;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // We need only second (larger) bit -> shift by 2
                board[i][j] >>= 1; // Can be board[i][j] % 2
            }
        }
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 56.86%
     */
    public void gameOfLifeTrivial(int[][] board) {

        int[][] result = new int[board.length][board[0].length];
        boolean[][] visited = new boolean[board.length][board[0].length];
        calculate(0, 0, board, result, visited);

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board[i].length);
        }
    }

    private void calculate(int i, int j, int[][] board, int[][] result, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return;
        if (visited[i][j]) return;

        int sum = 0;
        if (i > 0 && j > 0) sum += board[i - 1][j - 1];
        if (i > 0) sum += board[i - 1][j];
        if (i > 0 && j < board[i].length - 1) sum += board[i - 1][j + 1];

        if (j > 0) sum += board[i][j - 1];
        if (j < board[i].length - 1) sum += board[i][j + 1];

        if (i < board.length - 1 && j > 0) sum += board[i + 1][j - 1];
        if (i < board.length - 1) sum += board[i + 1][j];
        if (i < board.length - 1 && j < board[i].length - 1) sum += board[i + 1][j + 1];

        int currVal = board[i][j];
        int newVal = currVal;
        if (sum > 3 && currVal == 1) newVal = 0;
        else if (sum < 2) newVal = 0;
        else if (sum == 3 && currVal == 0) newVal = 1;

        result[i][j] = newVal;
        visited[i][j] = true;

        calculate(i + 1, j, board, result, visited);
        calculate(i, j + 1, board, result, visited);
        calculate(i + 1, j + 1, board, result, visited);

    }
}
