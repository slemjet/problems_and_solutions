package com.slemjet.questions.other;

import java.util.Arrays;

/**
 * Manacher algoithm
 * given string S
 * generate S' by inserting a bogus character ('|') between each character in S (including outer boundaries)
 * Create array P to store the lengths of the palindrome for each center point in S (initially all 0s)
 * (S'.length = P.length = 2*S.length+1)
 * track the following pointers (referencing indices in P and S'):
 * R -> the next element to be examined (initially 0)
 * C -> the largest/left-most palindrome whose right boundary is R-1 (initially 0)
 * i -> the next palindrome to be calculated (initially 1)
 * L -> character candidate for comparing with R.  Computed implicitly as:
 * L = i - (R - i)
 * i' -> the palindrome mirroring i from C.  Computed implicitly as:
 * i' = C - (i - C)
 * <p>
 * while R < P.length:
 * If i is within the palindrome at C (Cases 1 and 2):
 * Set P[i] = P[i'] (else P[i] is set to 0)
 * <p>
 * Expand the palindrome at i (primarily Cases 2 and 3; can be skipped in Case 1, though we have already shown that S'[R] != S'[L] because otherwise the palindrome at i' would have extended at least to the left edge of the palindrome at C):
 * while S'[R] == S'[L]:
 * increment P[i]
 * increment R
 * <p>
 * If the palindrome at i extends past the palindrome at C:
 * Update C = i
 * <p>
 * increment i
 * <p>
 * return max(P)
 */
public class LongestPalindrome {

    public static String solution(String s) {
        if (s == null || s.length() == 0)
            return "";

        char[] s2 = addBoundaries(s.toCharArray());
        int[] p = new int[s2.length];
        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same
        for (int i = 1; i < s2.length; i++) {
            if (i > r) {
                p[i] = 0;
                m = i - 1;
                n = i + 1;
            } else {
                int i2 = c * 2 - i;
                if (p[i2] < (r - i)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below.
                } else {
                    p[i] = r - i;
                    n = r + 1;
                    m = i * 2 - n;
                }
            }
            while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
                p[i]++;
                m--;
                n++;
            }
            if ((i + p[i]) > r) {
                c = i;
                r = i + p[i];
            }
        }
        int len = 0;
        c = 0;
        for (int i = 1; i < s2.length; i++) {
            if (len < p[i]) {
                len = p[i];
                c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
        return String.valueOf(removeBoundaries(ss));
    }

    private static char[] addBoundaries(char[] cs) {
        if (cs == null || cs.length == 0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length * 2 + 1];
        for (int i = 0; i < (cs2.length - 1); i = i + 2) {
            cs2[i] = '|';
            cs2[i + 1] = cs[i / 2];
        }
        cs2[cs2.length - 1] = '|';
        return cs2;
    }

    private static char[] removeBoundaries(char[] cs) {
        if (cs == null || cs.length < 3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length - 1) / 2];
        for (int i = 0; i < cs2.length; i++) {
            cs2[i] = cs[i * 2 + 1];
        }
        return cs2;
    }
}
