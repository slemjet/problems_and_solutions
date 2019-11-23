package pl.slemjet.katas.fibonacci;

import java.util.Arrays;

public class FibFrog {

    public static int solution(int A[]) {
        if(A == null) return -1;

        // calculate fibonacci steps numbers
        int[] fib = fibonacciSteps(A.length);

        // prepare data for calculation - add start anf finish position to initial array
        int[] leaves = new int[A.length + 2];
        leaves[0] = leaves[leaves.length - 1] = 1;
        for (int i = 0; i < A.length; i++) {
            leaves[i + 1] = A[i];
        }

        // prepare jumps array - initially populate with max steps
        int[] jumps = new int[leaves.length];
        Arrays.fill(jumps, leaves.length);
        jumps[0] = 0;

        // iterate over initial leaves array
        for (int i = 1; i < leaves.length; i++) {
            if (leaves[i] == 1) {// leave - calculate distance

                for (int j = 0; j < fib.length; j++) { // iterate over fibonacci jumps
                    int prevPos = i - fib[j]; // previous position

                    if (prevPos >= 0) {
                        if (jumps[prevPos] + 1 < jumps[i]) {
                            jumps[i] = jumps[prevPos] + 1; // replace if number of jumps become greater
                        }
                    } else break;
                }
            }
        }

        int result = jumps[jumps.length - 1];
        return result < leaves.length ? result : -1;
    }

    private static int[] fibonacciSteps(int size) {
        size = Math.max(size, 7);
        int[] fibonacci = new int[size];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        int lastIndex = 0;

        for (int i = 2; i < size; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
            if (fibonacci[i] > size - 3) {
                lastIndex = i;
                break;
            }
        }

        return Arrays.copyOfRange(fibonacci, 1, lastIndex + 2);
    }
}
