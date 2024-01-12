package us.slemjet.leetcode.medium.tasks_351_400;

/**
 * 351. Android Unlock Patterns
 */
public class AndroidUnlockPatterns {

    /**
     * Time:    ->  84.35%
     * Space:   ->  27.83%
     */
    public int numberOfPatterns(int m, int n) {

        int[][] checkCells = new int[10][10];
        checkCells[1][3] = checkCells[3][1] = 2;
        checkCells[1][7] = checkCells[7][1] = 4;
        checkCells[3][9] = checkCells[9][3] = 6;
        checkCells[7][9] = checkCells[9][7] = 8;
        checkCells[1][9] = checkCells[9][1] = checkCells[3][7] = checkCells[7][3] =
                checkCells[4][6] = checkCells[6][4] = checkCells[2][8] = checkCells[8][2] = 5;

        boolean[] isVisited = new boolean[10];

        int count = 0;
        for (int i = m; i <= n; ++i) {
            // Some of the numbers are symmetrical and have same restrictions - we can optimize calculations
            count += countCombinations(isVisited, checkCells, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetrical
            count += countCombinations(isVisited, checkCells, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetrical
            count += countCombinations(isVisited, checkCells, 5, i - 1); //
        }

        return count;
    }

    private int countCombinations(boolean[] isVisited, int[][] checkCells, int num, int remaining) {
        if (remaining < 0) {
            return 0;
        }
        if (remaining == 0) {
            return 1;
        }
        isVisited[num] = true;

        int count = 0;
        for (int i = 1; i <= 9; ++i) {
            // Cell must not be visited and either contain mandatory intermediate cell (== 0)
            // or if such cell is required - it needs to be visited
            if (!isVisited[i] && (checkCells[num][i] == 0 || isVisited[checkCells[num][i]])) {
                count += countCombinations(isVisited, checkCells, i, remaining - 1);
            }
        }
        isVisited[num] = false;
        return count;
    }
}
