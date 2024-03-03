package us.slemjet.leetcode.medium.tasks_201_250;

/**
 * 245. Shortest Word Distance III
 */
public class ShortestWordDistanceIII {

    /**
     *  Time: O(n)  ->  99.07%
     *  Space:O(1)  ->  54.67%
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

        int result = Integer.MAX_VALUE;

        int lastIdx1 = -1;
        int lastIdx2 = -1;
        boolean sameWords = word1.equals(word2);

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];

            if (sameWords) {
                if (word1.equals(word)) { // Need to track previous index of the same word
                    if (lastIdx1 != -1) {
                        result = Math.min(result, i - lastIdx1);
                    }
                    lastIdx1 = i;
                }
            } else {
                // If word match - compute distance to previous occurrence of other word
                if (word1.equals(word)) {
                    if (lastIdx2 != -1) {
                        result = Math.min(result, i - lastIdx2);
                    }
                    lastIdx1 = i;
                }

                if (word2.equals(word)) {
                    if (lastIdx1 != -1) {
                        result = Math.min(result, i - lastIdx1);
                    }
                    lastIdx2 = i;
                }
            }
        }

        return result;
    }
}
