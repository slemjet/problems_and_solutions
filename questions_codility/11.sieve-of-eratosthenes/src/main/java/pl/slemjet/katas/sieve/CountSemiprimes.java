package pl.slemjet.katas.sieve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSemiprimes {

    public static int[] solution(int N, int[] P, int[] Q){
        int[] numberOfSemiPrimes = new int[P.length];

        if(N < 1 || N > 50000)
            return numberOfSemiPrimes;

        // populate primes with sieve of Eratosthenes
        List<Integer> primes = new ArrayList<>();

        boolean[] primes_sieve = new boolean[N];
        if(N > 1)
            Arrays.fill(primes_sieve, 2, N, true);

        int i = 2;
        while(i * i < N){
            if(primes_sieve[i]){

                int k = i * i;
                while (k < N){
                    primes_sieve[k] = false;
                    k += i;
                }
            }
            i++;
        }

        for (int j = 0; j < N; j++) {
            if(primes_sieve[j]) primes.add(j);
        }

        // populate semiprimes
        boolean[] semiPrimes = new boolean[N + 1];
        for (int j = 0; j < primes.size(); j++) {
            for (int k = j; k < primes.size(); k++) {
                long semiPrimeCandidate = primes.get(j) * primes.get(k);
                if(semiPrimeCandidate > N || (int) semiPrimeCandidate < 0)
                    break;
                else
                    semiPrimes[(int) semiPrimeCandidate] = true;
            }
        }

        // populate semiPrimePrefix
        int[] semiPrimePrefix = new int[N + 1];
        for (int j = 1; j < semiPrimes.length; j++) {
            semiPrimePrefix[j] = semiPrimePrefix[j - 1];
            if (semiPrimes[j])
                semiPrimePrefix[j]++;
        }

        // Calculate results
        for (int j = 0; j < P.length; j++) {
            numberOfSemiPrimes[j] = semiPrimePrefix[Q[j]] - semiPrimePrefix[P[j] - 1];
        }

        return numberOfSemiPrimes;
    }
}
