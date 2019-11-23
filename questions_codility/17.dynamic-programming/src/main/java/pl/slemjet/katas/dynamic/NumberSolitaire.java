package pl.slemjet.katas.dynamic;

public class NumberSolitaire {

    public static int solution (int[] A){

        int[] maxTo = new int[A.length];

        // set starting point
        maxTo[0] = A[0];

        for (int currElem = 1; currElem < A.length; currElem++) {
            // maximum value to be found and set

            int max = Integer.MIN_VALUE;
            
            // count max within dies 1-6
            for (int die = 1; die <= 6; die++) {

                if(currElem - die >= 0){ // exclude negative indexes

                    // get max between sum of current position and previous possible die and current max
                    max = Math.max(maxTo[currElem - die] + A[currElem], max);
                }

            }
            maxTo[currElem] = max;
        }

        return maxTo[maxTo.length - 1];
    }
}
