package us.slemjet.leetcode.medium.strings;

import java.util.*;

/**
 * Runtime: 31 ms, faster than 33.83%
 * Memory Usage: 41.3 MB, less than 5.18%
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> num = new ArrayList<>();

        if (p.length() > s.length())
            return num;

        // initiate reference map
        Map<Character, Integer> reference = new HashMap<>();
        char[] pChars = p.toCharArray();
        for (char pChar : pChars)
            reference.put(pChar, reference.getOrDefault(pChar, 0) + 1);

        int left = 0;
        int right = 0;
        int matchCount = 0;
        char[] sChars = s.toCharArray();

        // create slide window
        Map<Character, Integer> current = new HashMap<>();
        while (right < p.length()) {
            // handle right index increase (adding char)
            char rChar = sChars[right];
            int rCount = current.getOrDefault(rChar, 0);
            current.put(rChar, ++rCount);

            if (reference.containsKey(rChar) && (rCount == reference.get(rChar)))
                matchCount++;
            else if (reference.containsKey(rChar) && rCount == reference.get(rChar) + 1)
                matchCount--;

            // check if number of matches = length of pattern string
            if (matchCount == reference.size())
                num.add(left);

            right++;
        }

        // move slide window and check if current is equal to reference;
        while (right < s.length()) {
            // handle right index increase (adding char)
            char rChar = sChars[right];
            int rCount = current.getOrDefault(rChar, 0);
            current.put(rChar, ++rCount);

            if (reference.containsKey(rChar) && rCount == reference.get(rChar))
                matchCount++;
            else if (reference.containsKey(rChar) && rCount == reference.get(rChar) + 1)
                matchCount--;

            right++;

            // handle left index increase (removing char)
            char lChar = sChars[left];
            int lCount = current.getOrDefault(lChar, 0);
            current.put(lChar, --lCount);

            if (reference.containsKey(lChar) && lCount == reference.get(lChar))
                matchCount++;
            else if (reference.containsKey(lChar) && lCount == reference.get(lChar) - 1)
                matchCount--;

            left++;

            // check if number of matches = length of pattern string
            if (matchCount == reference.size())
                num.add(left);
        }

        return num;
    }

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

        char[] sChars = s.toCharArray();
        int left = 0;
        int right = 0;
        int matchCount = 0;

        // create slide window
        int[] current = new int[26];

        // move slide window and check if current is equal to reference;
        while (right < s.length()) {
            // handle right index increase (adding char)
            int rChar = sChars[right] - 'a';
            current[rChar]++;

            if (reference[rChar] > 0 && current[rChar] == reference[rChar])
                matchCount++;
            else if (reference[rChar] > 0 && current[rChar] == reference[rChar] + 1)
                matchCount--;

            right++;

            if (right > p.length()) {
                // handle left index increase (removing char)
                int lChar = sChars[left] - 'a';
                current[lChar]--;

                if (reference[lChar] > 0 && current[lChar] == reference[lChar])
                    matchCount++;
                else if (reference[lChar] > 0 && current[lChar] == reference[lChar] - 1)
                    matchCount--;

                left++;
            }

            // check if number of matches = length of pattern string
            if (matchCount == refMatch)
                num.add(left);
        }

        return num;
    }
}
