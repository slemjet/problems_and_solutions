package pl.slemjet.katas.dominator;

public class Dominator {

    public static int solution(int[] A) {

        int size = 0;
        int candidateValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (size == 0) { // new candidate
                size++;
                candidateValue = A[i];
            } else if (candidateValue != A[i]) {
                size--;
            } else
                size++;
        }

        if (size != 0) {
            int candidateIdx = -1;
            int candidateAmount = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] == candidateValue) { // count number of candidate occurrences
                    candidateIdx = i;
                    candidateAmount++;
                }
            }

            return candidateAmount > A.length / 2 ? candidateIdx : -1;
        }else
            return -1;
    }
}
