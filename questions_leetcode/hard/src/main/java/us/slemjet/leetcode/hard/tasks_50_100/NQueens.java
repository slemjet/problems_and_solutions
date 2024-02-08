package us.slemjet.leetcode.hard.tasks_50_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 51. N-Queens
 */
public class NQueens {

    /**
     * Time: -> 5.02%
     * Space: -> 90.20%
     */
    public List<List<String>> solveNQueens(int n) {

        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ".";
            }
        }

        List<List<String>> result = new ArrayList<>(new ArrayList<>());

        countSolutions(0, board, result);

        return result;
    }

    private void countSolutions(int colNumber, String[][] board, List<List<String>> result) {

        if (colNumber == board.length) {
            addResult(board, result);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (canPlaceQueen(i, colNumber, board)) {
                // Add queen and see how it goes
                board[i][colNumber] = "Q";
                countSolutions(colNumber + 1, board, result);
                // Backtrack
                board[i][colNumber] = ".";
            }
        }
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

    /**
     * Time: -> 5.03%
     * Space: -> 10.33%
     */
    public List<List<String>> solveNQueens2(int n) {

        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ".";
            }
        }

        List<List<String>> result = new ArrayList<>(new ArrayList<>());

        countSolutions2(n, 0, 0, board, result);

        return result;
    }

    private void countSolutions2(int n, int x, int y, String[][] board, List<List<String>> result) {

        if (n == 0) {
            addResult(board, result);
            return;
        }
        if (x >= board.length || y >= board[x].length) {
            return;
        }
        for (int i = x; i < board.length; i++) {
            for (int j = i == x ? y : 0; j < board[i].length; j++) {
                String currSpot = board[i][j];
                if (currSpot.equals(".")) {
                    // 1. Place Queen here
                    String[][] withQueen = copy(board);
                    withQueen[i][j] = "Q";
                    setQueensMoves(withQueen, i, j);
                    countSolutions2(n - 1, i, j, withQueen, result);

                    // 2. Do not place queen
                    board[i][j] = "X";
                    countSolutions2(n, i, j, board, result);
                }
            }
        }
    }

    private void setQueensMoves(String[][] withQueen, int x, int y) {
        for (int i = 0; i < withQueen.length; i++) {
            for (int j = 0; j < withQueen[i].length; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (i == x || j == y || Math.abs(x - i) == Math.abs(y - j)) {
                    withQueen[i][j] = "X";
                }
            }
        }
    }

    private String[][] copy(String[][] board) {
        String[][] copyBoard = new String[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        return copyBoard;
    }

    private void addResult(String[][] board, List<List<String>> result) {
        List<String> answer = Stream.of(board)
                .map(strings -> Stream.of(strings)
                        .map(s -> s.equals("X") ? "." : s)
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
        result.add(answer);
    }
}
