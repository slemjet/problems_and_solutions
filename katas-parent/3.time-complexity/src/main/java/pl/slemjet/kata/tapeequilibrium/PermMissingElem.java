package pl.slemjet.kata.tapeequilibrium;

public class PermMissingElem {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        for(int i = 0; i < A.length; i++){
            result ^= (i + 1);
            result ^= A[i];
        }

        return result ^ A.length + 1;
    }
}
