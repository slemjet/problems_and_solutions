package pl.slemjet.caterpillar;

public class AbsDistinct {

    public static int solution(int[] A) {
        // Easy way using java data structures
        // return (int) Arrays.stream(A).map(Math::abs).distinct().count();

        // But we need to go with a Caterpillar / 2 points
        int result = 1;
        int head = 0;
        int tail = A.length - 1;

        int currentMax = Math.max(Math.abs(A[head]), Math.abs(A[tail]));

        // counter Integer.MIN value as still negative after abs
        if(A[head] == Integer.MIN_VALUE)
            currentMax = Math.abs(A[head]);

        while (head <= tail) {

            // process heads
            int currHead = Math.abs(A[head]);
            if(currHead == currentMax){
                head++;
                continue; // skip for same value
            }

            // process tails
            int currTail = Math.abs(A[tail]);
            if(currTail == currentMax){
                tail--;
                continue; // skip for same value
            }

            // check which new max value to pick
            if(currHead >= currTail){
                currentMax = currHead; // get new maximum from head
                head++;
            }else{
                currentMax = currTail; // get new maximum from tail
                tail--;
            }

            // value processed continue for a new one
            result++;
        }
        return result;
    }
}
