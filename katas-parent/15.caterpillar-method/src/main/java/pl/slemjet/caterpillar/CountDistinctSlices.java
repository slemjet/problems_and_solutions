package pl.slemjet.caterpillar;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSlices {

    public static int solution(int M, int[] A) {

        int amount = 0;
        int LIMIT = 1_000_000_000;
        Set<Integer> usedNumbers = new HashSet<>();

        int back = 0;
        int front = 0;

        while(back < A.length && front < A.length){

            if (usedNumbers.contains(A[front])) {
                // spotted duplicate item
                // advance back and remove used items until front is unblocked
                usedNumbers.remove(A[back]);
                back++;
            } else {
                // new unique item
                // calculates additional slice (sum - already calculated slices)
                amount += (front - back + 1);
                // check for limit
                if (amount >= LIMIT) return LIMIT;
                // advance front
                usedNumbers.add(A[front]);
                front++;
            }
        }
        return amount;
    }
}
