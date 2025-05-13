package us.slemjet.hackerrank.questions;

import java.util.List;

/**
 * Apple and Orange
 */
public class AppleAndOrange {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here

        int applesToCount = countFruits(s, t, a, apples);
        System.out.println(applesToCount);

        int orangesCount = countFruits(s, t, b, oranges);
        System.out.println(orangesCount);

    }

    private static int countFruits(int s, int t, int a, List<Integer> apples) {
        int applesToCount = 0;
        for (Integer apple : apples) {
            apple += a;
            if (apple >= s && apple <= t)
                applesToCount++;
        }
        return applesToCount;
    }
}
