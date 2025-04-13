package us.slemjet.leetcode.hard.tasks_301_350;

import us.slemjet.leetcode.common.UnionFindGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * 305. Number of Islands II
 */
public class NumberOfIslandsII {

    /**
     * Returns the number of islands after each position in the grid is added.
     * <p>
     * Time: O(N * M + L), where L = positions.length
     * Space: O(N x M), for the grid and Union-Find structure.
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> result = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFindGrid unionFindGrid = new UnionFindGrid(m, n);
        int[][] grid = new int[m][n];

        for (int posIdx = 0; posIdx < positions.length; posIdx++) {
            int[] position = positions[posIdx];
            int row = position[0];
            int col = position[1];
            int updateCount = 0;

            if (grid[row][col] == 0) {
                grid[row][col] = 1;
                updateCount = 1;

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                            grid[newRow][newCol] != 0 && !unionFindGrid.isConnected(row, col, newRow, newCol)) {
                        unionFindGrid.unite(row, col, newRow, newCol);
                        updateCount--;
                    }
                }
            }

            int prevCount = posIdx > 0 ? result.get(posIdx - 1) : 0;
            result.add(prevCount + updateCount);
        }

        return result;
    }
}
