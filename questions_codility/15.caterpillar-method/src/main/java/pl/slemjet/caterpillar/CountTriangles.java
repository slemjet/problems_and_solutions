package pl.slemjet.caterpillar;

import java.util.Arrays;

public class CountTriangles {

    public static int solution(int[] A){
        int result = 0;

        Arrays.sort(A);

        for (int x = 0; x < A.length - 2; x++) {
            int z = x + 2;
            for (int y = x + 1; y < A.length - 1; y++) {
                while (z < A.length && A[x] + A[y] > A[z]){ // As array is sorted we only need to check one condition
                    z++;
                    result += z - y - 1; // -1 for excluding the rightmost element
                }
            }
        }
        return result;
    }
}
