package pl.slemjet.katas.maxproductofthree;

import java.util.Arrays;

public class Triangle {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 3)
            return 0;

        Arrays.sort(A);

        for (int i = 2; i < A.length; i++) {
            // we subtract to handle int overflow
            // 2 other conditions are auto satisfied by sorting (bigger > lesser)
            if (A[i - 2] > A[i] - A[i - 1])
                return 1;
        }

        return 0;
    }
}
