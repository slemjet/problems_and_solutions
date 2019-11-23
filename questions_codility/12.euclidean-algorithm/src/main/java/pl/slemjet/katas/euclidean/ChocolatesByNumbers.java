package pl.slemjet.katas.euclidean;

public class ChocolatesByNumbers {

    public static int solution(int N, int M) {

        // least common multiply (LCM) is the place where N and M meet, making shift between them 0
        long lcm = ((long)N * (long)M) / gcd(N, M);

        // amount of chocolates eaten is the number of steps (divisions) to LCM
        long amount = lcm / M;

        return (int) amount;
    }

    // Greatest common divisor
    private static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}

