package us.slemjet.leetcode.medium.tasks_51_100;

/**
 * 59. Spiral Matrix II
 */
public class SpiralMatrixII {

    /**
     * Time: O(n*n) -> 100.00%
     * Space: O(n*n) -> 32.66%
     */
    public int[][] generateMatrixSimple(int n) {

        int[][] result = new int[n][n];

        int y = 0;
        int x = 0;
        int val = 1;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currDir = 0;

        while (val <= n * n) {
            result[y][x] = val++;
            int r = Math.floorMod(y + direction[currDir][0], n);
            int c = Math.floorMod(x + direction[currDir][1], n);

            // Already visited cell -> change direction
            if (result[r][c] != 0){
                currDir = (currDir + 1) % 4;
            }

            y += direction[currDir][0];
            x += direction[currDir][1];
        }
        return result;
    }

    /**
     * Time: O(n*n) -> 100.00%
     * Space: O(n*n) -> 43.32%
     */
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int x = 0;
        int y = 0;
        int val = 1;
        int deltaX = 1;
        int deltaY = -1;
        boolean isVertical = false;

        while (x >= 0 && x < n && y >= 0 && y < n && result[y][x] == 0) {
            result[y][x] = val++;

            if (isVertical) {
                if (y + deltaY == n || y + deltaY < 0 || result[y + deltaY][x] != 0) {
                    isVertical = !isVertical;
                    deltaX = -1 * deltaX;
                    x += deltaX;
                } else {
                    y += deltaY;
                }
            } else {
                if (x + deltaX == n || x + deltaX < 0 || result[y][x + deltaX] != 0) {
                    isVertical = !isVertical;
                    deltaY = -1 * deltaY;
                    y += deltaY;
                } else {
                    x += deltaX;
                }
            }
        }

        return result;
    }
}
