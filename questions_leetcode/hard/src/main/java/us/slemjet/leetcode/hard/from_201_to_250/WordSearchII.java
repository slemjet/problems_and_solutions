package us.slemjet.leetcode.hard.from_201_to_250;

import java.util.*;

/**
 * 212. Word Search II
 */
public class WordSearchII {

    /**
     * Optimized Version
     * Runtime: 73.20%
     * Memory Usage: 49.53%
     */
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        TrieNode trie = createTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode trie, List<String> result) {

        char letter = board[i][j];
        int idx = letter - 'a';

        if (letter == '#' || trie.nextNodes[idx] == null) return; // Reached end

        trie = trie.nextNodes[idx];
        if (trie.word != null) {
            result.add(trie.word);
            trie.word = null; // to avoid duplicates
        }

        board[i][j] = '#'; // Mark next
        if (i > 0) dfs(board, i - 1, j, trie, result);
        if (i < board.length - 1) dfs(board, i + 1, j, trie, result);
        if (j > 0) dfs(board, i, j - 1, trie, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, trie, result);
        board[i][j] = letter; // Un-mark next

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

    // ################################## VARIANT 2 ####################

    /**
     * Basic version using standard Trie
     * Runtime: 5.03%
     * Memory Usage: 10.27%
     */
    public List<String> findWords2(char[][] board, String[] words) {

        Set<String> result = new HashSet<>();

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", visited, trie, result);
            }
        }

        return new ArrayList<>(result);

    }

    private void dfs(char[][] board, int i, int j, String word, boolean[][] visited, Trie trie, Set<String> result) {
        if (visited[i][j]) return; // Visited - skip

        word += board[i][j];

        if (!trie.startsWith(word)) return; // No word with prefix - skip

        if (trie.search(word)) result.add(word); // Found word match

        visited[i][j] = true; // Traverse the board
        if (i > 0) dfs(board, i - 1, j, word, visited, trie, result);
        if (i < board.length - 1) dfs(board, i + 1, j, word, visited, trie, result);
        if (j > 0) dfs(board, i, j - 1, word, visited, trie, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, word, visited, trie, result);
        visited[i][j] = false;
    }

    public static class Trie {

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

            if (word != null && word.length() > 0) {
                char[] chars = word.toCharArray();

                Node current = root;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i];
                    Node node = current.getChildren().get(index);
                    if (node == null) {
                        node = new Node(chars[i]);
                        current.getChildren().put(index, node);
                    }

                    current = node;
                }

                current.setWord(true);
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {

            if (word != null && word.length() > 0) {
                char[] chars = word.toCharArray();

                Node current = root;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i];
                    Node node = current.getChildren().get(index);
                    if (node == null) {
                        return false;
                    }
                    current = node;
                }

                return current.isWord();
            }

            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {

            if (prefix != null && prefix.length() > 0) {
                char[] chars = prefix.toCharArray();

                Node current = root;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i];
                    Node node = current.getChildren().get(index);
                    if (node == null) {
                        return false;
                    }
                    current = node;
                }

                return !current.getChildren().isEmpty() || current.isWord();
            }

            return false;
        }
    }

    static class Node {
        private char value;
        private Map<Integer, Node> children = new HashMap<>();
        private boolean isWord;

        public Node() {
        }

        public Node(char aChar) {
            this.value = aChar;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public Map<Integer, Node> getChildren() {
            return children;
        }

        public void setChildren(Map<Integer, Node> children) {
            this.children = children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

}
