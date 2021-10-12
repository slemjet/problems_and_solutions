package us.slemjet.leetcode.medium.tasks_101_150;

/**
 * 130. Surrounded Regions
 */
public class SurroundedRegions {

    /**
     * Runtime: 99.56%
     * Memory Usage: 63.66%
     */
    public void solve(char[][] board) {

        if (board == null) return;

        // mark all bordered cells. rest can be switched.
        for (int i = 0; i < board[0].length; i++) {
            checkNeighbours(board, 0, i);
            checkNeighbours(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            checkNeighbours(board, i, 0);
            checkNeighbours(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == 'O') {
                    board[i][j] = 'X';
                } else if (c == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void checkNeighbours(char[][] board, int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != 'B' && board[x][y] == 'O') {
            board[x][y] = 'B';
            checkNeighbours(board, x - 1, y);
            checkNeighbours(board, x + 1, y);
            checkNeighbours(board, x, y - 1);
            checkNeighbours(board, x, y + 1);
        }
    }
}
