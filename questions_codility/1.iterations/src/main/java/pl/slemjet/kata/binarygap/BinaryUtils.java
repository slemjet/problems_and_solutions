package pl.slemjet.kata.binarygap;

import static java.lang.Integer.toBinaryString;

public class BinaryUtils {

    public static int findLargestBinaryGap(int N){

        // return stream(trimZeroes(toBinaryString(number)).split("1")).max(comparing(gap -> gap.length())).get().length();

        int result = 0;

        String binaryString = trimZeroes(toBinaryString(N));

        String[] binaryGaps = binaryString.split("1");

        for(String binaryGap : binaryGaps){
            if(binaryGap.isEmpty()){
                continue;
            }else if(binaryGap.length() > result){
                result = binaryGap.length();
            }
        }

        return result;
    }

    private static String trimZeroes(String s) {
        int start = 0;
        int end = s.length();

        while (start < end){
            if(s.charAt(start) == '0'){
                start ++;
            }else if (s.charAt(end - 1) == '0'){
                end--;
            }else break;
        }

        return s.substring(start, end);
    }

    public static int findLargestBinaryGapNoString(int N){
        int result = 0;

        // Cut trailing zeroes
        while (N > 0 && N % 2 == 0)
            N = N / 2;

        int zeroesAccumulator = 0;
        while (N > 0){
            int currentBit = N % 2;
            N /= 2;
            if(currentBit == 0){
                zeroesAccumulator++;
            }else{
                if(zeroesAccumulator > result){
                    result = zeroesAccumulator;
                }
                zeroesAccumulator = 0;
            }
        }

        return result;
    }
}
