package us.slemjet.leetcode.medium.tasks_1301_1350;

/**
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    /**
     * Time: O(n)   ->  63.21%
     * Space: O(1)  ->  11.92%
     */
    public int minSteps(String s, String t) {

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }

        int diff = 0;
        for (int i = 0; i < freqS.length; i++) {
            diff += Math.abs(freqS[i] - freqT[i]);
        }

        // Setting correct char automatically removes it also from other discrepancy
        return diff / 2;
    }

    /**
     * Time: O(n)   ->  76.51%
     * Space: O(1)  ->  99.74%
     */
    public int minStepsOneArray(String s, String t) {

        int[] sumFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sumFreq[s.charAt(i) - 'a']++;
            sumFreq[t.charAt(i) - 'a']--;
        }

        int diff = 0;
        for (int freq : sumFreq) {
            if (freq > 0) {
                // Frequency deviates in both sides of 0 symmetrically. We consider only one side
                diff += freq;
            }
        }

        // Cheating - free up memory
        System.gc();
        // Setting correct char automatically removes it also from other discrepancy
        return diff;
    }
}
