package us.slemjet.leetcode.hard.from_50_to_100;

/**
 * 87. Scramble String
 */
public class ScrambleString {

    /**
     * Runtime: 70.79%
     * Memory Usage: 76.01%
     */
    public boolean isScrambleDp(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        boolean[][][] isScramble = new boolean[s1.length()][s1.length()][s1.length() + 1];
        for (int k = 1; k <= s1.length(); k++) {
            // For each splitting length (k)
            for (int i = 0; i + k <= s1.length(); i++) { // Interval if s1
                for (int j = 0; j + k <= s1.length(); j++) { // Intervals of s2
                    if (k == 1) {
                        // Base scenario - single char
                        isScramble[i][j][k] = (s1.charAt(i) == s2.charAt(j));
                        continue;
                    }
                    for (int q = 1; q < k && !isScramble[i][j][k]; q++) {
                        isScramble[i][j][k] =
                                (isScramble[i][j][q] && isScramble[i + q][j + q][k - q]) ||
                                        (isScramble[i][j + k - q][q] && isScramble[i + q][j][k - q]);
                    }

                }
            }
        }

        return isScramble[0][0][s1.length()];
    }

    /**
     * TLE
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        return isScramble(0, s2.length() - 1, s1, s2);
    }

    private boolean isScramble(int leftIdx, int rightIdx, String candidate, String reference) {

        if (leftIdx == rightIdx) return reference.substring(leftIdx, rightIdx + 1).equals(candidate);

        for (int i = 1; i < candidate.length(); i++) {
            String left = candidate.substring(0, i);
            String right = candidate.substring(i);

//            boolean directMatchLeft = isScramble(leftIdx, leftIdx + i, left, reference);
//            boolean directMatchRight = isScramble(leftIdx + i + 1, rightIdx, right, reference);
//            boolean directMatch = directMatchLeft && directMatchRight;
            boolean directMatch = isScramble(leftIdx, leftIdx + i - 1, left, reference) && isScramble(leftIdx + i, rightIdx, right, reference);

//            boolean reversedMatchLeft = isScramble(rightIdx - i + 1, rightIdx, left, reference);
//            boolean reversedMatchRight = isScramble(leftIdx, rightIdx - i, right, reference);
//            boolean reversedMatch = reversedMatchRight && reversedMatchLeft;
            boolean reversedMatch = isScramble(rightIdx - i + 1, rightIdx, left, reference) && isScramble(leftIdx, rightIdx - i, right, reference);

            if (directMatch || reversedMatch) return true;
        }
        return false;
    }
}
