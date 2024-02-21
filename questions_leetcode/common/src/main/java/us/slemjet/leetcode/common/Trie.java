package us.slemjet.leetcode.common;

public class Trie {

    public static TrieNode createTrie(String[] words) {
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

    public static class TrieNode {
        // Next nodes
        TrieNode[] nextNodes = new TrieNode[26];
        String word;
    }
}
