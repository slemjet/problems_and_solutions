package pattern_matching;

import java.util.ArrayList;
import java.util.List;

public class KMPStringMatch {

    /**
     * KMP algorithm
     * Finds indices at which pattern matches
     */
    public static List<Integer> findMatches(String str, String pat) {

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
