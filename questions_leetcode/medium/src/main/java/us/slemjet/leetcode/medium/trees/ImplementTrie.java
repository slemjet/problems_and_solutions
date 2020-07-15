package us.slemjet.leetcode.medium.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImplementTrie {

    static class Trie {

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

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

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


    /**
     * Runtime: 15.55%
     * Memory: 5.02%
     */
    static class TrieRed {

        private NodeRed root;

        /**
         * Initialize your data structure here.
         */
        public TrieRed() {
            root = new NodeRed();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

            if (word != null && word.length() > 0) {
                char[] chars = word.toCharArray();

                NodeRed current = root;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    NodeRed node = current.getChildren()[index];
                    if (node == null) {
                        node = new NodeRed();
                        current.getChildren()[index] = node;
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

                NodeRed current = root;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    NodeRed node = current.getChildren()[index];
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

                NodeRed current = root;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    NodeRed node = current.getChildren()[index];
                    if (node == null) {
                        return false;
                    }
                    current = node;
                }

                return Arrays.stream(current.getChildren()).anyMatch(Objects::nonNull) || current.isWord();
            }

            return false;
        }
    }

    static class NodeRed {

        private NodeRed[] children = new NodeRed[26];
        private boolean isWord;

        public NodeRed() {
        }

        public NodeRed(NodeRed[] children) {
            this.children = children;
        }

        public NodeRed[] getChildren() {
            return children;
        }

        public void setChildren(NodeRed[] children) {
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
