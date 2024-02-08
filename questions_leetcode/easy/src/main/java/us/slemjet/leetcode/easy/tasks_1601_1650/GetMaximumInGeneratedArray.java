package us.slemjet.leetcode.easy.tasks_1601_1650;

/**
 * 1646. Get Maximum in Generated Array
 */
public class GetMaximumInGeneratedArray {

    /**
     * Runtime: 82.06%
     * Memory Usage: 32.23%
     */
    public int getMaximumGenerated(int n) {

        if (n < 2) return n;

        int[] results = new int[n + 1];
        results[1] = 1;

        int max = 1;
        for (int i = 2; i <= n; i++) {
            results[i] = results[i / 2];
            if (i % 2 == 1) {
                results[i] += results[(i / 2) + 1];
            }
            max = Math.max(max, results[i]);
        }

        return max;
    }
}
