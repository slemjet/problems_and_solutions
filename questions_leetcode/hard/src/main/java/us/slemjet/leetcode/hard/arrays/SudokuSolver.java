package us.slemjet.leetcode.hard.arrays;

public class SudokuSolver {

    /**
     * Uses Backtrack to find solution
     * Runtime: 27.37%
     * Memory 75.44%
     *
     * @param board
     */
    public void solveSudokuBacktrack(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) return true; // Reached end of matrix -> solution found

        int nextRow = (col + 1) == board[0].length ? row + 1 : row;
        int nextCol = (col + 1) == board[0].length ? 0 : col + 1;
        if (Character.isDigit(board[row][col]))
            return solve(board, nextRow, nextCol); // value already set -> solve with next indices
        else {
            // search for potential solution
            for (char k = '1'; k <= '9'; k++) {
                if (isValid(board, row, col, k)) {
                    // set candidate value to the cell
                    board[row][col] = k;
                    // check if it solves the board
                    if (solve(board, nextRow, nextCol))
                        return true;
                    else // revert changes and try with another candidate -> Backtrack
                        board[row][col] = '.';
                }
            }
            return false; // could not find a candidate to match
        }
    }

    private boolean isValid(char[][] board, int row, int col, char val) {
        // check if no duplicate exist in the row, column and block
        int cubeRowIdx = (row / 3) * 3;
        int cubeColIdx = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val || board[row][i] == val ||
                    board[cubeRowIdx + (i / 3)][cubeColIdx + (i % 3)] == val) return false;
        }
        return true;
    }
}
