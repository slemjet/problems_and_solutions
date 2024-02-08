package pl.slemjet.katas.nesting;

import java.util.Stack;

public class Fish {

    /**
     * @param A - fish size
     * @param B - fish direction
     * @return
     */
    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int result = 0;

        Stack<Integer> upstreamFish = new Stack<>();

        for (int i = 0; i < B.length; i++) {
            result++;

            if (B[i] == 1)  // another upstream fish
                upstreamFish.push(A[i]);
            else {
                while (!upstreamFish.isEmpty()) {
                    if (upstreamFish.peek() < A[i]) {
                        upstreamFish.pop(); // upstream fish from stack is eaten
                        result--;
                    } else {
                        result--; // downstream fish is eaten
                        break;
                    }
                }
            }
        }
        return result;
    }
}
