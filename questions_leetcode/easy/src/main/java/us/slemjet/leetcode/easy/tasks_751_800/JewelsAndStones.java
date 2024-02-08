package us.slemjet.leetcode.easy.tasks_751_800;

/**
 * 771. Jewels and Stones
 */
public class JewelsAndStones {

    /**
     * Runtime: 1 ms, faster than 82.64%
     * Memory Usage: 37.7 MB, less than 87.30%
     */
    public int numJewelsInStones(String J, String S) {

        int result = 0;

        // Reference array
        int[] ref = new int[256];
        for (char rChar : J.toCharArray())
            ref[rChar - 'A']++;

        // Compare against reference. If contains - +1
        for (char sChar : S.toCharArray())
            if (ref[sChar - 'A'] > 0)
                result++;

        return result;
    }

}
