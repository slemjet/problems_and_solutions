package pl.slemjet.katas.greedy;

public class MaxNonoverlappingSegments {

    public static int solution(int[] A, int[] B){
        if(A == null || B == null) return 0;
        if(A.length == 0 || B.length == 0) return 0;

        int result = 1;

        int prevB = B[0];

        for (int i = 1; i < A.length; i++) {

            if(A[i] > prevB){ // Fits the requirement -> greedy take suitable value
                // new segment starts
                result++;
                prevB = B[i];
            }
        }

        return result;
    }
}
