package us.slemjet.leetcode.hard.from_301_to_350;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 329. Longest Increasing Path in a Matrix
 */
public class LongestIncreasingPathInAMatrix {

    /**
     * DFS + Memoization (DP)
     * Runtime: 32.18%
     * Memory Usage: 13.89%
     */
    public int longestIncreasingPath(int[][] matrix) {

        int maxPath = 0;
        // Directions to scan
        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};
        // Store all max paths to this point
        int[][] maxPathsMemo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int currMaxPath = maxPath(matrix, maxPathsMemo, directions, i, j, matrix[i][j]);
                maxPath = Math.max(maxPath, currMaxPath);
            }
        }
        return maxPath;
    }

    private int maxPath(int[][] matrix, int[][] maxPathsMemo, int[][] directions, int i, int j, int prevVal) {

        if (maxPathsMemo[i][j] != 0) return maxPathsMemo[i][j];

        // Default length is 1 (current cell only)
        int maxPath = 1;

        for (int[] direction : directions) {
            int di = i + direction[0];
            int dj = j + direction[1];

            // Scan all directions
            if (di >= 0 && di < matrix.length && dj >= 0 && dj < matrix[i].length && prevVal > matrix[di][dj]) {
                int currMaxPath = 1 + maxPath(matrix, maxPathsMemo, directions, di, dj, matrix[di][dj]);
                maxPath = Math.max(maxPath, currMaxPath);
            }
        }

        maxPathsMemo[i][j] = maxPath;
        return maxPath;
    }

    /**
     * Use BFS - Topological sort/ Kahn algorithm
     *
     * Runtime: 24.32%
     * Memory Usage: 64.14%
     */
    public int longestIncreasingPathTopological(int[][] matrix) {

        // Treat matrix as DAG (directed acyclic graph)
        // Indegree array (number of edges coming to this element)
        int[][] indegree = new int[matrix.length][matrix[0].length];
        // Directions to scan
        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int[] direction : directions) {
                    int di = i + direction[0];
                    int dj = j + direction[1];

                    // Scan all directions
                    if (di >= 0 && di < matrix.length && dj >= 0 && dj < matrix[i].length) {
                        if (matrix[i][j] < matrix[di][dj]) {
                            // Can move from matrix[i][j] to matrix[di][dj] -> increment indegree for current node
                            indegree[di][dj]++;
                        }
                    }
                }
            }
        }

        // Queue, containing list of starting nodes (which do not have any incoming edges)
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (indegree[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }

        int maxPath = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] currNode = queue.poll();
                int x = currNode[0];
                int y = currNode[1];

                for (int[] direction : directions) {
                    int dx = x + direction[0];
                    int dy = y + direction[1];

                    if (dx >= 0 && dx < matrix.length && dy >= 0 && dy < matrix[x].length) {
                        if (matrix[x][y] < matrix[dx][dy]) {
                            // Can move in current direction
                            indegree[dx][dy]--; // We remove current node - so we need to remove from indegree count
                            if (indegree[dx][dy] == 0) {
                                queue.offer(new int[]{dx, dy});  // Node becomes next base node - add to queue for processing
                            }
                        }
                    }
                }
            }
            maxPath++; // Current level is processed
        }
        return maxPath;
    }
}
