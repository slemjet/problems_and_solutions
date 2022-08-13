package us.slemjet.leetcode.medium.tasks_2101_2050;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 2146. K Highest Ranked Items Within a Price Range
 */
public class KHighestRankedItemsWithinAPriceRange {

    /**
     * Do BFS than sort and limit results number
     * <p>
     * Runtime: 94.32%
     * Memory Usage: 69.43%
     */
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {

        // BFS - calculate distances
        List<int[]> nodes = bfs(grid, start, pricing);

        return nodes.stream()
                .sorted((o1, o2) -> o1[2] == o2[2] ? o1[3] == o2[3] ? o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0] : o1[3] - o2[3] : o1[2] - o2[2])
                .map(node -> List.of(node[0], node[1]))
                .limit(k)
                .collect(Collectors.toList());
    }

    private List<int[]> bfs(int[][] grid, int[] start, int[] pricing) {

        List<int[]> results = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> nodes = new ArrayDeque<>();
        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};

        nodes.add(start);
        visited[start[0]][start[1]] = true;
        int distance = 1;
        while (!nodes.isEmpty()) {
            int size = nodes.size();

            for (int i = 0; i < size; i++) {
                int[] node = nodes.poll();
                int row = node[0];
                int column = node[1];

                int price = grid[row][column];
                if (price >= pricing[0] && price <= pricing[1]) {
                    results.add(new int[]{row, column, distance, price});
                }

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextColumn = column + direction[1];

                    if (nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[0].length && !visited[nextRow][nextColumn]) {
                        price = grid[nextRow][nextColumn];
                        if (price != 0)
                            nodes.add(new int[]{nextRow, nextColumn});
                        visited[nextRow][nextColumn] = true;
                    }
                }
            }
            distance++;
        }

        return results;
    }
}
