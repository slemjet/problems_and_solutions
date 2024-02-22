package us.slemjet.leetcode.medium.tasks_2701_2750;

import java.util.Arrays;

/**
 * 2707. Extra Characters in a String
 */
public class ExtraCharactersInAString {

    /**
     * Top To Bottom + Memoization + Trie
     * Time: O(n^2 + m*k)  ->  96.69%
     * Space:O(n + m*k)    ->  61.32%
     */
    public int minExtraCharTopToBottom(String s, String[] dictionary) {

        TrieNode trie = createTrie(dictionary);
        Integer[] memo = new Integer[s.length()];
        return minExtraCharTopToBottom(s.toCharArray(), 0, trie, memo);
    }

    private int minExtraCharTopToBottom(char[] chars, int idx, TrieNode trie, Integer[] memo) {

        if (idx >= chars.length) {
            return 0;
        }

        if (memo[idx] == null) {
            int minExtraChars = Integer.MAX_VALUE;

            // Try to find in the trie
            int cndIdx = idx;
            TrieNode nextNode = trie.nextNodes[chars[cndIdx] - 'a'];
            while (cndIdx < chars.length && nextNode != null) {
                // This char is in the trie
                if (nextNode.word != null) {
                    // Can pick this word
                    int useCount = minExtraCharTopToBottom(chars, idx + nextNode.word.length(), trie, memo);
                    minExtraChars = Math.min(minExtraChars, useCount);
                }
                nextNode = ++cndIdx < chars.length ? nextNode.nextNodes[chars[cndIdx] - 'a'] : null;
            }

            // Or just skip this one
            int skipCount = 1 + minExtraCharTopToBottom(chars, idx + 1, trie, memo);
            minExtraChars = Math.min(minExtraChars, skipCount);

            memo[idx] = minExtraChars;
        }

        return memo[idx];
    }

    /**
     * Bottom Up - Tabulation
     * Time: O(n^2 + m*k)   ->  97.04%
     * Space:O(n + m-k)     ->  61.64%
     */
    public int minExtraCharBottomUp(String s, String[] dictionary) {

        TrieNode trie = createTrie(dictionary);

        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[dp.length - 1] = 0;

        for (int i = dp.length - 2; i >= 0; i--) {

            // Skip this char
            dp[i] = 1 + dp[i + 1];

            // Try to find in the trie
            int cndIdx = i;
            TrieNode nextNode = trie.nextNodes[chars[cndIdx] - 'a'];
            while (nextNode != null) {
                // This char is in the trie
                if (nextNode.word != null) {
                    // Can pick this word
                    dp[i] = Math.min(dp[i], dp[i + nextNode.word.length()]);
                }
                nextNode = ++cndIdx < chars.length ? nextNode.nextNodes[chars[cndIdx] - 'a'] : null;
            }
        }

        return dp[0];
    }

    private TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            char[] chars = word.toCharArray();
            for (char letter : chars) {
                // Get index of char - to store next node location
                int idx = letter - 'a';
                TrieNode next = current.nextNodes[idx] != null ? current.nextNodes[idx] : new TrieNode();
                current.nextNodes[idx] = next;
                current = next;
            }
            current.word = word;
        }
        return root;
    }

    private static class TrieNode {
        // Next nodes
        TrieNode[] nextNodes = new TrieNode[26];
        String word;
    }
}
