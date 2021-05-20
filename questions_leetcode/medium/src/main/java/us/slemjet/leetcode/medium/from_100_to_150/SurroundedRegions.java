package us.slemjet.leetcode.medium.from_100_to_150;

/**
 * 130. Surrounded Regions
 */
public class SurroundedRegions {

    /**
     * Runtime: 99.55%
     * Memory Usage: 51.81%
     */
    public void solve(char[][] board) {

        if (board == null) return;

        boolean[][] bordered = new boolean[board.length][board[0].length];

        // mark all bordered cells. rest can be switched.

        for (int i = 0; i < board[0].length; i++) {
            checkNeighbours(board, bordered, 0, i);
        }

        for (int i = 0; i < board[0].length; i++) {
            checkNeighbours(board, bordered, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            checkNeighbours(board, bordered, i, 0);
        }

        for (int i = 0; i < board.length; i++) {
            checkNeighbours(board, bordered, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !bordered[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void checkNeighbours(char[][] board, boolean[][] bordered, int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !bordered[x][y] && board[x][y] == 'O') {
//            System.out.println(String.format("Bordered cell: [%s][%s]", x, y));
            bordered[x][y] = true;
            checkNeighbours(board, bordered, x - 1, y);
            checkNeighbours(board, bordered, x + 1, y);
            checkNeighbours(board, bordered, x, y - 1);
            checkNeighbours(board, bordered, x, y + 1);
        }
    }
}
