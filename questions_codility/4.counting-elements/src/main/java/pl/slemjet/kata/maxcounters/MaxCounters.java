package pl.slemjet.kata.maxcounters;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8

        int[] result = new int[N];
        int currMax = 0;
        int valueToFill = 0;

        for (int val : A) {
            if (val == N + 1) {
                valueToFill = currMax;
            } else {
                int newValue = Math.max(result[val - 1], valueToFill);
                result[val - 1] = ++newValue;
                currMax = Math.max(currMax, newValue);
            }
        }
        for (int i = 0; i < result.length; i++)
            result[i] = Math.max(result[i], valueToFill);
        return result;
    }

    public static int[] executeMaxIntegers(int N, int[] A) {
        int[] result = new int[N];

        int max = 0;
        int lastLocalMax = 0;

        for (int op : A) {
            if (op < N) {
                int val = result[op - 1];

                val = val < lastLocalMax ? lastLocalMax + 1 : val + 1;

                result[op - 1] = val;

                max = max < val ? val : max;
            } else {
                lastLocalMax = max;
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] < lastLocalMax) {
                result[i] = lastLocalMax;
            }
        }

        return result;
    }
}
