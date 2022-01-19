package us.slemjet.leetcode.easy.from_351_to_400;

import java.util.Arrays;

/**
 * 387. First Unique Character in a String
 */
public class FirstUniqueCharacterInAString {

    /**
     * Store positions of the unique char
     * Runtime: 3 ms, faster than 98.92%
     * Memory Usage: 40.1 MB, less than 30.53%
     */
    public int firstUniqChar(String s) {

        char[] charArray = s.toCharArray();

        int[] positions = new int[26];
        Arrays.fill(positions, -1);

        for (int i = 0; i < charArray.length; i++) {

            int index = charArray[i] - 'a';

            // -1 -> firs occurrence
            if (positions[index] == -1) {
                positions[index] = i; // First occurrence index
            } else if (positions[index] > -1) { // >=0 -> second occurrence
                positions[index] = -2; // Mark second occurrence as - 2
            }
        }

        // Go through the indices to find first unique
        int result = Integer.MAX_VALUE;
        boolean hasValue = false;
        for (int aChar : positions) {
            if (aChar >= 0 && aChar < result) {
                hasValue = true;
                result = aChar;
            }
        }

        return hasValue ? result : -1;
    }

    /**
     * 2 pointers solution one - for unique and one for traversing
     * Runtime: 13 ms, faster than 68.76%
     * Memory Usage: 46.8 MB, less than 29.23%
     */
    public int firstUniqChar2Pointers(String s) {

        if (s == null || s.length() == 0) return -1;

        char[] charArray = s.toCharArray();
        int[] count = new int[26];

        // use 2 pointers to check duplicates
        int uniqueIdx = 0; // slow pointer for current unique char
        int checkedIdx = 0; // fast pointer for the next checked char

        while (checkedIdx < charArray.length) {

            count[charArray[checkedIdx] - 'a']++; // first occurrence of checkedIdx element

            while (uniqueIdx < charArray.length && count[charArray[uniqueIdx] - 'a'] > 1)
                uniqueIdx++; // skip duplicates with count > 1

            if (uniqueIdx == charArray.length) return -1; // reached end of string - all duplicates

            if (count[charArray[uniqueIdx] - 'a'] == 0) { // first occurrence
                count[charArray[uniqueIdx] - 'a']++; // increment occurred item
                checkedIdx = uniqueIdx; // shift fast right
            }
            checkedIdx++; // next fast
        }
        return uniqueIdx;
    }
}
