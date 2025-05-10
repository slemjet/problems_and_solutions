package us.slemjet.hackerrank.questions.warmup;

import java.util.List;

/**
 *
 */
public class DiagonalDifference {

    /**
     * Time:    O(n)
     * Space:   O(1)
     */

    public int diagonalDifference(List<List<Integer>> arr) {

        // Write your code here
        int result;
        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = 0; i < arr.size(); i++) {

            List<Integer> row = arr.get(i);

            diagonal1 += row.get(i);
            diagonal2 += row.get(arr.size() - i - 1);
        }

        result = Math.abs(diagonal1 - diagonal2);

        return result;
    }

}
