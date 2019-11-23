package pl.slemjet.katas.minperimeterrectangle;


import java.util.ArrayList;
import java.util.List;

public class Peaks {

    public static int solution(int [] A){
        int[] peaksUntilPos = new int[A.length];

        // write amount of peaks, existing until position
        for (int i = 1; i < A.length - 1 ; i++) {
            peaksUntilPos[i] = peaksUntilPos[i - 1];
            if(A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaksUntilPos[i]++;
            }
        }

        if(A.length < 3 || peaksUntilPos[A.length - 2] == 0) {
            return 0;
        }

        int maxGroups = 0;
        int maxRange = (int) Math.ceil(Math.sqrt(A.length));

        for (int candidateSize = 1; candidateSize < maxRange; candidateSize++) {
            if(A.length % candidateSize == 0) { // if array is divisible by blocks
                int blockSize = candidateSize;
                int blocks = A.length / blockSize;

                if(peaksUntilPos[0] < peaksUntilPos[blockSize - 1]){ // check first block
                    // check remaining blocks
                    for (int currentBlock = blockSize; currentBlock < A.length; currentBlock+=blockSize) {
                        if(peaksUntilPos[currentBlock - 1] == peaksUntilPos[currentBlock + blockSize - 1])
                            break; // no peak in nex block - reject this plan
                    }
                }else
                    maxGroups = blocks;
            }

            if(candidateSize * candidateSize == A.length) continue;

        }

        return maxGroups;
    }

    public static int getMaxGroupsV2(int [] A){

        // finding all peaks indices
        List<Integer> peaks = new ArrayList<>();
        for(int i = 1; i < A.length-1; i++){
            if(A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
        }

        for (int candidateSize = 1; candidateSize <= A.length; candidateSize++) {
            if(A.length % candidateSize != 0) continue; // non-divisible

            int foundGroup = 0;
            int maxGroups = A.length / candidateSize;
            boolean ok = true;

            // check every group for peak
            for(int peakIdx : peaks){
                if(peakIdx / candidateSize > foundGroup){
                    ok = false;
                    break;
                }
                if(peakIdx / candidateSize == foundGroup)
                    foundGroup++;
            }

            if(foundGroup != maxGroups)
                ok = false;
            if(ok) return maxGroups;
        }

        return 0;
    }
}
