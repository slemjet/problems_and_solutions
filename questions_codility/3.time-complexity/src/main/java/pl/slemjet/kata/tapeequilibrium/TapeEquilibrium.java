package pl.slemjet.kata.tapeequilibrium;

import static java.lang.Math.abs;

public class TapeEquilibrium {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int sum1 = A[0];
        int sum2 = A[1];

        for(int i = 2; i < A.length; i++)
            sum2 += A[i];
        int result = Math.abs(sum1 - sum2);

        for(int i = 2; i < A.length; i++){
            sum1 += A[i - 1];
            sum2 -= A[i - 1];
            result = Math.min(result, Math.abs(sum1 - sum2));
        }
        return result;
    }

    public static int minSplitDifference(int [] A){

        int sum1 = A[0];
        int sum2 = sumAll(A) - sum1;
        int result = abs(sum1 - sum2);
        for (int i = 2; i < A.length; i++) {
            sum1 += A[i - 1];
            sum2 -= A[i - 1];
            int diff = abs(sum1 - sum2);
            if(result > diff) result = diff;
        }

        return result;
    }

    private static int sumAll(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
}
