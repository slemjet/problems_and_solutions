package pl.slemjet.katas.binarysearch;

import static java.util.Arrays.stream;

public class MinMaxDivision {

    public static int solution(int K, int M, int[] A) {
        int result = 0;
        int lowerBound = max(A); // minimum sum - is the value of maximum element
        int upperBound = sum(A); // maximum sum - is the sum of all elements

        if (K == 1) return upperBound; // one block only
        if (K > A.length) return lowerBound; // each element is a block

        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;

            // calculate how many blocks can be made with provided sum
            int blocksAmount = calculateBlocks(A, mid);

            if (blocksAmount <= K) {
                // still some blocks remaining -> try to increase them -> decrease higher bound
                result = mid; // solution found
                upperBound = mid - 1;
            } else {
                // too many blocks -> try to decrease them -> increase lower bound
                lowerBound = mid + 1;
            }
        }

        return result;
    }

    private static int calculateBlocks(int[] array, int sum) {
        int blocks = 1;
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (currentSum + array[i] > sum) {
                // current block reached sum limit -> starting new
                blocks++;
                currentSum = array[i];
            } else {
                // still can add element to block
                currentSum += array[i];
            }
        }
        return blocks;
    }

    private static int sum(int[] array) {
        return stream(array).sum();
    }


    public static int max(int[] array) {
        return stream(array).max().getAsInt();
    }
}


