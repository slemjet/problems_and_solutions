package us.slemjet.leetcode.medium.tasks_1601_1650;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. Nearest Exit from Entrance in Maze
 */
public class NearestExitFromEntranceInMaze {

    /**
     * Use BFS
     *
     * Runtime: 82.02%
     * Memory Usage: 53.19%
     *
     * Space: O(n*m)
     * Time: O(n*m)
     */
    public int nearestExit(char[][] maze, int[] entrance) {

        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        Queue<int[]> nodes = new LinkedList<>();
        nodes.add(entrance);

        int steps = 0;
        while (!nodes.isEmpty()) {
            int length = nodes.size();
            for (int i = 0; i < length; i++) {
                int[] node = nodes.poll();
                for (int[] direction : directions) {
                    int[] nextNode = new int[]{node[0] + direction[0], node[1] + direction[1]};
                    if (nextNode[0] < 0 || nextNode[0] >= maze.length || nextNode[1] < 0 || nextNode[1] >= maze[0].length) {
                        if (steps == 0) continue; // Skip if entrance == exit
                        return steps; // Found result
                    } else if (visited[nextNode[0]][nextNode[1]] || maze[nextNode[0]][nextNode[1]] == '+') {
                        visited[nextNode[0]][nextNode[1]] = true;
                        continue; // Is a wall
                    }
                    nodes.offer(nextNode);
                    visited[nextNode[0]][nextNode[1]] = true;
                }
            }
            steps++;
        }

        return -1;
    }
}
