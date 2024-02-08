package us.slemjet.leetcode.hard.tasks_50_100;

/**
 * 52. N-Queens II
 */
public class NQueensII {

    /**
     * Time: -> 5.07%
     * Space: -> 76.28%
     */
    public int totalNQueens(int n) {

        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ".";
            }
        }

        return countSolutions(0, board);
    }

    private int countSolutions(int colNumber, String[][] board) {

        if (colNumber == board.length) {
            return 1;
        }

        int sum = 0;

        for (int i = 0; i < board.length; i++) {
            if (canPlaceQueen(i, colNumber, board)) {
                // Add queen and see how it goes
                board[i][colNumber] = "Q";
                sum += countSolutions(colNumber + 1, board);
                // Backtrack
                board[i][colNumber] = ".";
            }
        }
        return sum;
    }

    private boolean canPlaceQueen(int colNumber, int rowNumber, String[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j].equals("Q") &&
                        (i == colNumber || j == rowNumber || Math.abs(colNumber - i) == Math.abs(rowNumber - j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
