package pl.slemjet.katas.dynamic;

public class MinAbsSum {

    public static int solution(int[] A){
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            result = Math.abs(Math.abs(result) - Math.abs(A[i]));
        }

        return result;
    }
}
