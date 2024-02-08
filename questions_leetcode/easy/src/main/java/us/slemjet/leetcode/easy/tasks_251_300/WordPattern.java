package us.slemjet.leetcode.easy.tasks_251_300;

import java.util.HashSet;
import java.util.Set;

/**
 * 290. Word Pattern
 */
public class WordPattern {

    /**
     * Runtime: 87.11%
     * Memory Usage: 37.62%
     */
    public boolean wordPattern(String pattern, String s) {

        String[] mappedChars = new String[26];
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        Set<String> mappedWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i) - 'a';
            String word = words[i];
            if (mappedChars[idx] == null && !mappedWords.contains(word)) {
                mappedChars[idx] = word; // Add new
                mappedWords.add(word);
            } else {
                String mappedWord = mappedChars[idx];
                if (mappedWord == null || !mappedWord.equals(word)) return false; // Words mismatch
            }
        }

        return true;
    }
}
