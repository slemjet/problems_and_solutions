package pl.slemjet.kata.maxcounters;

public class PermCheck {
    static  final int isPermutation(int[] A){

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum ^= i + 1;
            sum ^= A[i];
        }

        return sum == 0 ? 1 :0 ;
    }
}
