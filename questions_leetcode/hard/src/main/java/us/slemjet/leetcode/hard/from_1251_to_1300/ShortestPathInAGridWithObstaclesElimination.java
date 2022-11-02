package us.slemjet.leetcode.hard.from_1251_to_1300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 */
public class ShortestPathInAGridWithObstaclesElimination {

    /**
     * Runtime: 63.01%
     * Memory Usage: 70.35%
     */
    public int shortestPath(int[][] grid, int k) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        // Contains number of eliminations to get to this node
        Integer[][] visited = new Integer[grid.length][grid[0].length];
        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};

        Queue<Node> nodes = new LinkedList<>();

        nodes.add(new Node(0, 0, 0));
        visited[0][0] = 0;

        int length = 0;
        while (!nodes.isEmpty()) {

            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Node currNode = nodes.poll();
                if (currNode.y == grid.length - 1 && currNode.x == grid[0].length - 1) return length;

                for (int[] direction : directions) {
                    int nextX = currNode.x + direction[0];
                    int nextY = currNode.y + direction[1];

                    // Should be in grid bounds
                    if (nextY >= 0 && nextY < grid.length && nextX >= 0 && nextX < grid[0].length) {

                        int nextEliminations = currNode.eliminations + grid[nextY][nextX];
                        // eliminations need to be <= k and !IMPORTANT! less than previous eliminations to this cell
                        if (nextEliminations <= k && (visited[nextY][nextX] == null || nextEliminations < visited[nextY][nextX])) {
                            nodes.add(new Node(nextX, nextY, nextEliminations));
                            visited[nextY][nextX] = nextEliminations;
                        }
                    }
                }
            }
            length++;
        }
        return -1;
    }

    private record Node(int x, int y, int eliminations) {
    }
}
