package pl.slemjet.katas.euclidean;

public class CommonPrimeDivisors {

    public static int solution(int[] A, int[] B){
        int primeDivisors = 0;

        for (int i = 0; i < A.length; i++) {
            if(hasCommonPrimeDivisors(A[i], B[i]))
                primeDivisors++;
        }

        return primeDivisors;
    }

    private static boolean hasCommonPrimeDivisors(int a, int b) {
        int gcd = gcd(a, b);
        return isReducedToOne(a, gcd) && isReducedToOne(b, gcd);
    }

    private static boolean isReducedToOne(int x, int gcd) {
        // check if iteratively can be reduced to 1
        int primeX = x / gcd;
        while (primeX != 1){// if can - contains prime divisors
            gcd = gcd(primeX, gcd);
            if(gcd == 1)// break af fails the condition
                return false;
            primeX /= gcd;
        }
        return true;
    }

    private static int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        else return gcd(b, a % b);
    }
}
