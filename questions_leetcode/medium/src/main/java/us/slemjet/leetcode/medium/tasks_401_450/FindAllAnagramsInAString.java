package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 */
public class FindAllAnagramsInAString {


    /**
     * Runtime: 7 ms, faster than 80.87%
     * Memory Usage: 40.3 MB, less than 65.66%
     */
    public List<Integer> findAnagramsArray(String s, String p) {

        List<Integer> num = new ArrayList<>();

        if (p.length() > s.length())
            return num;

        // initiate reference array
        int[] reference = new int[26];

        for (char pChar : p.toCharArray())
            reference[pChar - 'a']++;

        int refMatch = (int) Arrays.stream(reference).filter(ints -> ints > 0).count();

        int left = 0, right = 0;
        int matchCount = 0;

        // create slide window
        int[] current = new int[26];

        // move slide window and check if current is equal to reference;
        while (right < s.length()) {
            // handle right index increase (adding char)
            int rChar = s.charAt(right) - 'a';
            current[rChar]++;

            if (reference[rChar] > 0) {
                if (current[rChar] == reference[rChar]) matchCount++; // Started to match
                else if (current[rChar] == reference[rChar] + 1) matchCount--; // Stopped to match
            }
            right++;

            if (right > p.length()) {
                // handle left index increase (removing char)
                int lChar = s.charAt(left) - 'a';
                current[lChar]--;

                if (reference[lChar] > 0) {
                    if (current[lChar] == reference[lChar]) matchCount++; // Started to match
                    else if (current[lChar] == reference[lChar] - 1) matchCount--; // Stopped to match
                }
                left++;
            }

            // check if number of matches = length of pattern string
            if (matchCount == refMatch)
                num.add(left);
        }

        return num;
    }
}
