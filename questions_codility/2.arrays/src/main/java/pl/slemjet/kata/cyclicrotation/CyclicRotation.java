package pl.slemjet.kata.cyclicrotation;

public class CyclicRotation {

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        int[] B = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int index = (i + K ) % A.length;
            B[index] = A[i];
        }

        return B;
    }
}
