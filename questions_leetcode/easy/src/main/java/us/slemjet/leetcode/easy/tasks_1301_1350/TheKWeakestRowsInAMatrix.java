package us.slemjet.leetcode.easy.tasks_1301_1350;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1337. The K Weakest Rows in a Matrix
 */
public class TheKWeakestRowsInAMatrix {

    /**
     * Runtime: 60.90%
     * Memory Usage: 49.95%
     */
    public int[] kWeakestRows(int[][] mat, int k) {

        Queue<int[]> weakestRows = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            else return Integer.compare(o2[0], o1[0]);
        });

        for (int i = 0; i < mat.length; i++) {
            int idx = findFirstNumber(mat[i], 0);

            weakestRows.offer(new int[]{idx, i});
            if (weakestRows.size() > k) weakestRows.poll();
        }

        int[] result = new int[k];
        while (!weakestRows.isEmpty()) result[weakestRows.size() - 1] = weakestRows.poll()[1];
        return result;
    }

    /**
     * Runtime: 12.60%
     * Memory Usage: 40.02%
     */
    public int[] kWeakestRows2(int[][] mat, int k) {

        int[] result = new int[k];
        int[][] nodes = new int[mat.length][2];

        for (int i = 0; i < mat.length; i++) {
            int idx = findFirstNumber(mat[i], 0);
            idx = idx >= 0 ? idx : mat[i].length;
            nodes[i] = new int[]{idx, i};
        }

        Arrays.sort(nodes, Comparator.comparingInt((int[] value) -> value[0]).thenComparingInt(value -> value[1]));

        for (int i = 0; i < k; i++) {
            result[i] = nodes[i][1];
        }

        return result;
    }

    private int findFirstNumber(int[] values, int targetValue) {

        int leftIdx = 0;
        int rightIdx = values.length - 1;

        while (leftIdx <= rightIdx) {
            int medIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if (values[medIdx] > targetValue) {
                leftIdx = medIdx + 1;
            } else {
                rightIdx = medIdx - 1;
            }
        }

        return leftIdx;
    }
}
