package pl.slemjet.codility.prefixsums;

public class MinAvgTwoSlice {

    public static int solution(int[] A) {
        if (A.length < 3) return 0;

        int result = 0;

        // create prefix sums array
        int[] sums = new int[A.length];
        sums[0] = A[0];

        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }

        int p = 0;
        float minAvg = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++) {
            // A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1) -> (prefix[i] - prefix[P] + A[P]) / (i - P + 1)
            float avg = (sums[i] - sums[p] + A[p]) / (i - p + 1f);
            if (avg < minAvg) {
                minAvg = avg;
                result = p;
            }
            if (A[i] < minAvg) {
                // element is less than average - switching next possible pointer to it
                p = i;
            }
        }

        return result;
    }


    public static int findMinAvgSliceIndex(int[] A) {
        int minAvgSliceIndex = 0;
        double minAvg = Double.MAX_VALUE;

        int[] prefixSums = new int[A.length];

        prefixSums[0] = A[0];

        for (int i = 1; i <= A.length - 1; i++) {
            prefixSums[i] = prefixSums[i - 1] + A[i];

            int Q = i;
            int P = Q - 1;

            double currAvg = (prefixSums[Q] - (P > 0 ? prefixSums[P - 1] : 0)) / 2.0;
            if (currAvg < minAvg) {
                minAvg = currAvg;
                minAvgSliceIndex = P;
            }

            if (P > 1) {
                // check 3-elements slice
                currAvg = (prefixSums[Q] - prefixSums[P - 2]) / 3.0;
                if (currAvg < minAvg) {
                    minAvg = currAvg;
                    minAvgSliceIndex = P;
                }
            }
        }

        return minAvgSliceIndex;
    }
}
