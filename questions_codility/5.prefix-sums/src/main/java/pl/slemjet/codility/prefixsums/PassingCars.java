package pl.slemjet.codility.prefixsums;

public class PassingCars {

    /**
     * 0 (->) East, 1 (<-) west
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int east = 0;
        int counter = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                east++;
            else {
                counter += east;
                if(counter > 1000000000)
                    return -1;
            }
        }
        return counter;
    }
}
