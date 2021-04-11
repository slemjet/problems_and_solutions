package us.slemjet.leetcode.easy.from_1_to_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */
public class PascalsTriangle {

    /**
     * Runtime: 100.00%
     * Memory Usage: 35.77%
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        int rowNum = 0;
        while (rowNum < numRows) {

            List<Integer> currentRow = new ArrayList<>(rowNum + 1);
            int med = (rowNum + 1) / 2 + (rowNum + 1) % 2;

            int currIdx = 0;
            while (currIdx < med) { // populate first half (is unique)
                List<Integer> prevRow = rowNum == 0 ? null : result.get(rowNum - 1);
                currentRow.add(currIdx, (currIdx == 0 ? 1 : prevRow.get(currIdx - 1) + prevRow.get(currIdx)));
                currIdx++;
            }

            while (currIdx < rowNum + 1) { // populate second half (mirror of the first)
                currentRow.add(currIdx, currentRow.get(rowNum - currIdx));
                currIdx++;
            }

            result.add(rowNum, currentRow);
            rowNum++;
        }

        return result;
    }

}
