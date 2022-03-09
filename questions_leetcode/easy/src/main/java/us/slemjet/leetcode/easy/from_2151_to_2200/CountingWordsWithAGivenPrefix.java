package us.slemjet.leetcode.easy.from_2151_to_2200;

import java.util.stream.Stream;

/**
 * 2185. Counting Words With a Given Prefix
 */
public class CountingWordsWithAGivenPrefix {

    /**
     * Runtime: 26.19%
     * Memory Usage: 99.72%
     */
    public int prefixCount(String[] words, String pref) {

        int result = 0;

        for (String word : words) {
            if (word.length() < pref.length()) continue;
            int wIdx = 0;
            int pIdx = 0;
            boolean match = true;
            while (pIdx < pref.length()) {
                if (word.charAt(wIdx++) != pref.charAt(pIdx++)) {
                    match = false;
                    break;
                }
            }
            if (match) result++;
        }

        return result;
    }

    /**
     * Runtime: 17.74%
     * Memory Usage: 7.04%
     */
    public int prefixCountShort(String[] words, String pref) {
        return (int) Stream.of(words).filter(str -> str.startsWith(pref)).count();
    }
}
