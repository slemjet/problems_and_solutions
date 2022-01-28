package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Design Add and Search Words Data Structure
 */
public class DesignAddAndSearchWordsDataStructure {

    /**
     * Runtime: 71.37%
     * Memory Usage: 50.29%
     */
    static class WordDictionary {

        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;

            for (char aChar : word.toCharArray()) {
                if (!curr.subNodes.containsKey(aChar)) {
                    Node node = new Node(aChar);
                    curr.subNodes.put(aChar, node);
                }
                curr = curr.subNodes.get(aChar);
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }

        private boolean search(String word, Node root, int idx) {

            if (word.isEmpty() || idx > word.length() || root == null) return false;

            while (idx < word.length()) {
                char aChar = word.charAt(idx++);

                if (aChar == '.') {
                    for (Node node : root.subNodes.values()) {
                        if (search(word, node, idx)) {
                            return true;
                        }
                    }
                    return false;
                } else if (root.subNodes.containsKey(aChar)) {
                    root = root.subNodes.get(aChar);
                } else {
                    return false;
                }
            }
            return root.isWord;
        }

        static class Node {
            char value;
            Map<Character, Node> subNodes;
            boolean isWord;

            public Node() {
                subNodes = new HashMap<>();
            }

            public Node(char value) {
                subNodes = new HashMap<>();
                this.value = value;
            }

            public Node(Map<Character, Node> subNodes) {
                this.subNodes = subNodes;
            }
        }
    }
}
