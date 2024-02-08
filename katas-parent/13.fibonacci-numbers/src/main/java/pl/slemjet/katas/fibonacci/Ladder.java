package pl.slemjet.katas.fibonacci;

import java.util.Arrays;

public class Ladder {

    public static int[] solution(int[] A, int[] B) {
        int[] result = new int[A.length];

        // the number of variants if fibonacci number as it can be 1 or 2 - numbers from Fibonacci sequence

        // populate fibonacci from 1 to biggest value from A
        int fib[] = fibonacci(max(A));

        // populate pows for modulo operation
        int[] pow = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            pow[i] = 1 << B[i]; // optimization as works faster than Math.pow(2, x)
        }

        // for each number of variants calculate modulo
        for (int i = 0; i < result.length; i++) {
            result[i] = fib[A[i] - 1] % pow[i];
        }

        return result;
    }

    private static int[] fibonacci(int length) {
        int[] fibonacci = new int[length];
        int a = 0;
        int b = 1;

        int maxPow = (int) Math.pow(2, 30); // max pow possible - from the task
        for (int i = 0; i < length; i++) {
            int x = (a + b) % maxPow; // need to consider max pow
            fibonacci[i] = x;
            a = b;
            b = x;
        }

        return fibonacci;
    }

    private static int max(int[] A) {
        int[] copy = Arrays.copyOf(A, A.length);
        Arrays.sort(copy);
        return copy[copy.length - 1];
    }
}
