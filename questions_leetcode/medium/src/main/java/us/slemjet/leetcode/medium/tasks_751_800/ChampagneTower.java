package us.slemjet.leetcode.medium.tasks_751_800;

/**
 * 799. Champagne Tower
 */
public class ChampagneTower {

    /**
     * Simulate amount of water coming through all glasses
     * <p>
     * 8
     * <p>
     * 3.5           3.5
     * <p>
     * 1.25      2.5       1.25
     * <p>
     * 0.125  0.875  0.875  0.125
     * <p>
     * Runtime: 90.87%
     * Memory Usage: 56.17%
     */
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[] prevRow = new double[0];
        double[] currRow = new double[prevRow.length + 1];

        currRow[0] = poured;
        while (query_row > 0) {
            query_row--;
            prevRow = currRow;
            currRow = new double[prevRow.length + 1];

            for (int i = 0; i < prevRow.length; i++) {
                if (prevRow[i] <= 1) continue;
                double overflowWater = (prevRow[i] - 1) / 2;
                currRow[i] += overflowWater;
                currRow[i + 1] += overflowWater;
            }
        }

        return Math.min(1, currRow[query_glass]);
    }

    /**
     * Use one array for optimization
     *
     * Runtime: 79.91%
     * Memory Usage: 71.23%
     */
    public double champagneTowerSingleArray(int poured, int query_row, int query_glass) {

        double[] row = new double[query_row + 1];
        row[0] = poured;

        while (query_row-- > 0) {
            int currSize = row.length - query_row - 1;
            double nextTmp = row[0]; // Store next value (as it will be replaced)
            row[0] = 0;
            for (int i = 0; i < currSize; i++) {
                double overflowWater = Math.max(0.0, (nextTmp - 1) / 2);
                if (i < currSize - 1) {
                    nextTmp = row[i + 1];
                    row[i + 1] = 0;
                }
                row[i] += overflowWater;
                row[i + 1] += overflowWater;
            }
        }
        return Math.min(1, row[query_glass]);
    }
}
