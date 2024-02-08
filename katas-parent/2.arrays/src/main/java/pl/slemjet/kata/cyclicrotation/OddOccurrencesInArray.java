package pl.slemjet.kata.cyclicrotation;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public static int findUnpaired(int[] a){

        int result = 0;

        for (int elem : a) {
            // Using xor eliminates duplicates
            result = result ^ elem;
        }

        return result;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        Set occuredValues = new HashSet();

        for(int value: A){
            if(occuredValues.contains(value)){
                occuredValues.remove(value);
            }else
                occuredValues.add(value);
        }

        return occuredValues.isEmpty() ? 0 : (int) occuredValues.stream().findFirst().get();
    }
}
