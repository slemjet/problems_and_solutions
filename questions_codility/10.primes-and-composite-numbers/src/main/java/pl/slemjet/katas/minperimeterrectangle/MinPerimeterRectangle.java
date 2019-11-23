package pl.slemjet.katas.minperimeterrectangle;

public class MinPerimeterRectangle {

    public static int solution(int N){
        int perimeter = Integer.MAX_VALUE;

        int i = 1;

        while (i * i <= N) {
            if (N % i == 0 ){
                int cur = 2 * (i + N / i);
                if(cur < perimeter)
                    perimeter = cur;
            }
            i++;
        }

        return perimeter;
    }
}
