package pl.slemjet.codility.prefixsums;

public class CountDiv {

    public static int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int result = B/K - A/K; // how many values between
        if(A % K == 0) // add additional
            result++;

        return result;
    }
}
