package pl.slemjet.katas.maxproductofthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfDiscIntersections {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        // create arrays containing indices of all begin and end of the discs
        double[] start = new double[A.length];
        double[] end = new double[A.length];

        for (int i = 0; i < A.length; i++) {
            start[i] = Integer.MIN_VALUE + i > A[i] ? Integer.MIN_VALUE : i - A[i];
            end[i] = Integer.MAX_VALUE - i < A[i] ? Integer.MAX_VALUE : i + A[i];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        // we iterate over arrays and add intersections when new disc enters
        int startIndex = 0;
        int endIndex = -1;

        int activeDiscs = 1;

        while (startIndex < start.length - 1) {
            if (start[startIndex + 1] <= end[endIndex + 1]) { // new disc event
                startIndex++;
                activeDiscs++;
                result += activeDiscs - 1;
                if (result > 10000000)
                    return -1;
            } else { // disc leaves event
                endIndex++;
                activeDiscs--;
            }
        }

        return result;
    }


    public static int getNumberOfDiscIntersections(int[] A) {

        if (A == null || A.length <= 1) return 0;

        int intersections = 0;
        int size = A.length;

        List<Long> begin = new ArrayList<>();
        List<Long> end = new ArrayList<>();

        for (long i = 0; i < size; i++) {
            begin.add(i - A[(int) i]);
            end.add(i + A[(int) i]);
        }

        Collections.sort(begin);
        Collections.sort(end);

        long first = begin.get(0);
        long last = end.get(size - 1);

        int activeDiscs = 0;
        long lastDiscAddedIdx = 0;
        long lastDiscRemovedIdx = 0;
        long nextEventIdx = 0;


        for (long i = first; i < last; ) {
            while (lastDiscAddedIdx < size && begin.get((int) lastDiscAddedIdx) == i) {
                activeDiscs++;
                intersections += activeDiscs - 1;
                if (intersections > 10000000) return -1;
                lastDiscAddedIdx++;
            }

            if (lastDiscAddedIdx == size) return intersections;

            while (lastDiscRemovedIdx < size && end.get((int) lastDiscRemovedIdx) == i) {
                activeDiscs--;
                lastDiscRemovedIdx++;
            }

            if (lastDiscAddedIdx >= size || lastDiscRemovedIdx >= size)
                return intersections;

            nextEventIdx = begin.get((int) lastDiscAddedIdx) <= end.get((int) lastDiscRemovedIdx) ?
                    begin.get((int) lastDiscAddedIdx) : end.get((int) lastDiscRemovedIdx);

            i = nextEventIdx;

        }

        return intersections;
    }
}
