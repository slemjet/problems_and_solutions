package us.slemjet.hackerrank.questions.warmup;

import java.util.List;

/**
 *
 */
public class MiniMaxSum {

    /**
     * Time:    O(n)
     * Space:   O(1)
     */
    public void miniMaxSum(List<Integer> arr) {
        // Write your code here

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;

        for (Integer val : arr) {
            sum += val;
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}
