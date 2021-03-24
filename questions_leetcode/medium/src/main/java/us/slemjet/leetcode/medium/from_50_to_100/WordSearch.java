package us.slemjet.leetcode.medium.from_50_to_100;

/**
 * 79. Word Search
 *
 * Runtime: 9.66%
 * Memory Usage: 21.23%
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exists(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int i, int j, String word, int idx) {

        // Solution found
        if (word.length() == idx) return true;

        // Out of border size
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.length() < idx)
            return false;

        // Character match
        if (board[i][j] == word.charAt(idx++)) {
            board[i][j] ^= 256; // Mark as done inline - so it wont match any single char
            boolean exists = exists(board, i + 1, j, word, idx) ||
                    exists(board, i, j + 1, word, idx) ||
                    exists(board, i - 1, j, word, idx) ||
                    exists(board, i, j - 1, word, idx);
            board[i][j] ^= 256; // Un-mark as done inline
            return exists;
        } else
            return false;
    }
}
