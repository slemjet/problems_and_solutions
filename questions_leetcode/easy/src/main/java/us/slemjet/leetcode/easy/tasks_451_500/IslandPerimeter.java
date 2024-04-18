package us.slemjet.leetcode.easy.tasks_451_500;

/**
 * 463. Island Perimeter
 */
public class IslandPerimeter {

    /**
     * Time: O(n*m) ->  51.43%
     * Space:O(n*m) ->  91.11%
     */
    public int islandPerimeter(int[][] grid) {

        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // Check how many adjacent cells are 0 or out of bounds
                    for (int[] direction : directions) {
                        int nextI = i + direction[0];
                        int nextJ = j + direction[1];

                        if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[i].length) {
                            result++;
                        } else {
                            if (grid[nextI][nextJ] == 0) {
                                result++;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
