package us.slemjet.leetcode.hard.tasks_100_150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. Word Ladder
 */
public class WordLadder {

    /**
     * Runtime: 97.99%
     * Memory Usage: 92.33%
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;

        if (!wordList.contains(endWord)) return result;

        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();

        start.add(beginWord);
        dictionary.remove(beginWord);
        end.add(endWord);
        dictionary.remove(endWord);
        result++;

        while (!start.isEmpty()) {
            Set<String> nextLevelWords = new HashSet<>(); // possible words for next level
            for (String word : start) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    char backup = wordChars[i];
                    // change current letter with all alphabet and see if there is a match on the words
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[i] = c;
                        String probeWord = String.valueOf(wordChars);
                        if (end.contains(probeWord)) { // solution found
                            return ++result;
                        }
                        if (dictionary.contains(probeWord)) {
                            nextLevelWords.add(probeWord);
                            dictionary.remove(probeWord); // is visited
                        }
                    }
                    wordChars[i] = backup;
                }
            }

            // switch sides - choose smaller between next and end for next start
            // minimize number of words that needs to be walked through
            if (nextLevelWords.size() > end.size()) {
                start = end;
                end = nextLevelWords;
            } else {
                start = nextLevelWords;
            }
            result++;
        }

        return 0;
    }
}
