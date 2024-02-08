package us.slemjet.leetcode.easy.tasks_451_500;

public class RepeatedSubstringPattern {

    /**
     * Using the KMP Algorithm
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {

        int[] kmp = calculateKmpTable(s);

        int last = kmp[kmp.length - 1]; // Number of repeating characters
        // if ot is not 0 and string length is divisible by number of unique chars repeating
        return last != 0 && s.length() % (s.length() - last) == 0;
    }

    private static int[] calculateKmpTable(String str) {
        int[] kmp = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            int j = kmp[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = kmp[j - 1];

            if (str.charAt(i) == str.charAt(j))
                j++;

            kmp[i] = j;
        }
        return kmp;
    }

    public static boolean repeatedSubstringPatternConcatSubstr(String s) {

        // Start from divisor = 2 - check if half is a pattern and then increase the divisor
        int numPatterns = 2;

        while (numPatterns <= s.length()) {
            if (s.length() % numPatterns == 0) { // can potentially form a string out of substrings
                int subLength = s.length() / numPatterns;
                String pattern = s.substring(0, subLength); // potential pattern
                StringBuilder candidate = new StringBuilder(pattern);
                for (int i = 1; i < numPatterns; i++) {
                    candidate.append(pattern);
                }
                if (s.equals(candidate.toString()))
                    return true;
            }
            numPatterns++;
        }
        return false;
    }
}
