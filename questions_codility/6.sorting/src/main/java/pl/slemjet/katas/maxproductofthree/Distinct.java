package pl.slemjet.katas.maxproductofthree;

import java.util.Arrays;

public class Distinct {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0)
            return 0;

        int result = 1;
        Arrays.sort(A);

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1])
                result++;
        }

        return result;
    }


    public static int numDistinctValues(int[] inArray) {
        int numOfDistinct = 0;

        int[] pos = new int[1000001];
        int[] neg = new int[1000001];

        for (int val : inArray) {
            if (val >= 0) {
                if (pos[val] == 0) {
                    numOfDistinct++;
                }
                ++pos[val];
            } else {
                if (neg[-val] == 0) {
                    numOfDistinct++;
                }
                ++neg[-val];
            }
        }

        return numOfDistinct;
    }


    public static int numDistinctValuesSort(int[] inArray) {
        int numOfDistinct = inArray.length == 0 ? 0 : 1;

        Arrays.sort(inArray);

        for (int i = 1; i < inArray.length; i++) {
            if (inArray[i - 1] != inArray[i]) ++numOfDistinct;
        }

        return numOfDistinct;
    }
}
