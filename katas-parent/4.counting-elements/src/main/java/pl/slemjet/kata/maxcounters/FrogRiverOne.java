package pl.slemjet.kata.maxcounters;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static int solution(int X, int[] A) {
        // write your code in Java SE 8
        Set occupiedPositions = new HashSet();

        for (int i = 0; i < A.length; i++) {
            occupiedPositions.add(A[i]);
            if (occupiedPositions.size() == X)
                return i;
        }
        return -1;
    }

    public static int whenToJump(int X, int[] A) {
        int jumpsRemaining = X;
        int[] distanceCovered = new int[X];

        for (int i = 0; i < A.length; i++) {
            if (distanceCovered[A[i] - 1] == 0) {
                distanceCovered[A[i] - 1] = 1;
                jumpsRemaining--;
                if (jumpsRemaining == 0) {
                    return i;
                }
            }
        }

        return 0;
    }

}
