package us.slemjet.leetcode.hard.tasks_2851_2900;

import java.util.ArrayList;
import java.util.List;

/**
 * 2851. String Transformation
 */
public class StringTransformation {

    /**
     *  Time: O(n + logk)   ->  74.44%
     *  Space:O(n)          ->  28.57%
     */
    public int numberOfWays(String s, String t, long k) {

        int modulo = (int) (Math.pow(10, 9) + 7);

        String str = s + s.substring(0, s.length() - 1);
        List<Integer> matchingIndices = kmp(str, t); // Exclude n - 1

        // Functions to calculate combinations based on index - have no idea how it works
        long[] func = {0, 0};
        func[1] = (pow(s.length() - 1, k, modulo) + (k % 2 * 2 - 1) + modulo) % modulo * pow(s.length(), modulo - 2, modulo) % modulo;
        func[0] = (func[1] - (k % 2 * 2 - 1) + modulo) % modulo;

        int result = 0;
        for (int idx : matchingIndices) {
            if (idx == 0) {
                result = (result + (int) func[0]) % modulo;
            } else {
                result = (result + (int) func[1]) % modulo;
            }
        }

        return result;
    }

    public long pow(long base, long exp, int modulo) {
        long result = 0;
        if (exp == 0) result = 1;
        else if ((exp & 1) == 0) result = pow(base * base % modulo, exp >> 1, modulo);
        else result = base * pow(base * base % modulo, exp >> 1, modulo) % modulo;
        return result;
    }

    /**
     * KMP algorithm
     * Finds indices at which pattern matches
     */
    List<Integer> kmp(String str, String pat) {

        List<Integer> result = new ArrayList<>();

        // Construct LPS
        int[] lps = new int[pat.length()];
        int prevLps = 0;
        int idx = 1; // lps[0] is always 0
        while (idx < pat.length()) {
            if (pat.charAt(idx) == pat.charAt(prevLps)) {
                // If prefix last matches suffix first
                lps[idx] = prevLps + 1;
                prevLps++;
                idx++;
            } else if (prevLps == 0) { // Have to start from scratch
                lps[idx] = 0;
                idx++;
            } else {
                prevLps = lps[prevLps - 1]; // Backtrack to check previous LPS
            }
        }

        // Populate indices where pattern matches
        int i = 0; // string index
        int j = 0; // pattern index

        while (i < str.length()) {
            if (str.charAt(i) == pat.charAt(j)) {
                // Chars match - increment bot indices
                i++;
                j++;
            } else if (j == 0) {
                i++; // Start matching next char from scratch
            } else {
                j = lps[j - 1]; // Try with previous lps
            }

            if (j == pat.length()) {
                // Whole pattern match - add index of match start
                result.add(i - pat.length());
                j = lps[j - 1];
            }
        }

        return result;
    }
}
