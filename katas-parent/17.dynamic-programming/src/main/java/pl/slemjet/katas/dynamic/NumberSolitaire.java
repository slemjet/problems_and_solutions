package pl.slemjet.katas.dynamic;

public class NumberSolitaire {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        // populate maximum possible values up to each index
        int[] sumTo = new int[A.length];
        sumTo[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int die = 1; die <= 6 && i - die >= 0; die++) {
                // go back up to 6 dice values and get maximum possible value for i-th position
                max = Math.max(sumTo[i - die] + A[i], max);
            }
            sumTo[i] = max;
        }
        return sumTo[sumTo.length - 1];
    }
}
