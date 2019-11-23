package pl.slemjet.katas.sieve;

public class CountNonDivisible {

    public static int[] solution(int[] A) {
        int[] nonDivisors = new int[A.length];

        // count occurrence of each number in array
        int[][] divisors = new int[A.length * 2 + 1][2];
        for (int i = 0; i < A.length; i++) {
            divisors[A[i]][0]++;
            divisors[A[i]][1] = -1; // set to be processed flag
        }

        // calculate amount of divisors in array
        for (int i = 0; i < A.length; i++) {
            if (divisors[A[i]][1] == -1) { // if exists in array and not processed
                divisors[A[i]][1] = 0; // reset to start accumulating divisors
                for (int j = 1; j <= Math.sqrt(A[i]); j++) {
                    if (A[i] % j == 0) { // is divisible
                        divisors[A[i]][1] += divisors[j][0]; // add divisor
                        if (A[i] != j * j) { // if not square
                            divisors[A[i]][1] += divisors[A[i] / j][0]; // add result of division
                        }
                    }
                }
            }
        }

        // calculate number of divisors
        for (int i = 0; i < A.length; i++) {
            nonDivisors[i] = A.length - divisors[A[i]][1];
        }


        return nonDivisors;
    }
}
