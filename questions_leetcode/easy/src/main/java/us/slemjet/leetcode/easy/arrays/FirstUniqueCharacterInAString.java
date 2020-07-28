package us.slemjet.leetcode.easy.arrays;

import java.util.Arrays;

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
                positions[index] = i;
            } else if (positions[index] > -1) { // >=0 -> second occurrence
                positions[index] = -2;
            }
        }

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
     * Memory Usage: 46.8 MB, less than 5.06%
     */
    public int firstUniqChar2Pointers(String s) {

        if (s == null || s.length() == 0)
            return -1;

        char[] charArray = s.toCharArray();

        int[] count = new int[26];

        // use 2 pointers to check duplicates
        int slowIdx = 0; // slow pointer for first unique char
        int fastIdx = 1; // fast pointer for the next checked char

        count[charArray[slowIdx] - 'a']++; // firs occurrence of slowIdx element

        while (fastIdx < charArray.length) {

            count[charArray[fastIdx] - 'a']++; // first occurrence of fastIdx element

            while (slowIdx < charArray.length && count[charArray[slowIdx] - 'a'] > 1)
                slowIdx++; // skip duplicates with count > 1

            if (slowIdx == charArray.length)
                return -1; // reached end of string - all duplicates

            if (count[charArray[slowIdx] - 'a'] == 0) { // first occurrence
                fastIdx = slowIdx + 1; // shift fast right
                count[charArray[slowIdx] - 'a']++; // increment occurred item
            } else {
                fastIdx++; // next fast
            }
        }
        return slowIdx;
    }
}
