package us.slemjet.leetcode.medium.tasks_1001_1050;

import java.util.*;

/**
 * 1048. Longest String Chain
 */
public class LongestStringChain {

    /**
     * Top To Bottom + Memoization
     * Time: O(l^2 * n) ->  84.70%
     * Space:O(n)       ->  16.32%
     */
    public int longestStrChainTopToBottom(String[] words) {

        int result = 0;
        Set<String> existingWords = new HashSet<>(words.length);
        Collections.addAll(existingWords, words);
        Map<String, Integer> memo = new HashMap<>();

        for (String word : words) {
            result = Math.max(result, longestStrChainTopToBottom(word, existingWords, memo));
        }

        return result;
    }

    private int longestStrChainTopToBottom(String word, Set<String> existingWords, Map<String, Integer> memo) {

        if (!memo.containsKey(word)) {
            int maxChain = 1;

            for (int i = 0; i < word.length(); i++) {
                String candidate = word.substring(0, i) + word.substring(i + 1);
                if (existingWords.contains(candidate)) {
                    maxChain = Math.max(maxChain, 1 + longestStrChainTopToBottom(candidate, existingWords, memo));
                }
            }

            memo.put(word, maxChain);
        }
        return memo.get(word);
    }

    /**
     * Bottom Up
     * Time: O(l^2 + n*logn) ->  54.23%
     * Space:O(n)            ->  61.49%
     */
    public int longestStrChainBottomUp(String[] words) {

        int result = 1; //   Max chain
        Arrays.sort(words, Comparator.comparing(String::length)); // We need to start from the smallest strings as base case
        Map<String, Integer> chains = new HashMap<>();

        // For each string we search if exists another string that it can for a chain with

        for (String word : words) {
            // Initially put 1 as a minimum chain with itself
            chains.put(word, 1);

            // Start removing characters and check if exist such shorter string to create chain with
            for (int i = 0; i < word.length(); i++) {
                String candidate = word.substring(0, i) + word.substring(i + 1);

                if (chains.containsKey(candidate)) {
                    // We can add to existing chain
                    int maxChain = Math.max(chains.get(word), chains.get(candidate) + 1);
                    chains.put(word, maxChain);
                    result = Math.max(result, maxChain);
                }
            }
        }

        return result;
    }
}
