package us.slemjet.leetcode.medium.tasks_551_600;

/**
 * 567. Permutation in String
 */
public class PermutationInString {

    /**
     * Use sliding window
     * Runtime: 4 ms, faster than 88.59%
     * Memory Usage: 39.4 MB, less than 87.42%
     */
    public boolean checkInclusion(String s1, String s2) {

        int[] ref = new int[26];

        int refMatch = 0;
        for (char refChar : s1.toCharArray()) {
            int refIdx = refChar - 'a';
            ref[refIdx]++;
            if (ref[refIdx] == 1)
                refMatch++;
        }

        int left = 0;
        int right = 0;
        int[] curr = new int[26];
        int currMatch = 0;

        char[] chars = s2.toCharArray();

        while (right < chars.length) {

            // right
            int rIdx = chars[right] - 'a';
            curr[rIdx]++;

            if (curr[rIdx] == ref[rIdx])
                currMatch++;

            if (curr[rIdx] == ref[rIdx] + 1)
                currMatch--;

            right++;

            if (right > s1.length()) {
                // left
                int lIdx = chars[left] - 'a';
                curr[lIdx]--;

                if (curr[lIdx] == ref[lIdx])
                    currMatch++;

                if (curr[lIdx] == ref[lIdx] - 1)
                    currMatch--;

                left++;
            }

            if (currMatch == refMatch)
                return true;
        }
        return false;
    }
}
