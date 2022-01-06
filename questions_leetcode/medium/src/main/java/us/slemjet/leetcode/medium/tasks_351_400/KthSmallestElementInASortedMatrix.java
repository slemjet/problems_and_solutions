package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestElementInASortedMatrix {

    /**
     * Binary search
     *
     * Runtime: 63.72%
     * Memory Usage: 5.44%
     */
    public int kthSmallest(int[][] matrix, int k) {

        int rowMax = matrix.length;
        int colMax = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[rowMax - 1][colMax - 1];

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int count = 0; // Number of elements < mid
            int max = low;

            // Count number of nums less than mid
            for (int row = 0; row < rowMax; row++) {
                int col = matrix[0].length - 1;
                while (col >= 0 && matrix[row][col] > mid) col--;
                if (col >= 0) {
                    count += (col + 1); // Nums <= mid
                    max = Math.max(max, matrix[row][col]); // Find max value - closer to mid
                }
            }

            if (count == k) return max; // Found solution
            if (count < k) low = mid + 1; // Not enough results - shift to subset with greater values
            else high = mid - 1; // Too many results - shift to subset with lesser values
        }

        return low;
    }

    /**
     * Runtime: 5.91%
     * Memory Usage: 18.84%
     */
    public int kthSmallestQueue(int[][] matrix, int k) {

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int xSize = Math.min(matrix.length, k);
        for (int x = 0; x < xSize; x++) {
            queue.offer(new int[]{matrix[0][x], 0, x}); // Populate initial row of values
        }

        for (int i = 0; i < k - 1; i++) { // For each get the value till k is reached (s k is in the queue)
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[2];
            if (x == xSize - 1) continue;
            queue.offer(new int[]{matrix[x + 1][y], x + 1, y});
        }
        return queue.poll()[0]; // Current smallest is k-th
    }

    /**
     * Runtime: 5.04%
     * Memory Usage: 26.02%
     */
    public int kthSmallestQueue2(int[][] matrix, int k) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        queue.add(new int[]{matrix[0][0], 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (--k == 0) return poll[0];
            int i = poll[1];
            int j = poll[2];

            if (i < matrix.length - 1 && !visited[i + 1][j]) {
                queue.add(new int[]{matrix[i + 1][j], i + 1, j});
                visited[i + 1][j] = true;
            }

            if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
                queue.add(new int[]{matrix[i][j + 1], i, j + 1});
                visited[i][j + 1] = true;
            }
        }

        return 0;
    }
}
