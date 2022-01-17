package us.slemjet.leetcode.hard.from_1_to_50;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0)
            return result;

        int wordLength = words[0].length(); // store word length
        Map<String, Integer> requested = new HashMap<>();
        for (String word : words) {
            if (requested.containsKey(word)) {
                requested.put(word, requested.get(word) + 1); // increment existing word number
            } else
                requested.put(word, 1); // new word is added
        }

        for (int i = 0; i < wordLength; i++) { // we need also to process index shift less then word length
            Map<String, Integer> current = new HashMap<>(); // store current fitting values

            int wordsCount = 0;
            int startIndex = i; // second pointer we move once word is completely processed

            for (int j = i; j <= s.length() - wordLength; j = j + wordLength) {

                String nextWord = s.substring(j, j + wordLength);
                if (requested.containsKey(nextWord)) {

                    // add to current values map
                    if (current.containsKey(nextWord))
                        current.put(nextWord, current.get(nextWord) + 1);
                    else
                        current.put(nextWord, 1);

                    wordsCount++;

                    //check current map for redundant values and shift start pointer if necessary
                    while (current.get(nextWord) > requested.get(nextWord)) {
                        // remove previous word (as it is redundant)
                        String prevWord = s.substring(startIndex, startIndex + wordLength);
                        current.put(prevWord, current.get(prevWord) - 1);
                        wordsCount--;
                        startIndex += wordLength;
                    }

                    if (wordsCount == words.length) {
                        // result found
                        result.add(startIndex);

                        // remove previous word (as it is part of result)
                        String prevWord = s.substring(startIndex, startIndex + wordLength);
                        current.put(prevWord, current.get(prevWord) - 1);
                        wordsCount--;
                        startIndex += wordLength;
                    }
                } else {
                    // reset all results
                    current = new HashMap<>();
                    startIndex = j + wordLength;
                    wordsCount = 0;
                }
            }
        }
        return result;
    }
}
