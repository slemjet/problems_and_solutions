package pl.slemjet.katas.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinAbsSum {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int[] abs = Arrays.copyOf(A, A.length);

        // Get the occurrence of each number
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            abs[i] = Math.abs(A[i]);
            max = Math.max(max, abs[i]);
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < abs.length; i++) {
            count[abs[i]]++;
        }

        // populate sums array dp[i] == -1 cannot obtain sum dp[i] >= we can obtain sum
        int sum = IntStream.of(abs).sum();
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < max + 1; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < sum; j++) {
                    if (dp[j] >= 0)
                        dp[j] = count[i];
                    else if (j >= i && dp[j - i] > 0)
                        dp[j] = dp[j - i] - 1;
                }
            }
        }

        result = sum;
        for (int i = 0; i < Math.floor(sum / 2.0) + 1; i++) {
            if (dp[i] >= 0)
                result = Math.min(result, sum - 2 * i);
        }
        return result;
    }
}
