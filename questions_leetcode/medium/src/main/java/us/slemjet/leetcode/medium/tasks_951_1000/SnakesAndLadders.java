package us.slemjet.leetcode.medium.tasks_951_1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 909. Snakes and Ladders
 */
public class SnakesAndLadders {

    /**
     * Runtime: 44.57%
     * Memory Usage: 12.13%
     */
    public int snakesAndLadders2(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<Integer> nodes = new LinkedList<>(); // Store currently processed nodes
        nodes.offer(1);

        boolean[] visited = new boolean[rows * cols + 1]; // Store visited nodes

        for (int level = 0; !nodes.isEmpty(); level++) {
            // Each level of tree is a move. We do BFS on a tree
            int size = nodes.size();
            for (int j = 0; j < size; j++) {
                // Process each node of current level
                Integer node = nodes.poll();
                if (visited[node]) continue; // Already processed
                visited[node] = true;
                if (node == rows * cols) return level; // Found solution
                for (int next = 1; next <= 6 && node + next <= rows * cols; next++) {
                    // Check every next combination
                    int nextNode = node + next;
                    int boardValue = getBoardValue(board, rows, cols, nextNode);
                    if (boardValue != -1) nextNode = boardValue; // Use a shortcut (is a must)
                    if (!visited[nextNode]) nodes.offer(nextNode);
                }
            }
        }

        return -1;
    }

    private int getBoardValue(int[][] board, int rows, int cols, int i) {
        int row = (i - 1) / cols;
        int col = (i - 1) % cols;
        if (row % 2 == 1) col = cols - col - 1; // Switch direction
        return board[rows - row - 1][col];
    }
}
