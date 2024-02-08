package pl.slemjet.codility.prefixsums;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {

    public static int[] solution(String S, int[] P, int[] Q) {
        Map<Character, Integer> bindings = new HashMap<>();
        bindings.put('A', 1);
        bindings.put('C', 2);
        bindings.put('G', 3);
        bindings.put('T', 4);

        // prepare auxiliary map, containing amount of each gene up to current position;
        int[] genA = new int[S.length() + 1];
        int[] genC = new int[S.length() + 1];
        int[] genG = new int[S.length() + 1];
        int[] genT = new int[S.length() + 1];

        // starting from 1 and adding extra 0 element to be able to track first element changes correctly
        for (int i = 1; i <= S.length(); i++) {
            genA[i] = genA[i - 1];
            genC[i] = genC[i - 1];
            genG[i] = genG[i - 1];
            genT[i] = genT[i - 1];

            switch (S.charAt(i - 1)) {
                case 'A':
                    genA[i]++;
                    break;
                case 'C':
                    genC[i]++;
                    break;
                case 'G':
                    genG[i]++;
                    break;
                case 'T':
                    genT[i]++;
                    break;
            }
        }

        int[] results = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;
            if (genA[end] != genA[start])
                results[i] = bindings.get('A');
            else if (genC[end] != genC[start])
                results[i] = bindings.get('C');
            else if (genG[end] != genG[start])
                results[i] = bindings.get('G');
            else if (genT[end] != genT[start])
                results[i] = bindings.get('T');
        }
        return results;
    }
}
