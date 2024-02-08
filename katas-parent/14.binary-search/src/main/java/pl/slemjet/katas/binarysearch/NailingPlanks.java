package pl.slemjet.katas.binarysearch;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class NailingPlanks {

    public static int solution(int[] A, int[] B, int[] C) {

        List<SimpleEntry<Integer, Integer>> positions = new ArrayList<>();

        // Create sorted array of nails, holding also reference to initial nails positions
        for (int i = 0; i < C.length; i++) {
            SimpleEntry<Integer, Integer> entry = new SimpleEntry<>(C[i], i);
            positions.add(entry);
        }

        // sort in ascending order
        positions.sort((o1, o2) -> {
            if(o1.getKey().equals(o2.getKey())) return o1.getValue().compareTo(o2.getValue());

            return o1.getKey().compareTo(o2.getKey());
        });

        int maxNailPosition = 0; // contains maximum used nail position
        for (int i = 0; i < A.length; i++) {
            maxNailPosition = getNailPosition(A[i], B[i], positions, maxNailPosition);
            if(maxNailPosition == - 1) return -1;
        }

        return maxNailPosition + 1; // +1 to convert position to amount
    }

    private static int getNailPosition(int plankStart, int plankEnd, List<SimpleEntry<Integer, Integer>> nails, int maxNailPosition) {

        int nailIdx = -1;
        int min = 0;
        int max = nails.size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            SimpleEntry<Integer, Integer> nailEntry = nails.get(mid);
            int nailPosition = nailEntry.getKey();

            if (nailPosition < plankStart) {
                min = mid + 1;
            } else if (nailPosition > plankEnd) {
                max = mid - 1;
            } else {
                max = mid - 1;
                nailIdx = mid;
            }
        }

        if(nailIdx == -1) return -1;

        int minOriginalIdx = nails.get(nailIdx).getValue();
        // Try to optimize resultIdx for smaller resultIdx
        // Ascending
        for (int i = nailIdx; i < nails.size(); i++) {
            if(nails.get(i).getKey() > plankEnd) // check if reached end of suitable nails block
                break;

            Integer currentNailPosition = nails.get(i).getValue();
            minOriginalIdx = Math.min(minOriginalIdx, currentNailPosition); // override with optimal solution

            if(minOriginalIdx <= maxNailPosition)
                return maxNailPosition; // Found result already smaller than current maximum -> no need to continue
        }

        return minOriginalIdx;
    }
}
