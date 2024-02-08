package pl.slemjet.katas.minperimeterrectangle;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

public class Flags {

    public static int solution(int[] A){

        if(A.length < 3) return 0;

        int[] nextPeak = new int[A.length];
        nextPeak[A.length - 1] = -1;
        int maxFlags = 0;
        int firstPeakIdx = - 1;

        for (int i = nextPeak.length - 2; i > 0; i--) {
            if(A[i - 1] < A[i] && A[i] > A[i + 1]){
                // peak detected!
                maxFlags++;
                firstPeakIdx = i;
                nextPeak[i] = i;
            }else
                nextPeak[i] = nextPeak[i + 1];
        }

        // no or 1 peak found
        if(maxFlags < 2) return maxFlags;

        maxFlags = 0;
        // no sense to continue with step bigger than half of array length
        int maxStep = (int) ceil(sqrt(A.length));

        // check for all steps (number of flags) from 1 to max
        for (int step = maxStep; step > 0 ; step--) {
            // setting position to first peak location, using one flag
            int flagsUsed = 1;
            int flagsRemaining = step - 1;
            int currentPosition = firstPeakIdx;

            while (flagsRemaining > 0){
                if(currentPosition + step > A.length - 1) break; // reached end

                currentPosition = nextPeak[currentPosition + step];
                if(currentPosition == -1) break; // no more peaks

                flagsUsed ++;
                flagsRemaining--;
            }

            maxFlags = Math.max(maxFlags, flagsUsed);
        }

        return maxFlags;
    }
}
