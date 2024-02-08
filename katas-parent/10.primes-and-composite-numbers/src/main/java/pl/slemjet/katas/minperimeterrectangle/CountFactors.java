package pl.slemjet.katas.minperimeterrectangle;

public class CountFactors {

    public static int solution(int N) {
        if (N == 1) return 1;

        int factors = 2;
        long i = 2;

        while (i * i < N) {
            if (N % i == 0)
                factors += 2;
            i++;
        }

        if (N == (i * i)) {
            factors++;
        }

        return factors;
    }
}
