package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import us.slemjet.leetcode.medium.tasks_201_250.ImplementTrie;

class ImplementTrieTest {

    @Test
    void test() {
        ImplementTrie.Trie trie = new ImplementTrie.Trie();

        trie.insert("apple");
        Assertions.assertThat(trie.search("apple")).isTrue();   // returns true
        Assertions.assertThat(trie.search("app")).isFalse();     // returns false

        Assertions.assertThat(trie.startsWith("app")).isTrue(); // returns true
        trie.insert("app");


        Assertions.assertThat(trie.search("app")).isTrue();     // returns true
    }

    @Test
    void test2() {
        ImplementTrie.TrieRed trieRed = new ImplementTrie.TrieRed();

        trieRed.insert("apple");
        Assertions.assertThat(trieRed.search("apple")).isTrue();   // returns true
        Assertions.assertThat(trieRed.search("app")).isFalse();     // returns false

        Assertions.assertThat(trieRed.startsWith("app")).isTrue(); // returns true
        trieRed.insert("app");


        Assertions.assertThat(trieRed.search("app")).isTrue();     // returns true
    }
}
