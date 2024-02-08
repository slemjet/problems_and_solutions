package us.slemjet.leetcode.hard.tasks_1201_1250;

import java.util.Arrays;

/**
 * 1220. Count Vowels Permutation
 */
public class CountVowelsPermutation {

    /**
     * Runtime:  68.76%
     * Memory Usage: 52.13%
     */
    public int countVowelPermutation(int n) {

        int modulo = (int) (Math.pow(10, 9) + 7); // We use modulo to handle super large numbers

        int[] counts = new int[]{1, 1, 1, 1, 1};

        while (--n > 0) {
            int[] tmpCounts = Arrays.copyOf(counts, counts.length);

            // 'a' can go after 'e', 'i', 'u'
            tmpCounts[0] = (int) (((long) counts[1] + counts[2] + counts[4]) % modulo);

            // 'e' can go after 'a', 'i'
            tmpCounts[1] = (int) (((long) counts[0] + counts[2]) % modulo);

            // 'i' can go after 'e', 'o'
            tmpCounts[2] = (int) (((long) counts[1] + counts[3]) % modulo);

            // 'o' can go after 'i'
            tmpCounts[3] = counts[2] % modulo;

            // 'u' can go after 'i', 'o'
            tmpCounts[4] = (int) (((long) counts[2] + counts[3]) % modulo);

            counts = tmpCounts;
        }

        return (int) (((long) counts[0] + counts[1] + counts[2] + counts[3] + counts[4]) % modulo);
    }
}
