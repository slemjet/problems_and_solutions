package pl.slemjet.katas.dominator;

public class EquiLeader {

    public static int solution(int[] A) {

        if (A.length < 2) return 0;

        int size = 0;
        int candidateValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (size == 0) {
                size++;
                candidateValue = A[i];
            } else if (candidateValue != A[i]) {
                size--;
            } else
                size++;
        }

        if (size != 0) {
            int candidateAmount = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] == candidateValue) {
                    candidateAmount++;
                }
            }

            if (candidateAmount > A.length / 2) {
                // there is a leader
                int leaderValue = candidateValue;

                int equiLeadersAmount = 0;
                int countLeft = 0;
                int countRight = candidateAmount;

                for (int i = 0; i < A.length; i++) {
                    if (A[i] == leaderValue) {
                        countLeft++;
                        countRight--;
                    }

                    // check if dominant for both subsequences
                    if( countLeft > (i + 1) / 2 &&
                            countRight > (A.length - i - 1) / 2){
                        equiLeadersAmount++;
                    }
                }

                return equiLeadersAmount;
            }
        }
        return 0;
    }
}
