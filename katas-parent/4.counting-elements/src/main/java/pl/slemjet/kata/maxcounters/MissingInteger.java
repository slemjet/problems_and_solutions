package pl.slemjet.kata.maxcounters;

import java.util.Arrays;

public class MissingInteger {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int nextValue = 1;

        for (int i = 0; i < A.length; i++) {
            if(A[i] == nextValue)
                nextValue++;
            if(A[i] > nextValue)
                return nextValue;
        }

        return nextValue;
    }
}
