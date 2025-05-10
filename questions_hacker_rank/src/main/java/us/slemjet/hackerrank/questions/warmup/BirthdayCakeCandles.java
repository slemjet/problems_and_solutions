package us.slemjet.hackerrank.questions.warmup;

import java.util.List;

/**
 *
 */
public class BirthdayCakeCandles {

    /**
     *  Time:   O(n)
     *  Space:  O(1)
     */
    public int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here

        int max = Integer.MIN_VALUE;
        int result = 0;

        for (Integer candle : candles) {
            if (candle > max) {
                result = 1;
                max = candle;
            } else if (candle == max) {
                result++;
            }
        }

        return result;
    }
}
