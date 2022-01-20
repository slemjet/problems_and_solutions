package us.slemjet.leetcode.easy.from_100_to_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 */
public class PascalsTriangleII {

    /**
     * Runtime: 36.50%
     * Memory Usage: 43.80%
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> nthRow = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = nthRow.size() - 1; j > 0; j--) {
                nthRow.set(j, nthRow.get(j) + nthRow.get(j - 1));
            }
            nthRow.add(1);
        }

        return nthRow;
    }
}
