package us.slemjet.leetcode.easy.tasks_351_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 392. Is Subsequence
 */
public class IsSubsequence {

    /**
     * Use 2 pointers to go over the arrays and check if there is a match for each subsequent character
     * <p>
     * Runtime: 84.61%
     * Memory Usage: 5.14%
     */
    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null) return false;

        int idxS = 0;
        int idxT = 0;

        while (idxS < s.length() && idxT < t.length()) {
            while (idxT < t.length() && s.charAt(idxS) != t.charAt(idxT)) {
                idxT++;
            }
            if (idxT < t.length()) {
                idxT++;
                idxS++;
            }
        }

        return idxS == s.length();
    }

    /**
     * If s is very big:
     * Store all indices of chars in t
     * For each char in s go over indices of t and find next if exist - if all can be found - s is a substring
     *
     * Runtime: 21.13%
     * Memory Usage: 5.14%
     */
    public boolean isSubsequenceBinarySearch(String s, String t) {

        if (s == null || t == null) return false;
        if (s.isEmpty()) return true;

        List<Integer>[] indices = new List[26];

        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            if (indices[idx] == null) indices[idx] = new ArrayList<>();
            indices[idx].add(i); // Add position for this character;
        }

        int prevIdx = 0; // Index of previous character
        for (char sChar : s.toCharArray()) {
            // Search for location of next s char in t string
            int sIdx = sChar - 'a';
            List<Integer> tIndices = indices[sIdx];
            if (tIndices == null) return false;

            int tIdx = Collections.binarySearch(tIndices, prevIdx);
            if (tIdx < 0) {
                tIdx = -tIdx - 1; // Insertion point is returned, we need index before it
            }
            if (tIdx == tIndices.size()) return false; // Cannot be retrieved
            prevIdx = tIndices.get(tIdx) + 1; // Location of matched char in t string
        }

        return true; // we haven't found any issues
    }

}
