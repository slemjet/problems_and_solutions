package pl.slemjet.caterpillar;

import java.util.Arrays;

public class MinAbsSumOfTwo {

    public static int solution(int[] A){
        Arrays.sort(A); // Sort in ascending order

        if(A[0] >= 0) return A[0] + A[0]; // All >=0
        if(A[A.length - 1] <= 0) return Math.abs(A[A.length - 1] + A[A.length - 1]); // All <=0

        int head = 0;
        int tail = A.length - 1;

        int result = Math.abs(A[head] + A[tail]);

        while (head <= tail){

            int temp = Math.abs(A[head] + A[tail]);

            if (temp <  result) result = temp;

            // advance from 2 sides until points meet
            if(Math.abs(A[head] + A[tail - 1]) <= temp)
                tail--;
            else if (Math.abs(A[head + 1] + A[tail]) <= temp)
                head++;
            else {
                head++;
                tail--;
            }
        }

       return result;
    }
}
