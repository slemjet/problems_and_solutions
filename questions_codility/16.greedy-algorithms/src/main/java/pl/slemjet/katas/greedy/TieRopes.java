package pl.slemjet.katas.greedy;

public class TieRopes {

    public static int solution(int K, int[] A) {
        if(A == null) return 0;

        int result = 0;

        int sumLength = 0;

        for (int i = 0; i < A.length; i++) {
            if (sumLength + A[i] < K)
                sumLength += A[i];
            else {
                result++;
                sumLength = 0;
            }
        }

        return result;
    }
}
