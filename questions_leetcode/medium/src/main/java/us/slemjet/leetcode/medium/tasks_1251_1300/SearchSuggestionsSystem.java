package us.slemjet.leetcode.medium.tasks_1251_1300;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1268. Search Suggestions System
 */
public class SearchSuggestionsSystem {

    /**
     * Time: O(n*m) ->  71.61%
     * Space:O(n*m) ->  88.04%
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();

        MultiWordTrie.TrieNode node = MultiWordTrie.createTrie(products);

        for (char letter : searchWord.toCharArray()) {
            List<String> currLetterResult = new ArrayList<>();
            result.add(currLetterResult);
            if (node != null) {
                node = node.nextNodes[letter - 'a'];
                if (node != null) {
                    for (int i = 0; i < 3; i++) {
                        if (!node.words.isEmpty()) {
                            currLetterResult.add(node.words.poll());
                        }
                    }
                }
            }
        }

        return result;
    }

    public static class MultiWordTrie {

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
                    next.words.add(word);
                    current = next;
                }
            }
            return root;
        }

        public static class TrieNode {
            // Next nodes
            TrieNode[] nextNodes = new TrieNode[26];
            Queue<String> words = new PriorityQueue<>();
        }
    }
}
