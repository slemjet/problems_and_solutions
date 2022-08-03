package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.ArrayList;
import java.util.List;

/**
 * 916. Word Subsets
 */
public class WordSubsets {

    /**
     * Calculate max count of every char and compare against every candidate word
     * Runtime: 78.87%
     * Memory Usage: 20.79%
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> result = new ArrayList<>();

        // Contains maximum number of occurrence per char
        int[] maxCounts = new int[26];

        for (String word2 : words2) {
            int[] currCount = new int[26];
            for (char char2 : word2.toCharArray()) {
                int index2 = char2 - 'a';
                currCount[index2]++;
            }

            for (int i = 0; i < currCount.length; i++) {
                maxCounts[i] = Math.max(maxCounts[i], currCount[i]);
            }
        }

        for (String word1 : words1) {
            boolean isValid = true;
            int[] currCount = new int[26];
            for (char char1 : word1.toCharArray()) {
                int index1 = char1 - 'a';
                currCount[index1]++;
            }

            // Check if current word can cover max count of every char
            for (int i = 0; i < currCount.length; i++) {
                if (currCount[i] < maxCounts[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(word1);
            }
        }
        return result;
    }
}
