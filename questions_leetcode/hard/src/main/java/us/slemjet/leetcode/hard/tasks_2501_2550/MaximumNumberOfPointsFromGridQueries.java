package us.slemjet.leetcode.hard.tasks_2501_2550;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2503. Maximum Number of Points From Grid Queries
 */
public class MaximumNumberOfPointsFromGridQueries {

    /**
     * Time: O(nlogn)   ->  6.52%
     * Space:O(n)       ->  39.13%
     */
    public int[] maxPoints(int[][] grid, int[] queries) {

        int[] result = new int[queries.length];
        int[][] queriesWithIdx = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIdx[i] = new int[]{queries[i], i};
        }
        // Sort queries by their values
        Arrays.sort(queriesWithIdx, Comparator.comparingInt(a -> a[0]));

        // Priority queue to process nodes in the order of their values by max value in grid
        PriorityQueue<int[]> nodes = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        nodes.add(new int[]{0, 0});

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int count = 0;

        for (int[] queryWithIndex : queriesWithIdx) {

            int query = queryWithIndex[0];

            // Process all reachable nodes with values less than the current query value
            while (!nodes.isEmpty() && grid[nodes.peek()[0]][nodes.peek()[1]] < query) {

                int[] node = nodes.poll();
                int x = node[0], y = node[1];
                if (visited[x][y]) continue;
                visited[x][y] = true;
                count++;
                // Add all adjoining nodes to the priority queue
                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (newX >= 0 && newX < grid.length
                            && newY >= 0 && newY < grid[0].length
                            && !visited[newX][newY]) {
                        nodes.add(new int[]{newX, newY});
                    }
                }
            }
            result[queryWithIndex[1]] = count;
        }
        return result;
    }
}