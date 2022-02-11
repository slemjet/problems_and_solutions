package us.slemjet.leetcode.medium.tasks_551_600;

/**
 * 567. Permutation in String
 */
public class PermutationInString {

    /**
     * Use sliding window of a size of s1, count matching chars if they match with reference - return true
     *
     * Runtime: 92.54%
     * Memory Usage: 36.34%
     */
    public boolean checkInclusion(String s1, String s2) {

        int[] ref = new int[26]; // Reference array

        int refMatch = 0; // Number of chars to match
        for (char refChar : s1.toCharArray()) {
            int refIdx = refChar - 'a';
            ref[refIdx]++;
            if (ref[refIdx] == 1)
                refMatch++;
        }

        // Initiate sliding window
        int left = 0;
        int right = 0;
        int[] curr = new int[26]; // Current array = to match against reference
        int currMatch = 0;

        while (right < s2.length()) {

            // right
            int rIdx = s2.charAt(right) - 'a';
            curr[rIdx]++;

            if (curr[rIdx] == ref[rIdx]) currMatch++; // Match count with reference frequency
            if (curr[rIdx] == ref[rIdx] + 1) currMatch--; // No longer match in count with ref frequency

            right++;

            if (right > s1.length()) { // Start moving left index to keep sliding window size
                // left
                int lIdx = s2.charAt(left) - 'a';
                curr[lIdx]--;

                if (curr[lIdx] == ref[lIdx]) currMatch++;
                if (curr[lIdx] == ref[lIdx] - 1) currMatch--;

                left++;
            }

            if (currMatch == refMatch) return true;
        }
        return false;
    }
}
