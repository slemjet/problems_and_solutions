package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.stream.IntStream;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 */
public class MaximumXOROfTwoNumbersInAnArray {

    /**
     * Store current structure in a Trie (as a Binary Search tree)
     * Start from MSB (mos significant byte)
     * Go over the structure trying to follow opposite byte if possible to maximize XOR
     *
     * Runtime: 90.40%
     * Memory Usage: 55.57%
     */
    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();
        int max = IntStream.of(nums).max().orElse(0);
        int level = 0;
        while (1 << level < max) {
            level++;
        }
        trie.level = level; // Get tree level/depth - it's the maximum value

        for (int num : nums) { // Generate Trie
            trie.insert(num);
        }

        int maxXor = Integer.MIN_VALUE;

        for (int num : nums) {
            int currXor = num ^ trie.search(num);
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }

    static class Trie {
        int level;
        Node root = new Node();

        public void insert(int num) {
            Node curr = root;
            for (int i = level; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 1) {
                    // Add to the right
                    if (curr.right == null) {
                        curr.right = new Node();
                        curr.right.nodeVal = 1;
                    }
                    curr = curr.right;
                } else { // Add to the left
                    if (curr.left == null) {
                        curr.left = new Node();
                        curr.left.nodeVal = 0;
                    }
                    curr = curr.left;
                }
                if (i == 0)
                    curr.value = num;
            }
        }

        public int search(int num) {
            Node currNode = root;
            for (int i = level; i >= 0; i--) {
                int expectedBit = 1 - (num >> i) & 1; // We need opposite bit for current: 1-> 0, 0 -> 1
                if (expectedBit == 1 && currNode.right != null || currNode.left == null) { // Expected 1 (right node) but it can be null
                    currNode = currNode.right;
                } else {
                    currNode = currNode.left;
                }
            }
            return currNode.value;
        }

        class Node {
            int nodeVal;
            Integer value;

            Node left;
            Node right;

            public Node() {
            }

            @Override
            public String toString() {
                return "Node{" +
                        "nodeVal=" + nodeVal +
                        ", value=" + value +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }
    }
}
