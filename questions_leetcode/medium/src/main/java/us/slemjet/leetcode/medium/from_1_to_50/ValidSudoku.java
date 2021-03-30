package us.slemjet.leetcode.medium.from_1_to_50;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] cubes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(Character.isDigit(board[i][j])){
                    int cubeIdx = (i / 3) * 3 + (j / 3); // cube index (i - rows (* 3), j - columns)
                    int num = Character.getNumericValue(board[i][j]);
                    // check if bit was already set. If it was previously set -> duplicate case -> return false
                    if (((rows[i] >> num) & 1) == 1) return false;
                    if (((cols[j] >> num) & 1) == 1) return false;
                    if (((cubes[cubeIdx] >> num) & 1) == 1) return false;
                    //  set appropriate bit for each columns, rows and cubes
                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    cubes[cubeIdx] |= (1 << num);
                }
            }
        }
        return true;
    }

    /**
     * Solution, which separately treats rows, columns and blocks
     * Runtime: 70%
     * Memory: 97%
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {

        // traversing in diagonal
        int[][] checkArray = new int[2][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // check vertical
                if (isDuplicate(checkArray[0], board[i][j])) return false; // duplicate
                // check horizontal
                if (isDuplicate(checkArray[1], board[j][i])) return false; // duplicate
            }
            checkArray[0] = new int[10];
            checkArray[1] = new int[10];
        }

        // validate all blocks
        int[][] check = new int[10][10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isDuplicate(check[0], board[i][j])) return false;
                if (isDuplicate(check[1], board[i + 3][j])) return false;
                if (isDuplicate(check[2], board[i + 6][j])) return false;
                if (isDuplicate(check[3], board[i][j])) return false;
                if (isDuplicate(check[4], board[i][j + 3])) return false;
                if (isDuplicate(check[5], board[i][j + 6])) return false;
                if (isDuplicate(check[6], board[i + 3][j + 3])) return false;
                if (isDuplicate(check[7], board[i + 6][j + 6])) return false;
                if (isDuplicate(check[8], board[i + 3][j + 6])) return false;
                if (isDuplicate(check[9], board[i + 6][j + 3])) return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(int[] check, char value) {
        if (Character.isDigit(value)) {
            int index = Character.getNumericValue(value);
            if (check[index] == 0)
                check[index] = 1;
            else
                return true;
        }
        return false;
    }
}
