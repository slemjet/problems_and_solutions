package us.slemjet.hackerrank.questions.warmup;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class PlusMinus {

    /**
     * Time:    O(n)
     * Space:   O(1)
     */
    public void plusMinus(List<Integer> arr) {
        // Write your code here

        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (Integer val : arr) {
            if (val > 0)
                positiveCount++;
            else if (val < 0)
                negativeCount++;
            else
                zeroCount++;
        }

        BigDecimal positiveVal = BigDecimal.valueOf(positiveCount).divide(BigDecimal.valueOf(arr.size()), 6, BigDecimal.ROUND_HALF_UP);
        BigDecimal negativeVal = BigDecimal.valueOf(negativeCount).divide(BigDecimal.valueOf(arr.size()), 6, BigDecimal.ROUND_HALF_UP);
        BigDecimal zeroVal = BigDecimal.valueOf(zeroCount).divide(BigDecimal.valueOf(arr.size()), 6, BigDecimal.ROUND_HALF_UP);

        System.out.println(positiveVal);
        System.out.println(negativeVal);
        System.out.println(zeroVal);

    }
}
