package pl.slemjet.katas.maxproductofthree;

import java.util.Arrays;

public class MaxProductOfThree {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 3)
            return 0;

        Arrays.sort(A);

        int positives = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int negatives = A[0] * A[1] * A[A.length - 1];
        return Math.max(positives, negatives);
    }

    /**
     * O(N) complexity
     *
     * @param inArray
     * @return
     */
    public static int getMaxProductOfThreeNoSort(int[] inArray) {

        int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        //populate minimums and maximums array
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] > max[2]) {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = inArray[i];
            } else if (inArray[i] > max[1]) {
                max[0] = max[1];
                max[1] = inArray[i];
            } else if (inArray[i] > max[0]) {
                max[0] = inArray[i];
            }

            if (inArray[i] < min[0]) {
                min[1] = min[0];
                min[0] = inArray[i];
            } else if (inArray[i] < min[1]) {
                min[1] = inArray[i];
            }
        }

        int maxPositives = max[0] * max[1] * max[2];
        int maxTwoNegatives = min[0] * min[1] * max[2];

        return Math.max(maxPositives, maxTwoNegatives);
    }
}
